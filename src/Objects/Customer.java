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





    public Customer(String firstName, String lastName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void setName(String name) {
        firstName = name;
    }

    public void setLastName(String name) {
        lastName = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void addAddress(String address,double longitude,double latitude){
        this.address.add(new Location(address, longitude, latitude));

    }

    public void removeShoppingCart(Order order) {
        shoppingCart.remove(order);
    }

    public void addShoppingCart(Map<Food,Integer> order, int restaurantId) {
//        for (Order order : shoppingCart){
//            if (order.getRestaurantId() == restaurantId) {
//                order.addFood(food, i);
//                return;
//            }
//        }
        shoppingCart.add(new Order(order, restaurantId));
    }

    public void addShoppingCart(Order oreder) {
        shoppingCart.add(oreder);
    }

    public void addPreviousOrders(Order order) {
        orders.add(order);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addFavoriteRestaurant(Restaurant favoriteRestaurant) {
        this.favoriteRestaurant.add(favoriteRestaurant);
    }






    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getWallet() {
        return wallet;
    }

    public ArrayList<Location> getAddress() {
        return address;
    }

    public ArrayList<Order> getShoppingCart() {
        return shoppingCart;
    }

    public ArrayList<Order> getPreviousOrders() {
        return orders;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Restaurant> getFavoriteRestaurant() {
        return favoriteRestaurant;
    }
}


