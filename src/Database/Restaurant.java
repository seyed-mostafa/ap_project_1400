package Database;


import Objects.*;
import Objects.Food.TypeFood;
import java.util.Map;

class Database {

    Restaurant importOneRestaurant() {
        Restaurant restaurant1 = new Restaurant("Reihoon",
                new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",
                        34.717676891099835, 51.331243399093914), "09123456782", "123");
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

        Food[] foodList1 = {food20, food18, food16, food14, food12};
        Food[] foodList2 = {food10, food8, food6, food4, food2};
        Food[] foodList3 = {food19, food17, food15, food13, food11};
        Food[] foodList4 = {food9, food7, food5, food3, food1};
        Food[] foodList5 = {food20, food19, food18, food17, food16};
        Food[] foodList6 = {food15, food13, food11, food14, food12};
        Food[] foodList7 = {food10, food9, food8, food7, food6};
        Food[] foodList8 = {food5, food4, food3, food2, food1};
        Food[] foodList9 = {food20, food15, food10, food5, food1};
        Food[] foodList10= {food15, food12, food9, food6, food3};

        Order order1 = new Order(Map.of(food1,2,food4,1,food13,5, food20,1),restaurant1.getId());
        Order order2 = new Order(Map.of(food3,1, food6,1, food5,9),restaurant1.getId());
        Order order3 = new Order(Map.of(food5,1, food7,1, food15,3),restaurant1.getId());
        Order order4 = new Order(Map.of(food15,4, food10,1, food13,3),restaurant1.getId());
        Order order5 = new Order(Map.of(food18,2, food9,1, food19,4),restaurant1.getId());
        Order order6 = new Order(Map.of(food19,1, food2,5, food11,2, food16,3),restaurant1.getId());
        Order order7 = new Order(Map.of(food18,2, food4,1),restaurant1.getId());
        Order order8 = new Order(Map.of(food2,1, food4,1, food7,1, food6,2),restaurant1.getId());
        Order order9 = new Order(Map.of(food15,1, food5,2, food8,3),restaurant1.getId());
        Order order10 = new Order(Map.of(food14,4, food4,1, food10,2),restaurant1.getId());
        Order order11 = new Order(Map.of(food9,3, food10,5, food8,1),restaurant1.getId());

        order1.setCustomerName("Ali Alavi");
        order2.setCustomerName("Naghi Naghavi");
        order3.setCustomerName("Soltan Soltani");
        order4.setCustomerName("Abbas Abbasi");
        order5.setCustomerName("Mostafa Mostafai");
        order6.setCustomerName("Gol Kharzare");
        order7.setCustomerName("Pari Varparide");
        order8.setCustomerName("Abdollah Nakhalaf");
        order9.setCustomerName("Amir Booghi");
        order10.setCustomerName("Noora Noori");
        order11.setCustomerName("Pari Varparide");


        order1.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",34.717676891099835, 51.331243399093914));
        order2.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",35.717676891099835, 25.331243399093914));
        order3.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",33.717676891099835, 25.331243399093914));
        order4.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",32.717676891099835, 25.331243399093914));
        order5.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",31.717676891099835, 25.331243399093914));
        order6.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",35.717676891099835, 26.331243399093914));
        order7.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",35.731750523607964, 51.47188366660937));
        order8.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",35.717676891099835, 20.331243399093914));
        order9.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",36.717676891099835, 25.331243399093914));
        order10.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",36.717676891099835, 25.331243399093914));
        order11.setCustomerAddress(new Location("golbarg,kh kerman,pelak 34,vahed 2,salam bar hame daram talash mikonam ke matn ziadi benevisam :)",36.717676891099835, 25.331243399093914));


        order1.setStatus();
        order3.setStatus();
        order7.setStatus();
        order5.setStatus();
        order8.setStatus();
        order9.setStatus();
        order2.setStatus();
        order6.setStatus();


        Order[] orders = {order11, order10, order9, order8, order7, order6, order5, order4, order3, order2, order1};

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

        return restaurant1;
    }

}
