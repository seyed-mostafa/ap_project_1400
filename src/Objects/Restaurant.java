package Objects;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Restaurant {


    static int _count=99243000;
    String name, phoneNumber, password, days, hour;
    int sendingRangeRadius, id;
    Location address;
    ArrayList<Food> menu = new ArrayList<Food>();
    ArrayList<TypeFood> type=new ArrayList<TypeFood>();
    ArrayList<Order> orders = new ArrayList<Order>();
    ArrayList<Comment> comments = new ArrayList<Comment>();
    ArrayList<Integer> cashSales = new ArrayList<Integer>();
    ArrayList<Integer> onlineSales =new ArrayList<Integer>();
    ArrayList<Integer> totalSales = new ArrayList<Integer>();


    Restaurant(String name, Location address, String phoneNumber, String password)  {
        _count++;
        id =_count;
        this.name = name;
        this.address = address;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }



    void setCashSales(int sale){
        cashSales.add(sale);
    }

    void setOnlineSales(int sale){
        onlineSales.add(sale);
    }

    void addComment(Comment comment){
        comments.add(comment);
    }

    ArrayList<Comment> getComments(){
        return comments;
    }

    void addOrder(Order order){
        orders.add(order);

    }

    ArrayList<Order> getOrders(){
        return orders;
    }

    ArrayList<Food> getMenu() {
        return menu;
    }

    void addMenu(Food food){
        menu.add(food);
    }

    int getId(){
        return id;
    }

    void addTypeFood(TypeFood typeFood){
        type.add(typeFood);
    }

    void setName(String name) {
        this.name = name;
    }

    void setDays(String days) {
        this.days = days;
    }

    void setHour(String hour) {
        this.hour = hour;
    }

    void setAddress(Location address) {
        this.address = address;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setSendingRangeRadius(int sendingRangeRadius) {
        this.sendingRangeRadius = sendingRangeRadius;
    }





    String getName() {
        return name;
    }

    Location getAddress() {
        return address;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getPassword() {
        return password;
    }

    int getSendingRangeRadius() {
        return sendingRangeRadius;
    }

    String getDays() {
        return days;
    }

    String getHour() {
        return hour;
    }

    ArrayList<TypeFood> getTypeFoods(){
        return type;
    }

    ArrayList<Integer> getOnlineSales(){
        return onlineSales;
    }

    ArrayList<Integer> getCashSales(){
        return cashSales;
    }

    ArrayList<Integer> getTotalSales(){
        for(int i=0;i<30;i++)
            totalSales.add(cashSales.indexOf(i)+ onlineSales.indexOf(i));
        return totalSales;
    }

    int getOnlineSalesSum(int i){
        int sum=0;
        for(i=30-i; i< onlineSales.size(); i++)
            sum+= onlineSales.indexOf(i);
        return sum;
    }

    int getCashSalesSum(int i){
        int sum=0;
        for(i=30-i ; i< cashSales.size(); i++)
            sum+= cashSales.indexOf(i);
        return sum;
    }

    int getTotalSalesSum(int i){
        int sum=0;
        for(i=30-i; i< onlineSales.size(); i++) {
            sum += onlineSales.indexOf(i);
            sum += cashSales.indexOf(i);
        }
        return sum;
    }
}
