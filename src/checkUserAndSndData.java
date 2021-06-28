import Objects.Food;
import Objects.Location;
import Objects.Restaurant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static Database.Database.customers;
import static Database.Database.restaurants;

public class checkUserAndSndData {



    static int check(DataInputStream dataIn, DataOutputStream dataOut) throws IOException {


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
           // dataOut.writeBytes("true" + SendData.customerData(currentIndex));
            System.out.println("User was True, index : " + currentIndex);
        } else {
            dataOut.writeBytes("false");
            System.out.println("User was not True");
        }
        return currentIndex;
    }

}
