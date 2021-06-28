package Objects;


import java.util.ArrayList;


public class Customer  {

    String firstName, lastName, phoneNumber, password;
    int wallet = 0;
    private Location address;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private ArrayList<Integer> favoriteRestaurant= new ArrayList<Integer>();
    private ArrayList<Order> shoppingCart = new ArrayList<Order>();
    private ArrayList<Order> orders = new ArrayList<Order>();





    public Customer(String firstName, String lastName, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void removeFromFavoriteRestaurant(int id) {
        for (int i=0;1<favoriteRestaurant.size();i++) {
            if (favoriteRestaurant.get(i)==id)
                favoriteRestaurant.remove(i);
        }
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
        this.address=new Location(address, longitude, latitude);

    }

    public void removeShoppingCart(Order order) {
        shoppingCart.remove(order);
    }

    public void addShoppingCart(Food food,int i, int restaurantId) {
        for (Order order : shoppingCart){
            if (order.getRestaurantId() == restaurantId) {
                order.addFood(food, i);
                return;
            }
        }
        shoppingCart.add(new Order(food,i, restaurantId));
    }


    public void addPreviousOrders(Order order) {
        orders.add(order);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void addFavoriteRestaurant(Integer favoriteRestaurant) {
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

    public Location getAddress() {
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

    public ArrayList<Integer> getFavoriteRestaurant() {
        return favoriteRestaurant;
    }
}


