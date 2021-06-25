import Database.*;
import Objects.*;


import java.io.*;

import java.net.*;
import java.time.LocalDateTime;

import static Database.Database.customers;
import static Database.Database.restaurants;

class ClientHandler implements Runnable {
    static int clientCounter = 1;
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
        System.out.println("client " + clientCounter++ + " added.");

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

                    if (command.startsWith("Entering")) { //format: Entering::phone::password

                        boolean validUser = false;
                        String [] list = command.split("::");
                        String inputPhoneNumberEnter = list[1];
                        String inputPasswordEnter = list[2];

                        for (int i = 0; i < restaurants.size(); i++) {
                            if (customers.get(i).getPhoneNumber().equals(inputPhoneNumberEnter) && customers.get(i).getPassword().equals(inputPasswordEnter)) {
                                validUser = true;
                                currentIndex = i;
                                break;
                            }
                        }

                        if (validUser) {
                            dataOut.writeBytes("true" + SendData.data(currentIndex));
                            System.out.println("User was True, index : " + currentIndex);
                        } else {
                            dataOut.writeBytes("false");
                            System.out.println("User was not True");
                        }

                    } else if (command.startsWith("Registering")) { //format: Registering::nameRegistering::phoneNumber::password::address(String)::longitude::latitude::range::foodType1,foodType2,...

                        String[] dataRegistering = command.split("::");
                        String nameRegistering = dataRegistering[1];
                        String phoneNumber = dataRegistering[2];
                        String password = dataRegistering[3];
                        String addressString = dataRegistering[4];
                        double lon = Double.parseDouble(dataRegistering[5]);
                        double lat = Double.parseDouble(dataRegistering[6]);
                        int range = Integer.parseInt(dataRegistering[7]);
                        String[] typeFoodRegistering = dataRegistering[8].split(",");

                        Restaurant restaurantToAdd = new Restaurant(nameRegistering, new Location(addressString, lat, lon), phoneNumber, password);
                        restaurantToAdd.setSendingRangeRadius(range);
                        for (String type : typeFoodRegistering) {
                            restaurantToAdd.addTypeFood(Food.TypeFood.valueOf(type));
                        }

                        restaurants.add(restaurantToAdd);

                    } else if (command.startsWith("order")) {

                    } else if (command.startsWith("addFood")) { //format: addFood::name::description::price::discount::typeFood

                        String[] list = command.split("::");

                        String name = list[1];
                        String description = list[2];
                        int price = Integer.parseInt(list[3]);
                        int discount = Integer.parseInt(list[4]);
                        boolean available = true; //ToDo
                        Food.TypeFood typeFood = Food.TypeFood.valueOf(list[5]);

                        Food food = new Food(name, description, price, discount, available, typeFood);
                        restaurants.get(currentIndex).getMenu().add(food);

                    } else if (command.startsWith("changeFood")) { //format: changeFood::foodIndexToChange::name::description::price::discount::available::typeFood

                        String[] list = command.split("::");

                        int foodIndexToChange = 0;
                        String name = list[2];
                        String description = list[3];
                        int price = Integer.parseInt(list[4]);
                        int discount = Integer.parseInt(list[5]);
                        boolean available = Boolean.getBoolean(list[6]);
                        Food.TypeFood typeFood = Food.TypeFood.valueOf(list[7]);

                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setName(name);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setDescription(description);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setPrice(price);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setDiscount(discount);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setAvailable(available);
                        restaurants.get(currentIndex).getMenu().get(foodIndexToChange).setTypeFood(typeFood);

                    } else if (command.startsWith("location")) { //format: location::address(String)::longitude::latitude

                        String[] list = command.split("::");

                        String address = list[1];
                        double longitude = Double.parseDouble(list[2]);
                        double latitude = Double.parseDouble(list[3]);

                        restaurants.get(currentIndex).setAddress(new Location(address, longitude, latitude));

                    } else if (command.startsWith("comment")) {


                    } else if (command.startsWith("exit")) {

                        System.out.println("Bye");
                        break;

                    } else {

                        System.out.println("Unhandled Command");

                    }
                }


            } catch (Exception e) {
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
                    System.out.println(command);

                    if (command.startsWith("Entering")) { //format: Entering::phone::password

                        boolean validUser = false;
                        String [] list = command.split("::");
                        String inputPhoneNumberEnter = list[1];
                        String inputPasswordEnter = list[2];

                        for (int i = 0; i < restaurants.size(); i++) {
                            if (customers.get(i).getPhoneNumber().equals(inputPhoneNumberEnter) && customers.get(i).getPassword().equals(inputPasswordEnter)) {
                                validUser = true;
                                currentIndex = i;
                                break;
                            }
                        }

                        if (validUser) {
                            dataOut.writeBytes("true" + SendData.data(currentIndex));
                            System.out.println("User was True, index : " + currentIndex);
                        } else {
                            dataOut.writeBytes("false");
                            System.out.println("User was not True");
                        }

                    } else if (command.startsWith("Registering")) { //format: Registering::firstName::lastName::phoneNumber::password::address(String)::longitude::latitude

                        String dataRegisteringString = dataIn.readLine();
                        String[] dataRegistering = dataRegisteringString.split("::");
                        String firstName = dataRegistering[1];
                        String lastName = dataRegistering[2];
                        String phoneNumber = dataRegistering[3];
                        String password = dataRegistering[4];
                        String addressString = dataRegistering[5];
                        double lon = Double.parseDouble(dataRegistering[6]);
                        double lat = Double.parseDouble(dataRegistering[7]);

                        Customer customerToAdd = new Customer(firstName, lastName, phoneNumber, password);
                        customerToAdd.addAddress(addressString, lon, lat);

                        customers.add(customerToAdd);

                    } else if (command.startsWith("wallet")) { //format: wallet::1000

                        int inputWallet = Integer.parseInt(command.substring(8));
                        customers.get(currentIndex).setWallet(inputWallet);

                    } else if (command.startsWith("addToBag")) { //format: addToBag::foodIndex::count::restaurantId

                        String[] list = command.split("::");

                        int foodIndex = Integer.parseInt(list[1]);
                        int count = Integer.parseInt(list[2]);
                        int restaurantId = Integer.parseInt(list[3]);
                        int restaurantIndex = 0;

                        for (int i = 0; i < restaurants.size(); i++) {
                            if (restaurants.get(i).getId() == restaurantId) {
                                restaurantIndex = i;
                                break;
                            }
                        }

                        customers.get(currentIndex).addShoppingCart(restaurants.get(restaurantIndex).getMenu().get(foodIndex), count, restaurantId);

                    } else if (command.startsWith("location")) { //format: location::address(String)::longitude::latitude

                        String[] list = command.split("::");

                        String address = list[1];
                        double longitude = Double.parseDouble(list[2]);
                        double latitude = Double.parseDouble(list[3]);

                        customers.get(currentIndex).addAddress(address, longitude, latitude);

                    } else if (command.startsWith("favorite")) { //favorite::restaurantIndex

                        int favoriteRestaurantToAdd = Integer.parseInt(command.substring(10));
                        //  customers.get(currentIndex).addFavoriteRestaurant(restaurants.get(favoriteRestaurantToAdd));

                    } else if (command.startsWith("comment")) { //comment::comment(String)::restaurantName

                        String[] list = command.split("::");
                        String comment = list[1];
                        String customerName = customers.get(currentIndex).getName();
                        String restaurantName = list[2];
                        LocalDateTime timeComment = LocalDateTime.now();

                        Comment commentToAdd = new Comment(comment);
                        commentToAdd.setCustomerName(customerName);
                        commentToAdd.setRestaurantName(restaurantName);
                        //commentToAdd.setTimeComment(timeComment);

                        customers.get(currentIndex).addComment(commentToAdd);

                    } else if (command.startsWith("exit")) {

                        System.out.println("Bye");
                        break;

                    } else {

                        System.out.println("Unhandled Command");

                    }
                }

            } catch (Exception e) {
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