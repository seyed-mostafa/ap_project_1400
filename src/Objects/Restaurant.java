package Objects;

import java.util.ArrayList;

public class Restaurant {


    static int _count=99243000;
    String name, phoneNumber, password, days, hour;
    int sendingRangeRadius, id;
    Location address;
    ArrayList<Food> menu = new ArrayList<Food>();
    ArrayList<Food.TypeFood> type=new ArrayList<Food.TypeFood>();
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<Comment> comments = new ArrayList<Comment>();
    ArrayList<Integer> cashSales = new ArrayList<Integer>();
    ArrayList<Integer> onlineSales =new ArrayList<Integer>();
    ArrayList<Integer> totalSales = new ArrayList<Integer>();


    public Restaurant(String name, Location address, String phoneNumber, String password)  {
        _count++;
        id =_count;
        this.name = name;
        this.address = address;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }



    public void setCashSales(int sale){
        cashSales.add(sale);
    }

    public void setOnlineSales(int sale){
        onlineSales.add(sale);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }

    public void addOrder(Order order){
        orders.add(order);

    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public ArrayList<Food> getMenu() {
        return menu;
    }

    public void addMenu(Food food){
        menu.add(food);
    }
    public void addAllMenu(Food[] foods){
        for(Food food : foods)
            menu.add(food);
    }


    public int getId(){
        return id;
    }

    public void addTypeFood(Food.TypeFood typeFood){
        type.add(typeFood);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSendingRangeRadius(int sendingRangeRadius) {
        this.sendingRangeRadius = sendingRangeRadius;
    }





    public String getName() {
        return name;
    }

    public Location getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getSendingRangeRadius() {
        return sendingRangeRadius;
    }

    public String getDays() {
        return days;
    }

    public String getHour() {
        return hour;
    }

    public ArrayList<Food.TypeFood> getTypeFoods(){
        return type;
    }



    public ArrayList<Integer> getOnlineSales(){
        return onlineSales;
    }

    public ArrayList<Integer> getCashSales(){
        return cashSales;
    }

    public ArrayList<Integer> getTotalSales(){
        for(int i=0;i<30;i++)
            totalSales.add(cashSales.indexOf(i)+ onlineSales.indexOf(i));
        return totalSales;
    }

    public int getOnlineSalesSum(int i){
        int sum=0;
        for(i=30-i; i< onlineSales.size(); i++)
            sum+= onlineSales.indexOf(i);
        return sum;
    }

    public int getCashSalesSum(int i){
        int sum=0;
        for(i=30-i ; i< cashSales.size(); i++)
            sum+= cashSales.indexOf(i);
        return sum;
    }

    public int getTotalSalesSum(int i){
        int sum=0;
        for(i=30-i; i< onlineSales.size(); i++) {
            sum += onlineSales.indexOf(i);
            sum += cashSales.indexOf(i);
        }
        return sum;
    }
}
