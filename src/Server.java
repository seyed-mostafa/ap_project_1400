import Objects.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

import static Database.Database.customers;
import static Database.Database.restaurants;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class ClientHandler implements Runnable {
    static int clientCounter = 0;
    Socket socket;
    DataInputStream dataIn;
    DataOutputStream dataOut;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        dataIn = new DataInputStream(socket.getInputStream());
        dataOut = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        System.out.println("client " + ++clientCounter + " added.");

        String who = ""; // Seller Or Customer

        try {
            who = dataIn.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int currentIndex = 0;

        if (who.equals("Seller")) {

            try {

                while (true) {

                    String command = dataIn.readLine();

                    if (command.contains("Seller")) {
                        command = dataIn.readLine();
                    }
                    System.out.println(command);

                    if (command.startsWith("Entering")) { // format: Entering::phone::password

                        boolean validUser = false;
                        String[] list = command.split("::");
                        String inputPhoneNumberEnter = list[1];
                        String inputPasswordEnter = list[2];

                        for (int i = 0; i < restaurants.size(); i++) {
                            System.out.println(restaurants.get(i).getPhoneNumber() + ", " + inputPhoneNumberEnter + ", "
                                    + restaurants.get(i).getPassword() + ", " + inputPasswordEnter);
                            if (restaurants.get(i).getPhoneNumber().equals(inputPhoneNumberEnter)
                                    && restaurants.get(i).getPassword().equals(inputPasswordEnter)) {
                                validUser = true;
                                currentIndex = i;
                                break;
                            }
                        }

                        if (validUser) {
                            dataOut.writeBytes("true" + SendData.restaurantData(currentIndex));
                            System.out.println("User was True, index : " + currentIndex);
                            System.out.println(SendData.restaurantData(currentIndex));
                        } else {
                            dataOut.writeBytes("false");
                            System.out.println("User was not True");
                        }

                    } else if (command.startsWith("Registering")) { // format:
                                                                    // Registering::nameRegistering::phoneNumber::password::address(String)::longitude::latitude::range::foodType1,foodType2,...

                        String[] dataRegistering = command.split("::");
                        String nameRegistering = dataRegistering[1];
                        String phoneNumber = dataRegistering[2];
                        String password = dataRegistering[3];
                        String addressString = dataRegistering[4];
                        double lon = parseDouble(dataRegistering[5]);
                        double lat = parseDouble(dataRegistering[6]);
                        int range = parseInt(dataRegistering[7]);
                        String[] typeFoodRegistering = dataRegistering[8].split(",");

                        Restaurant restaurantToAdd = new Restaurant(nameRegistering,
                                new Location(addressString, lat, lon), phoneNumber, password);
                        restaurantToAdd.setSendingRangeRadius(range);
                        for (String type : typeFoodRegistering) {
                            restaurantToAdd.addTypeFood(Food.TypeFood.valueOf(type));
                        }

                        restaurants.add(restaurantToAdd);

                    } else if (command.startsWith("setDelivered")) {

                        String[] list = command.split("::");
                        for (Order order : restaurants.get(currentIndex).getOrders()) {
                            if (order.getId() == parseInt(list[1]))
                                order.setStatusSeller(list[2].equals("true") ? true : false);
                        }

                    } else if (command.startsWith("addFood")) { // format:
                                                                // addFood::name::description::price::discount::typeFood

                        String[] list = command.split("::");

                        String name = list[1];
                        String description = list[2];
                        int price = parseInt(list[3]);
                        int discount = parseInt(list[4]);
                        boolean available = true;
                        Food.TypeFood typeFood = Food.TypeFood.valueOf(list[5]);
                        System.out.println("after type food");

                        Food food = new Food(name, description, price, discount, available, typeFood);
                        restaurants.get(currentIndex).getMenu().add(food);
                        System.out.println("Add Successfully!!");

                    } else if (command.startsWith("changeFood")) { // format:
                                                                   // changeFood::foodIndexToChange::name::description::price::discount::available::typeFood

                        String[] list = command.split("::");

                        int foodIndexToChange = 0;
                        String name = list[2];
                        String description = list[3];
                        int price = parseInt(list[4]);
                        int discount = parseInt(list[5]);
                        boolean available = Boolean.getBoolean(list[6]);
                        Food.TypeFood typeFood = Food.TypeFood.valueOf(list[7]);
                        System.out.println("after typeFood");

                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setName(name);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setDescription(description);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setPrice(price);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setDiscount(discount);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setAvailable(available);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setTypeFood(typeFood);

                        System.out.println("Change Successfully!!");

                    } else if (command.startsWith("location")) { // format:
                                                                 // location::address(String)::longitude::latitude

                        String[] list = command.split("::");

                        String address = list[1];
                        double longitude = parseDouble(list[2]);
                        double latitude = parseDouble(list[3]);

                        restaurants.get(currentIndex).setAddress(new Location(address, longitude, latitude));

                    } else if (command.startsWith("addReply")) { // format: addReply::comment::reply
                        String[] list = command.split("::");
                        for (Comment comment : restaurants.get(currentIndex).getComments()) {
                            if (comment.getComment().equals(list[1])) {
                                comment.setReply(list[2]);
                            }
                        }

                    } else if (command.startsWith("exit")) {

                        System.out.println("Bye");
                        break;

                    } else {

                        System.out.println("Unhandled Command");

                    }
                }

            } catch (Exception e) {
                System.out.println("catch");
                try {
                    this.socket.close();
                    this.dataOut.close();
                    this.dataIn.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        } else { // Customer

            try {

                while (true) {

                    String command = dataIn.readLine();
                    if (command.contains("Customer")) {
                        command = dataIn.readLine();
                    }
                    System.out.println(clientCounter + command);

                    if (command.startsWith("Entering")) { // format: Entering::phone::password

                        boolean validUser = false;
                        String[] list = command.split("::");
                        String inputPhoneNumberEnter = list[1];
                        String inputPasswordEnter = list[2];

                        for (int i = 0; i < customers.size(); i++) {
                            if (customers.get(i).getPhoneNumber().equals(inputPhoneNumberEnter)
                                    && customers.get(i).getPassword().equals(inputPasswordEnter)) {
                                validUser = true;
                                currentIndex = i;
                                break;
                            }
                        }

                        if (validUser) {
                            dataOut.writeBytes("true" + SendData.customerData(currentIndex));
                            System.out.println("User was True, index : " + currentIndex);
                            System.out.println(SendData.customerData(currentIndex));
                        } else {
                            dataOut.writeBytes("false");
                            System.out.println("User was not True");
                        }
                        dataOut.flush();

                    } else if (command.startsWith("Registering")) { // format:
                                                                    // Registering::firstName::lastName::phoneNumber::password::address(String)::longitude::latitude

                        String[] dataRegistering = command.split("::");
                        String firstName = dataRegistering[1];
                        String lastName = dataRegistering[2];
                        String phoneNumber = dataRegistering[3];
                        String password = dataRegistering[4];
                        String addressString = dataRegistering[5];
                        double lon = parseDouble(dataRegistering[6]);
                        double lat = parseDouble(dataRegistering[7]);

                        System.out.println("before customerToAdd");

                        Customer customerToAdd = new Customer(firstName, lastName, phoneNumber, password);
                        customerToAdd.addAddress(addressString, lon, lat);

                        System.out.println("before adding");

                        customers.add(customerToAdd);

                        System.out.println("Registered successfully!!!!!");

                    } else if (command.startsWith("wallet")) { // format: wallet::1000

                        int inputWallet = parseInt(command.substring(8));
                        customers.get(currentIndex).setWallet(inputWallet);

                    } else if (command.startsWith("addToOrders")) {
                        // format:
                        // addToOrders::restaurantName::orderTime::restaurantAddress::restaurantAddress::restaurantAddress::restaurantId::id::Map<food,int>

                        String[] list = command.split("::");
                        Order order = new Order(list[1], customers.get(currentIndex).getName(), list[2],
                                customers.get(currentIndex).getAddress().getLocation(),
                                new Location(list[3], parseDouble(list[4]), parseDouble(list[5])), parseInt(list[6]),
                                parseInt(list[7]));
                        int restaurantIndex = 0;
                        for (int i = 0; i < restaurants.size(); i++) {
                            if (restaurants.get(i).getId() == parseInt(list[6])) {
                                restaurantIndex = i;
                                break;
                            }
                        }
                        String[] list2 = list[8].split("&");
                        for (String str : list2) {
                            String[] string = str.split("\\^");
                            String food = string[0];
                            int number = parseInt(string[1]);
                            for (Food menuFood : restaurants.get(restaurantIndex).getMenu()) {
                                if (menuFood.getName().equals(food)) {
                                    order.addFood(menuFood, number);
                                }
                            }
                        }

                        customers.get(currentIndex).addPreviousOrders(order);
                        restaurants.get(restaurantIndex).addOrder(order);
                        System.out.println(order.toString());

                    } else if (command.startsWith("location")) { // format:
                                                                 // location::address(String)::longitude::latitude

                        String[] list = command.split("::");

                        String address = list[1];
                        double longitude = parseDouble(list[2]);
                        double latitude = parseDouble(list[3]);

                        customers.get(currentIndex).addAddress(address, longitude, latitude);

                    } else if (command.startsWith("addFavorite")) { // addFavorite::restaurantId

                        int favoriteRestaurantToAdd = parseInt(command.substring(13));
                        customers.get(currentIndex).addFavoriteRestaurant(favoriteRestaurantToAdd);
                        System.out.println(favoriteRestaurantToAdd + "added");

                    } else if (command.startsWith("removeFavorite")) { // removeFavorite::restaurantId

                        int favoriteRestaurantToAdd = parseInt(command.substring(16));
                        customers.get(currentIndex).removeFromFavoriteRestaurant(favoriteRestaurantToAdd);
                        System.out.println(favoriteRestaurantToAdd + "removed");

                    } else if (command.startsWith("comment")) { // comment::comment(String)::restaurantName

                        String[] list = command.split("::");
                        String comment = list[1];
                        String customerName = customers.get(currentIndex).getName();
                        String restaurantName = list[2];
                        LocalDateTime timeComment = LocalDateTime.now();

                        Comment commentToAdd = new Comment(comment);
                        commentToAdd.setCustomerName(customerName);
                        commentToAdd.setRestaurantName(restaurantName);
                        // commentToAdd.setTimeComment(timeComment);

                        customers.get(currentIndex).addComment(commentToAdd);

                    } else if (command.startsWith("exit")) {

                        System.out.println("Bye");
                        break;

                    } else {

                        System.out.println("Unhandled Command");

                    }
                }

            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("Catch");
                try {
                    this.socket.close();
                    this.dataOut.close();
                    this.dataIn.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

    }

}

class Server {
    Socket socket = null;
    ServerSocket serverSocket = null;
    DataInputStream dataIn = null;
    DataOutputStream dataOut = null;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            socket = serverSocket.accept();
            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
    }

}

class Main {
    public static void main(String[] args) throws IOException {

        Server server = new Server(8080);

    }
}