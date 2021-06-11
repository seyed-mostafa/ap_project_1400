package Objects;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {

    String customerName, restaurantName;
    int id, price =0,restaurantId;
    boolean status =false;
    Location customerAddress,restaurantAddress;
    static int count =99246000;
    LocalDateTime orderTime, deliveryTime;
    Map<Food,Integer> order=new HashMap<Food,Integer>();



    Order(Map <Food,Integer> order,int restaurantId) {
        this.restaurantId=restaurantId;
        orderTime = LocalDateTime.now();
        this.order=order;
        count++;
        id = count;
        for(Food food :order.keySet()){
            if(food.getDiscount()!=0)
                price += ((food.getPrice()*(100-food.getDiscount()))/100*order.get(food));
            else
                price += (food.getPrice()*order.get(food));
        }

    }


    void setStatus(){
        status =!status;
        if (status) {
            setDeliveryTime();
        }
    }
    boolean getStatus(){
        return status;
    }
    void setCustomerName(String name){
        customerName =name;
    }
    void setRestaurantName(String name){
        restaurantName=name;
    }

    void setDeliveryTime(){
        deliveryTime = LocalDateTime.now();
    }



    int getPrice(){
        return price;
    }

    Location getCustomerAddress(){
        return customerAddress;
    }

    Location getRestaurantAddress(){
        return restaurantAddress;
    }

    String getRestaurantName(){
        return restaurantName;
    }

    String getCustomerName(){
        return customerName;
    }

    LocalDateTime getOrderTime() {
        return orderTime;
    }

    LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    int getId(){
        return id;
    }

    Map <Food,Integer> getOrder(){
        return order;
    }
}
