import Objects.*;

import static Database.Database.customers;
import static Database.Database.restaurants;

public class SendData {
    
    public static String customerData(int index) {

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
        if (customers.get(index).getComments().size()==0)
            data += "null&";
        for (int i = 0; i < customers.get(index).getComments().size(); i++) {
            Comment comment = customers.get(index).getComments().get(i);
            data += comment.getComment() + "^" + comment.getRestaurantName() + "^" + comment.getTimeComment() + "^" + comment.getReply() + "^" + comment.getTimeReply() + "^^";
        }
        data = data.substring(0, data.length() - 1);
        data += "&";


        ////////////////////////             favoriteRestaurant          ///////////////
        if (customers.get(index).getFavoriteRestaurant().size()==0)
            data += "null&";
        for (Integer restaurant : customers.get(index).getFavoriteRestaurant()) {
            data += restaurant+"^";
        }
        data = data.substring(0, data.length() - 1);
        data += "&";



        /////////////////////////               shoppingCart            ////////////////
        if (customers.get(index).getShoppingCart().size()==0)
            data += "null&&";
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
        //data=data.substring(0,data.length()-2);
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
                        comment.getRestaurantName() + "::" + comment.getTimeComment() + "::" ;
                if (comment.getReply()!=null)
                    data+= comment.getReply() + "::" + comment.getTimeReply() + ":::";
                else
                    data+=":";
            }
            data = data.substring(0, data.length() - 3);
            data += "##";


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
        data = data.substring(0, data.length() - 2);
        data+="end";

        return data;
    }






        public static String restaurantData(int index) {

            String data = "";

            Restaurant restaurant=restaurants.get(index);
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
                if (restaurant.getMenu().size()==0)
                    data+="null###";
                for (Food food : restaurant.getMenu()) {
                    data += food.getName() + "::" + food.getDescription() + "::" + food.getPrice() + "::" + food.getDiscount() + "::" +
                            food.getAvailable() + "::" + food.getTypeFood()+":::" ;
                }
                data=data.substring(0,data.length()-3);
                data+="#";


                /////////////////////////////////                   comments           /////////////////////
                 if (restaurant.getComments().size()==0)
                    data+="null###";
                for (Comment comment : restaurant.getComments() ) {
                    data += comment.getComment() + "::" + comment.getCustomerName() + "::" +
                            comment.getRestaurantName() + "::" + comment.getTimeComment() + "::" ;
                    if (comment.getReply()!=null)
                        data+= comment.getReply() + "::" + comment.getTimeReply() + ":::";
                    else
                        data+=":";
                }
                data = data.substring(0, data.length() - 3);
                data += "#";


                /////////////////////////////////                   orders           /////////////////////
            if (restaurant.getOrders().size()==0)
                data+="null###";
            for (Order order : restaurant.getOrders()) {
            data += order.getStatus() + "^" +
                    order.getCustomerName() + "^" +
                    order.getOrderTime() + "^" +
                    order.getCustomerAddress().getAddress() + "^" +
                    order.getCustomerAddress().getLatitude() + "^" +
                    order.getCustomerAddress().getLongitude() + "^"+
                    order.getId()+"^";
            for (Food food : order.getOrder().keySet()) {
                data += food.getName() + "::" + order.getOrder().get(food) + ":::";
            }
            }
            data=data.substring(0,data.length()-3);
            data += "#";


            /////////////////////////////////               cash data               //////////////////////////////
            if (restaurant.getCashSales().size()==0)
                data+="null#";
            for (int i : restaurant.getCashSales()) {
                data+=i+"^";
            }
            data=data.substring(0,data.length()-1);
            data += "#";


            /////////////////////////////////               online data               //////////////////////////////
            if ( restaurant.getOnlineSales().size()==0)
                data+="null#";
            for (int i : restaurant.getOnlineSales()) {
                data+=i+"^";
            }
            data=data.substring(0,data.length()-1);



            return data;
        }





}
