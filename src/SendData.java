import Objects.*;

import static Database.Database.customers;
import static Database.Database.restaurants;

public class SendData {
    
    public static String data(int index) {

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
        data+="&";










        ////////////////////////////////////////////////////////                                   restaurants data                         /////////////////////////////////


        for (Restaurant restaurant:restaurants) {
            data+=  restaurant.getName()+"#"+
                    restaurant.getAddress().getAddress()+"#"+
                    restaurant.getAddress().getLongitude()+"#"+
                    restaurant.getAddress().getLatitude() +"#"+
                    restaurant.getPhoneNumber()+"#"+
                    restaurant.getPassword()+"#"+
                    restaurant.getSendingRangeRadius()+"#"+
                    restaurant.getId()+"#"+
                    restaurant.getDays()+"#"+
                    restaurant.getHour()+"#";
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
                data += comment.getComment() + "::" + comment.getCustomerName() + "::" +
                        comment.getRestaurantName() + "::" + comment.getTimeComment() + "::" +
                        comment.getReply() + "::" + comment.getTimeReply() + ":::";
            }
            data = data.substring(0, data.length() - 3);
            data += "#";


            /////////////////////////////////                   orders           /////////////////////

//            for (Order order : restaurant.getOrders()) {
//            data += order.getStatus() + "^" +
//                    order.getCustomerName() + "^" +
//                    order.getOrderTime() + "^" +
//                    order.getCustomerAddress().getAddress() + "^" +
//                    order.getCustomerAddress().getLatitude() + "^" +
//                    order.getCustomerAddress().getLongitude() + "^"+
//                    order.getId()+"^";
//            for (Food food : order.getOrder().keySet()) {
//                data += food.getName() + "::" + food.getDescription() + "::" + food.getPrice() + "::" + food.getDiscount() + "::" +
//                        food.getAvailable() + "::" + food.getTypeFood() + "::" + order.getOrder().get(food) + ":::";
//            }
//            data=data.substring(0,data.length()-3);
//            data+="^^";
//        }
//        data=data.substring(0,data.length()-2);
//        data+="#";

        }
        data+="end";



        return data;
    }
}
