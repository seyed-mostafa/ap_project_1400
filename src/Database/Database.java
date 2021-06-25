package Database;


import Objects.*;
import Objects.Food.TypeFood;

import java.util.ArrayList;
import java.util.Map;

public class Database {

    public static ArrayList<Restaurant> restaurants= new ArrayList<>();
    public static ArrayList<Customer> customers= new ArrayList<>();



    private static Database database;
    private Database() {}
    public static Database getDatabase() {
        if(database == null) {
            database = new Database();
        }
        return database;
    }



    static  {

        /////////////////////////         add restaurant



        Restaurant restaurant1 = new Restaurant("Reihoon",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 51.331243399093914), "09123456782", "123");

        restaurant1.setSendingRangeRadius(800);
        restaurant1.setDays("shanbe ta pangshnbe");
        restaurant1.setHour("as saat 13 ta 23");
        for(TypeFood typeFood:TypeFood.values())
            restaurant1.addTypeFood(typeFood);

        restaurant1.setSendingRangeRadius(800);
        restaurant1.setDays("shanbe ta pangshnbe");
        restaurant1.setHour("as saat 13 ta 23");
        for(TypeFood typeFood:TypeFood.values())
             restaurant1.addTypeFood(typeFood);

        Food food1 = new Food("ghorme", "description1", 25000, 0, true, TypeFood.PersianFood);
        Food food2 = new Food("gheime", "description2", 30000, 20, true, TypeFood.PersianFood);
        Food food3 = new Food("makhsoos", "description3", 25000, 0, true, TypeFood.Pizza);
        Food food4 = new Food("sabzijat", "description4", 25000, 0, true, TypeFood.Pizza);
        Food food5 = new Food("hamberger", "description5", 65000, 20, true, TypeFood.Sandwich);
        Food food6 = new Food("sosis", "description6", 25000, 0, true, TypeFood.Sandwich);
        Food food7 = new Food("ab", "description7", 25000, 0, true, TypeFood.Drinks);
        Food food8 = new Food("doogh", "description8", 40000, 52, true, TypeFood.Drinks);
        Food food9 = new Food("bastany", "description9", 25000, 0, true, TypeFood.Dessert);
        Food food10 = new Food("jely", "description10", 25000, 0, true, TypeFood.Dessert);
        Food food11 = new Food("soop", "description11", 25000, 60, true, TypeFood.Appetizer);
        Food food12 = new Food("fereny", "description12", 25000, 0, true, TypeFood.Appetizer);
        Food food13 = new Food("morgh sokhary", "description13", 80000, 0, true, TypeFood.Fried);
        Food food14 = new Food("gharch sorakhy", "description14", 25000, 0, true, TypeFood.Fried);
        Food food15 = new Food("Medium Rare", "description15", 15000, 0, true, TypeFood.Steaks);
        Food food16 = new Food("T-bone Steak", "description16", 25000, 20, true, TypeFood.Steaks);
        Food food17 = new Food("nimroo", "description17", 5000, 0, true, TypeFood.Breakfast);
        Food food18 = new Food("pancake", "description18", 25000, 0, true, TypeFood.Breakfast);
        Food food19 = new Food("ghorme kharegy", "description19", 25000, 50, true, TypeFood.International);
        Food food20 = new Food("ghorme kharegy", "description20", 8000, 0, true, TypeFood.International);

        restaurant1.addMenu(food1);
        restaurant1.addMenu(food2);
        restaurant1.addMenu(food3);
        restaurant1.addMenu(food4);
        restaurant1.addMenu(food5);
        restaurant1.addMenu(food6);
        restaurant1.addMenu(food7);
        restaurant1.addMenu(food8);
        restaurant1.addMenu(food9);
        restaurant1.addMenu(food10);
        restaurant1.addMenu(food11);
        restaurant1.addMenu(food12);
        restaurant1.addMenu(food13);
        restaurant1.addMenu(food14);
        restaurant1.addMenu(food15);
        restaurant1.addMenu(food16);
        restaurant1.addMenu(food17);
        restaurant1.addMenu(food18);
        restaurant1.addMenu(food19);
        restaurant1.addMenu(food20);



