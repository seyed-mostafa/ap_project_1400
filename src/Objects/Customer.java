package Objects;


import java.util.ArrayList;
import java.util.Map;


public class Customer  {

    String firstName, lastName, phoneNumber, password;
    int wallet = 0;
    private ArrayList<Location> address = new ArrayList<Location>();
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private ArrayList<Restaurant> favoriteRestaurant= new ArrayList<Restaurant>();
    private ArrayList<Order> shoppingCart = new ArrayList<Order>();
    private ArrayList<Order> orders = new ArrayList<Order>();





    Customer(String firstName,String lastName,String phoneNumber,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    void setName(String name) {
        firstName = name;
    }

    void setLastName(String name) {
        lastName = name;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setWallet(int wallet) {
        this.wallet = wallet;
    }

    void addAddress(String address,double longitude,double latitude){
        this.address.add(new Location(address, longitude, latitude));

    }

    void removeShoppingCart(Order order) {
        shoppingCart.remove(order);
    }

    void addShoppingCart(Map<Food,Integer> order, int restaurantId) {
//        for (Order order : shoppingCart){
//            if (order.getRestaurantId() == restaurantId) {
//                order.addFood(food, i);
//                return;
//            }
//        }
        shoppingCart.add(new Order(order, restaurantId));
    }

    void addPreviousOrders(Order order) {
        orders.add(order);
    }

    void addComment(Comment comment) {
        this.comments.add(comment);
    }

    void addFavoriteRestaurant(Restaurant favoriteRestaurant) {
        this.favoriteRestaurant.add(favoriteRestaurant);
    }






    String getName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getPassword() {
        return password;
    }

    int getWallet() {
        return wallet;
    }

    ArrayList<Location> getAddress() {
        return address;
    }

    ArrayList<Order> getShoppingCart() {
        return shoppingCart;
    }

    ArrayList<Order> getPreviousOrders() {
        return orders;
    }

    ArrayList<Comment> getComments() {
        return comments;
    }

    ArrayList<Restaurant> getFavoriteRestaurant() {
        return favoriteRestaurant;
    }
}


