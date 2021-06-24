import Database.Database;
import Objects.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Database.Database.*;

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

        if (who.equals("Seller")) {

            try {
                //Entering Page
                boolean validUser = false;
                int currentIndex = 0;
                String clientMessage = "";
                String inputPhoneNumberEnter = "";
                String inputPasswordEnter = "";

                clientMessage = dataIn.readLine();
                System.out.println(clientMessage);

                inputPhoneNumberEnter = clientMessage.substring(7, clientMessage.lastIndexOf(','));
                System.out.println(inputPhoneNumberEnter);
                inputPasswordEnter = clientMessage.substring(clientMessage.lastIndexOf(':') + 2);
                System.out.println(inputPasswordEnter);


                //Registering Page
                String dataRegisteringString = dataIn.readLine(); //format: Registering::nameRegistering::phoneNumber::password::address(String)::longitude::latitude::range::foodType1,foodType2,...
                String[] dataRegistering = dataRegisteringString.split("::");
                String nameRigestering = dataRegistering[1];
                String phoneNumber = dataRegistering[2];
                String password = dataRegistering[3];
                String addressString = dataRegistering[4];
                double lon = Double.parseDouble(dataRegistering[5]);
                double lat = Double.parseDouble(dataRegistering[6]);
                int range = Integer.parseInt(dataRegistering[7]);
                String[] typeFoodRegistering = dataRegistering[8].split(",");

                Restaurant restaurantToAdd = new Restaurant(nameRigestering, new Location(addressString, lat, lon), phoneNumber, password);
                restaurantToAdd.setSendingRangeRadius(range);
                for (String type : typeFoodRegistering) {
                    restaurantToAdd.addTypeFood(Food.TypeFood.valueOf(type));
                }

                restaurants.add(restaurantToAdd);


                for (int i = 0; i < restaurants.size(); i++) {
                    if (customers.get(i).getPhoneNumber().equals(inputPhoneNumberEnter) && customers.get(i).getPassword().equals(inputPasswordEnter)) {
                        validUser = true;
                        currentIndex = i;
                        break;
                    }
                }

                if (validUser) {
                    dataOut.writeBytes("true" + data(currentIndex));
                    System.out.println("User was True, index : " + currentIndex);
                } else {
                    dataOut.writeBytes("false");
                    System.out.println("User was not True");
                }


                while (true) {

                    String command = dataIn.readLine();

                    if (command.startsWith("addFood")) { //format: addFood::name::description::price::discount::typeFood

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

                //Entering Page
                boolean validUser = false;
                int currentIndex = 0;
                String clientMessage = "";
                String inputPhoneNumberEnter = "";
                String inputPasswordEnter = "";

                clientMessage = dataIn.readLine();
                System.out.println(clientMessage);

                inputPhoneNumberEnter = clientMessage.substring(7, clientMessage.lastIndexOf(','));
                System.out.println(inputPhoneNumberEnter);
                inputPasswordEnter = clientMessage.substring(clientMessage.lastIndexOf(':') + 2);
                System.out.println(inputPasswordEnter);

//                //Registering Page
//                String dataRegisteringString = dataIn.readLine(); //format: Registering::firstName::lastName::phoneNumber::password::address(String)::longitude::latitude
//                String[] dataRegistering = dataRegisteringString.split("::");
//                String firstName = dataRegistering[1];
//                String lastName = dataRegistering[2];
//                String phoneNumber = dataRegistering[3];
//                String password = dataRegistering[4];
//                String addressString = dataRegistering[5];
//                double lon = Double.parseDouble(dataRegistering[6]);
//                double lat = Double.parseDouble(dataRegistering[7]);
//
//                Customer customerToAdd = new Customer(firstName, lastName, phoneNumber, password);
//                customerToAdd.addAddress(addressString, lon, lat);
//
//                customers.add(customerToAdd);

                for (int i = 0; i < Database.customers.size(); i++) {
                    if (customers.get(i).getPhoneNumber().equals(inputPhoneNumberEnter) && customers.get(i).getPassword().equals(inputPasswordEnter)) {
                        validUser = true;
                        currentIndex = i;
                        break;
                    }
                }

                if (validUser) {
                    dataOut.writeBytes("true" + data(currentIndex));
                    System.out.println("User was True, index : " + currentIndex);
                } else {
                    dataOut.writeBytes("false");
                    System.out.println("User was not True");
                }

                if (validUser)
                    while (true) {

                        String command = dataIn.readLine();
                        System.out.println(command);

                        if (command.startsWith("wallet")) { //format: wallet::1000

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

    private String data(int index) {

        String data = "";

        data += customers.get(index).getName() + "&";
        data += customers.get(index).getLastName() + "&";
        data += customers.get(index).getPhoneNumber() + "&";
        data += customers.get(index).getPassword() + "&";
        data += customers.get(index).getWallet() + "&";
        data += customers.get(index).getAddress().getAddress() + "&";
        data += customers.get(index).getAddress().getLatitude() + "&";
        data += customers.get(index).getAddress().getLongitude() + "&";


        ////////////////////         comment         ///////////////////

        for (int i = 0; i < customers.get(index).getComments().size(); i++) {
            Comment comment = customers.get(index).getComments().get(i);
            data += comment.getComment() + "^" + comment.getRestaurantName() + "^" + comment.getTimeComment() + "^" + comment.getReply() + "^" + comment.getTimeReply() + "^^";
        }
        data = data.substring(0, data.length() - 1);
        data += "&";


        ////////////////////////             favoriteRestaurant          ///////////////

        for (Integer restaurant : customers.get(index).getFavoriteRestaurant()) {
            data += restaurant;
        }
        data = data.substring(0, data.length() - 1);
        data += "&";



        /////////////////////////               shoppingCart            ////////////////

        for (Order order : customers.get(index).getShoppingCart()) {
            data += order.getStatus() + order.getRestaurantName() + "^" +
                    order.getRestaurantId() + "^" + order.getOrderTime() + "^" + order.getRestaurantAddress().getAddress() + "^" +
                    order.getRestaurantAddress().getLatitude() + "^" + order.getRestaurantAddress().getLongitude() + "^";
            for (Food food : order.getOrder().keySet()) {
                data += food.getName() + "::" + food.getDescription() + "::" + food.getPrice() + "::" + food.getDiscount() + "::" +
                        food.getAvailable() + "::" + food.getTypeFood() + "::" + order.getOrder().get(food) + ":::";
            }
            data=data.substring(0,data.length()-3);
            data+="^^";
        }
        data=data.substring(0,data.length()-2);
       // data+="&";



        /////////////////////////               Orders            ////////////////

        for (Order order : customers.get(index).getPreviousOrders()) {
            data += order.getStatus() + "^" + order.getRestaurantName() + "^" +
                    order.getRestaurantId() + "^" + order.getOrderTime() + "^" + order.getRestaurantAddress().getAddress() + "^" +
                    order.getRestaurantAddress().getLatitude() + "^" + order.getRestaurantAddress().getLongitude() + "^";
            for (Food food : order.getOrder().keySet()) {
                data += food.getName() + "::" + food.getDescription() + "::" + food.getPrice() + "::" + food.getDiscount() + "::" +
                        food.getAvailable() + "::" + food.getTypeFood() + "::" + order.getOrder().get(food) + ":::";
            }
            data=data.substring(0,data.length()-3);
            data+="^^";
        }
        data=data.substring(0,data.length()-2);










        ////////////////////////////////////////////////////////                                   restaurants data                         /////////////////////////////////


        for (Restaurant restaurant:restaurants) {
            data+=  restaurant.getName()+"#"+
                    restaurant.getAddress().getAddress()+"#"+
                    restaurant.getAddress().getLongitude()+"#"+
                    restaurant.getAddress().getLatitude() +"#"+
                    restaurant.getPhoneNumber()+"#"+
                    restaurant.getPassword()+"#"+
                    restaurant.getSendingRangeRadius()+"^"+
                    restaurant.getId()+"#"+
                    restaurant.getDays()+"#"+
                    restaurant.getHour()+"#"+
                    restaurant.getDays()+"#";
            for (Food.TypeFood typeFood:restaurant.getTypeFoods()) {
                data+=typeFood+"::";
            }
            data=data.substring(0,data.length()-2);
            data+="#";


            /////////////////////////////////                       menu            /////////////////////

            for (Food food : restaurant.getMenu()) {
                data += food.getName() + "::" + food.getDescription() + "::" + food.getPrice() + "::" + food.getDiscount() + "::" +
                        food.getAvailable() + "::" + food.getTypeFood()+":::" ;
            }
            data=data.substring(0,data.length()-3);
            data+="#";


            /////////////////////////////////                   comments           /////////////////////

            for (Comment comment : restaurant.getComments() ) {
                data += comment.getComment() + "::" + comment.getCustomerName() + "::" +comment.getRestaurantName() + "::" + comment.getTimeComment() + "::" +
                        comment.getReply() + "::" + comment.getTimeReply() + ":::";
            }
            data = data.substring(0, data.length() - 3);
            data += "#";


            /////////////////////////////////                   orders           /////////////////////

            for (Order order : restaurant.getOrders()) {
            data += order.getStatus() + "^" +
                    order.getCustomerName() + "^" +
                    order.getOrderTime() + "^" +
                    order.getCustomerAddress().getAddress() + "^" +
                    order.getCustomerAddress().getLatitude() + "^" +
                    order.getCustomerAddress().getLongitude() + "^"+
                    order.getId()+"^";
            for (Food food : order.getOrder().keySet()) {
                data += food.getName() + "::" + food.getDescription() + "::" + food.getPrice() + "::" + food.getDiscount() + "::" +
                        food.getAvailable() + "::" + food.getTypeFood() + "::" + order.getOrder().get(food) + ":::";
            }
            data=data.substring(0,data.length()-3);
            data+="^^";
        }
        data=data.substring(0,data.length()-2);
        data+="#";

        }





        ////////////////////////////////////                                   restaurants data                         /////////////////////////////////


        for (Restaurant restaurant:restaurants) {
            data+=  restaurant.getName()+"^"+
                    restaurant.getAddress().getAddress()+"^"+
                    restaurant.getAddress().getLongitude()+"^"+
                    restaurant.getAddress().getLatitude() +"^"+
                    restaurant.getPhoneNumber()+"^"+
                    restaurant.getPassword()+"^"+
                    restaurant.getSendingRangeRadius()+"^"+
                    restaurant.getId()+"^"+
                    restaurant.getDays()+"^"+
                    restaurant.getHour()+"^"+
                    restaurant.getDays()+"^"


            ;
            for (Food.TypeFood typeFood:restaurant.getTypeFoods()) {
                data+=typeFood+"::";
            }
            data+="^";

        }


        return data;
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