        Order order1 = new Order(food1,3,restaurant1.getId());
        Order order2 = new Order(food4,4,restaurant1.getId());


        order1.setCustomerName("Ali Alavi");
        order2.setCustomerName("Naghi Naghavi");



        order1.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",34.717676891099835, 51.331243399093914));
        order2.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",35.717676891099835, 25.331243399093914));



        order1.setStatus();




        Order[] orders = { order2, order1};

        for (Order order : orders){
            order.setRestaurantName(restaurant1.getName());
            restaurant1.addOrder(order);
        }
        Comment comment = new Comment("ai khoda");
        Comment comment2 = new Comment("man dige rad dadam");
        Comment comment3 = new Comment("as dast in flutter");
        Comment comment4 = new Comment("ki bood migoft konkor ro bedin dige daneshgah rahate?");
        Comment comment5 = new Comment("khoda azab shab aval ghabresh ro ziad kone ");
        Comment comment6 = new Comment("khob dige dar mored chi benevisam");
        Comment comment7 = new Comment("fek konam baray comment ha bas bashe");
        Comment comment8 = new Comment("pas fellan khodahaffez :)))");
        comment2.setReply("khob be darak :|");

        comment.setCustomerName("Abbas");
        comment2.setCustomerName("Mostafa");
        comment3.setCustomerName("Ali");
        comment4.setCustomerName("Hasan");
        comment5.setCustomerName("Abbas");
        comment6.setCustomerName("Mostafa");
        comment7.setCustomerName("Ali");
        comment8.setCustomerName("Hasan");

        comment.setRestaurantName("akbar jooje");
        comment2.setRestaurantName("akbar jooje");
        comment3.setRestaurantName("akbar jooje");
        comment4.setRestaurantName("akbar jooje");
        comment5.setRestaurantName("akbar jooje");
        comment6.setRestaurantName("akbar jooje");
        comment7.setRestaurantName("akbar jooje");
        comment8.setRestaurantName("akbar jooje");

        restaurant1.addComment(comment);
        restaurant1.addComment(comment2);
        restaurant1.addComment(comment3);
        restaurant1.addComment(comment4);
        restaurant1.addComment(comment5);
        restaurant1.addComment(comment6);
        restaurant1.addComment(comment7);
        restaurant1.addComment(comment8);

        restaurant1.setCashSales(420);
        restaurant1.setCashSales(400);
        restaurant1.setCashSales(500);
        restaurant1.setCashSales(600);
        restaurant1.setCashSales(300);
        restaurant1.setCashSales(700);
        restaurant1.setCashSales(660);
        restaurant1.setCashSales(500);
        restaurant1.setCashSales(530);
        restaurant1.setCashSales(610);
        restaurant1.setCashSales(440);
        restaurant1.setCashSales(460);
        restaurant1.setCashSales(390);
        restaurant1.setCashSales(360);
        restaurant1.setCashSales(560);
        restaurant1.setCashSales(550);
        restaurant1.setCashSales(440);
        restaurant1.setCashSales(390);
        restaurant1.setCashSales(370);
        restaurant1.setCashSales(650);
        restaurant1.setCashSales(600);
        restaurant1.setCashSales(550);
        restaurant1.setCashSales(500);
        restaurant1.setCashSales(300);
        restaurant1.setCashSales(420);
        restaurant1.setCashSales(330);
        restaurant1.setCashSales(460);
        restaurant1.setCashSales(520);
        restaurant1.setCashSales(500);
        restaurant1.setCashSales(400);

