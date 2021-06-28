package Database;


import Objects.*;
import Objects.Food.TypeFood;

import java.util.ArrayList;

public class Database {

    public static ArrayList<Restaurant> restaurants = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();


    private static Database database;

    private Database() {
    }

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }


    static {

        /////////////////////////         add restaurant

        Restaurant[] restaurant = {
                new Restaurant("Reihoon",
                        new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                                34.717676891099835, 51.331243399093914), "1", "1")

                , new Restaurant("Mashti",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456781", "123")

                , new Restaurant("akbar jooje",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456783", "123")

                , new Restaurant("asghar jooje",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456784", "123")

                , new Restaurant("javanan",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456785", "123")

                , new Restaurant("mostafa va abbas",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456786", "123")

                , new Restaurant("Daneshjoo",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456787", "123")

                , new Restaurant("bikaran",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456788", "123")

                , new Restaurant("Bahar",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456789", "123")

                , new Restaurant("topolooo",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 50.331243399093914), "09123456790", "123")};


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


        Food[] foods1 = {food20, food18, food16, food14, food12};
        Food[] foods2 = {food10, food8, food6, food4, food2};
        Food[] foods3 = {food19, food17, food15, food13, food11};
        Food[] foods4 = {food9, food7, food5, food3, food1};
        Food[] foods5 = {food20, food19, food18, food17, food16};
        Food[] foods6 = {food15, food13, food11, food14, food12};
        Food[] foods7 = {food10, food9, food8, food7, food6};
        Food[] foods8 = {food5, food4, food3, food2, food1};
        Food[] foods9 = {food20, food15, food10, food5, food1};
        Food[] foods10 = {food15, food12, food9, food6, food3};

        for (Restaurant res : restaurant)
            restaurants.add(res);

        restaurants.get(0).addAllMenu(foods1);
        restaurants.get(2).addAllMenu(foods2);
        restaurants.get(4).addAllMenu(foods3);
        restaurants.get(6).addAllMenu(foods4);
        restaurants.get(8).addAllMenu(foods5);
        restaurants.get(1).addAllMenu(foods6);
        restaurants.get(3).addAllMenu(foods7);
        restaurants.get(5).addAllMenu(foods8);
        restaurants.get(7).addAllMenu(foods9);
        restaurants.get(9).addAllMenu(foods10);


        Order order1 = new Order(food20, 3, restaurants.get(0).getId());
        Order order2 = new Order(food18, 4, restaurants.get(0).getId());

        order1.setCustomerName("Ali Alavi");
        order2.setCustomerName("Naghi Naghavi");

        order1.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)", 34.717676891099835, 51.331243399093914));
        order2.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)", 35.717676891099835, 25.331243399093914));

        order1.setStatus();

        Order[] orders = {order2, order1};

        for (Order order : orders) {
            order.setRestaurantName(restaurants.get(0).getName());
            restaurants.get(0).addOrder(order);
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


        for (int i = 0; i < restaurants.size(); i++) {

            int min = 0;
            int max = 50;
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);

            restaurants.get(i).addRate(random_int/10);
            restaurants.get(i).setSendingRangeRadius(random_int*100);
            restaurants.get(i).setDays("shanbe ta pangshnbe");
            restaurants.get(i).setHour("as saat 13 ta 23");
            restaurants.get(i).addComment(comment);
            restaurants.get(i).addComment(comment2);
            restaurants.get(i).addComment(comment3);
            restaurants.get(i).addComment(comment4);
            restaurants.get(i).addComment(comment5);
            restaurants.get(i).addComment(comment6);
            restaurants.get(i).addComment(comment7);
            restaurants.get(i).addComment(comment8);
            for (int j = 0; j < restaurants.get(i).getMenu().size(); j++) {
                restaurants.get(i).addTypeFood(restaurants.get(i).getMenu().get(j).getTypeFood());
            }
        }


        restaurants.get(0).setCashSales(420);
        restaurants.get(0).setCashSales(400);
        restaurants.get(0).setCashSales(500);
        restaurants.get(0).setCashSales(600);
        restaurants.get(0).setCashSales(300);
        restaurants.get(0).setCashSales(700);
        restaurants.get(0).setCashSales(660);
        restaurants.get(0).setCashSales(500);
        restaurants.get(0).setCashSales(530);
        restaurants.get(0).setCashSales(610);
        restaurants.get(0).setCashSales(440);
        restaurants.get(0).setCashSales(460);
        restaurants.get(0).setCashSales(390);
        restaurants.get(0).setCashSales(360);
        restaurants.get(0).setCashSales(560);
        restaurants.get(0).setCashSales(550);
        restaurants.get(0).setCashSales(440);
        restaurants.get(0).setCashSales(390);
        restaurants.get(0).setCashSales(370);
        restaurants.get(0).setCashSales(650);
        restaurants.get(0).setCashSales(600);
        restaurants.get(0).setCashSales(550);
        restaurants.get(0).setCashSales(500);
        restaurants.get(0).setCashSales(300);
        restaurants.get(0).setCashSales(420);
        restaurants.get(0).setCashSales(330);
        restaurants.get(0).setCashSales(460);
        restaurants.get(0).setCashSales(520);
        restaurants.get(0).setCashSales(500);
        restaurants.get(0).setCashSales(400);

        restaurants.get(0).setOnlineSales(600);
        restaurants.get(0).setOnlineSales(900);
        restaurants.get(0).setOnlineSales(300);
        restaurants.get(0).setOnlineSales(300);
        restaurants.get(0).setOnlineSales(320);
        restaurants.get(0).setOnlineSales(400);
        restaurants.get(0).setOnlineSales(370);
        restaurants.get(0).setOnlineSales(660);
        restaurants.get(0).setOnlineSales(750);
        restaurants.get(0).setOnlineSales(600);
        restaurants.get(0).setOnlineSales(430);
        restaurants.get(0).setOnlineSales(460);
        restaurants.get(0).setOnlineSales(450);
        restaurants.get(0).setOnlineSales(340);
        restaurants.get(0).setOnlineSales(500);
        restaurants.get(0).setOnlineSales(550);
        restaurants.get(0).setOnlineSales(490);
        restaurants.get(0).setOnlineSales(450);
        restaurants.get(0).setOnlineSales(380);
        restaurants.get(0).setOnlineSales(570);
        restaurants.get(0).setOnlineSales(600);
        restaurants.get(0).setOnlineSales(650);
        restaurants.get(0).setOnlineSales(590);
        restaurants.get(0).setOnlineSales(480);
        restaurants.get(0).setOnlineSales(540);
        restaurants.get(0).setOnlineSales(440);
        restaurants.get(0).setOnlineSales(460);
        restaurants.get(0).setOnlineSales(490);
        restaurants.get(0).setOnlineSales(630);
        restaurants.get(0).setOnlineSales(500);


        /////////////////////////////    add customer


        Customer customer1 = new Customer("Ali", "Alavi", "1", "1");
        customer1.addFavoriteRestaurant(restaurants.get(0).getId());
        customer1.addAddress("asas", 233.21, 3243.24);


        customer1.addComment(comment3);
        customer1.addComment(comment7);

        customer1.addShoppingCart(food20, 3, restaurants.get(0).getId());
        customer1.addShoppingCart(food18, 2, restaurants.get(0).getId());
        customer1.addShoppingCart(food16, 1, restaurants.get(0).getId());
        for (Order order : customer1.getShoppingCart()) {
            order.setRestaurantName(restaurants.get(0).getName());
            order.setRestaurantAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)", 34.7176769835, 51.39093914));
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