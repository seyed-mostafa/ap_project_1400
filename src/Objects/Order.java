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



    public Order(Map<Food, Integer> order, int restaurantId) {
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

    public void setCustomerAddress(Location customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setRestaurantAddress(Location restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public void setStatus(){
        status =!status;
        if (status) {
            setDeliveryTime();
        }
    }
    public boolean getStatus(){
        return status;
    }
    public void setCustomerName(String name){
        customerName =name;
    }
    public void setRestaurantName(String name){
        restaurantName=name;
    }

    public void setDeliveryTime(){
        deliveryTime = LocalDateTime.now();
    }



    public int getPrice(){
        return price;
    }

    public Location getCustomerAddress(){
        return customerAddress;
    }

    public Location getRestaurantAddress(){
        return restaurantAddress;
    }

    public String getRestaurantName(){
        return restaurantName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public int getId(){
        return id;
    }

    public Map <Food,Integer> getOrder(){
        return order;
    }
}