        restaurant1.setOnlineSales(600);
        restaurant1.setOnlineSales(900);
        restaurant1.setOnlineSales(300);
        restaurant1.setOnlineSales(300);
        restaurant1.setOnlineSales(320);
        restaurant1.setOnlineSales(400);
        restaurant1.setOnlineSales(370);
        restaurant1.setOnlineSales(660);
        restaurant1.setOnlineSales(750);
        restaurant1.setOnlineSales(600);
        restaurant1.setOnlineSales(430);
        restaurant1.setOnlineSales(460);
        restaurant1.setOnlineSales(450);
        restaurant1.setOnlineSales(340);
        restaurant1.setOnlineSales(500);
        restaurant1.setOnlineSales(550);
        restaurant1.setOnlineSales(490);
        restaurant1.setOnlineSales(450);
        restaurant1.setOnlineSales(380);
        restaurant1.setOnlineSales(570);
        restaurant1.setOnlineSales(600);
        restaurant1.setOnlineSales(650);
        restaurant1.setOnlineSales(590);
        restaurant1.setOnlineSales(480);
        restaurant1.setOnlineSales(540);
        restaurant1.setOnlineSales(440);
        restaurant1.setOnlineSales(460);
        restaurant1.setOnlineSales(490);
        restaurant1.setOnlineSales(630);
        restaurant1.setOnlineSales(500);

        restaurants.add(restaurant1);




        /////////////////////////////    add customer






        Customer customer1 = new Customer("Ali", "Alavi", "1", "1");
        customer1.addFavoriteRestaurant(restaurants.get(0).getId());
        customer1.addAddress("asas",233.21,3243.24);


        customer1.addComment(comment3);
        customer1.addComment(comment7);

        customer1.addShoppingCart(food1,3, restaurant1.getId());
        customer1.addShoppingCart(food4, 2, restaurant1.getId());
        customer1.addShoppingCart(food6,1, restaurant1.getId());
        for(Order order : customer1.getShoppingCart()){
            order.setRestaurantName(restaurant1.getName());
            order.setRestaurantAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",34.7176769835, 51.39093914));
        }
//        customer1.getShoppingCart().indexOf(0).setRestaurantName(restaurant[0].getName());
//        customer1.getShoppingCart()[0].setRestaurantAddressString(" Tehran Province, Tehran, District 7, Mir Emad St &, Shahid Motahari St");

//        customer1.addShoppingCart(restaurant[1].getMenu()[2], restaurant[1].getId(), 1);
//        customer1.addShoppingCart(restaurant[1].getMenu()[3], restaurant[1].getId(), 2);
//        customer1.addShoppingCart(restaurant[1].getMenu()[4], restaurant[1].getId(), 3);
//        customer1.getShoppingCart()[1].setRestaurantName(restaurant[1].getName());
//        customer1.getShoppingCart()[1].setRestaurantAddressString( "Tehran Province, Tehran, District 7, Mir Emad St &, Shahid Motahari St");
//
//
//        Order order1 = new Order(restaurant[2].getMenu()[2], restaurant[2].getId(), 1);
//        order1.addFood(restaurant[2].getMenu()[3], 2);
//        order1.addFood(restaurant[2].getMenu()[4], 4);
//        customer1.addPreviousOrders(order1);
//        customer1.getPreviousOrders()[0].setRestaurantName(restaurant[2].getName());
//        customer1.getPreviousOrders()[0].setRestaurantAddressString( "Tehran Province, Tehran, District 7, Mir Emad St &, Shahid Motahari St");
//
//        Order order2 = new Order(restaurant[3].getMenu()[2], restaurant[3].getId(), 4);
//        order2.addFood(restaurant[3].getMenu()[1], 2);
//        order2.addFood(restaurant[3].getMenu()[3], 1);
//        order2.setDelivered();
//        customer1.addPreviousOrders(order2);
//        customer1.getPreviousOrders()[1].setRestaurantName(restaurant[3].getName());
//        customer1.getPreviousOrders()[1].setRestaurantAddressString( "Tehran Province, Tehran, District 7, Mir Emad St &, Shahid Motahari St");

        customer1.setWallet(300000);

        customers.add(customer1);
    }

}
