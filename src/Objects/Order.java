package Objects;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Order {

    String customerName,orderTime, deliveryTime, restaurantName;
    int id, price =0,restaurantId;
    boolean status =false;
    Location customerAddress,restaurantAddress;
    static int count =99246000;
    Map<Food,Integer> order=new HashMap<Food,Integer>();

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", restaurantId=" + restaurantId +
                ", status=" + status +
                ", customerAddress=" + customerAddress +
                ", restaurantAddress=" + restaurantAddress +
                ", order=" + order +
                '}';
    }

    public Order(Food food, int i, int restaurantId) {
        this.restaurantId=restaurantId;
        orderTime = DateTimeFormatter.ofPattern("dd MMM HH:mm").format(LocalDateTime.now());
        count++;
        id = count;
        order.put(food, i);
    }

    public  Order(String restaurantName,String customerName,String orderTime,Location customerAddress,Location restaurantAddress,int restaurantId,int id){
        this.restaurantName=restaurantName;
        this.customerName=customerName;
        this.orderTime=orderTime;
        this.customerAddress=customerAddress;
        this.restaurantAddress=restaurantAddress;
        this.restaurantId=restaurantId;
        this.id = id;
    }

    public void setStatusSeller(boolean b){
        status=b;
    }

    public void setId(int id) {
        this.id = id;
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
        deliveryTime = DateTimeFormatter.ofPattern("dd MMM HH:mm").format(LocalDateTime.now());
        status=!status;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice(){
        price=0;
        for(Food food :order.keySet()){
            if(food.getDiscount()!=0)
                price += ((food.getPrice()*(100-food.getDiscount()))/100*order.get(food));
            else
                price += (food.getPrice()*order.get(food));
        }
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

    public String getOrderTime() {
        return orderTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getId(){
        return id;
    }

    public Map <Food,Integer> getOrder(){
        return order;
    }

    public void addFood(Food food, int i) {
        order.put(food,i);
    }
}
