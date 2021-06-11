package Objects;


public class Food {
    String name, description;
    int discount, price;
    boolean  available;
    TypeFood typeFood;


    public Food(String name, String description, int price, int discount, boolean available, TypeFood typeFood) {
        this.name = name;
        if (discount != 0) {
            this.discount = discount;
        }
        this.description = description;
        this.price = price;
        this.available = available;
        this.typeFood = typeFood;
    }


    void setName(String name) {
        this.name = name;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setPrice(int price) {
        this.price = price;
    }

    void setDiscount(int discount) {
        if (discount != 0) {
            this.discount = discount;
        }
    }

    void setAvailable(boolean available) {
        this.available = available;
    }

    void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
    }



    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    int getPrice() {
        return price;
    }

    int getDiscount() {
        return discount;
    }

    boolean getAvailable() {
        return available;
    }

    TypeFood getTypeFood() {
        return typeFood;
    }

    public enum TypeFood {
        Pizza, Sandwich, Drinks, PersianFood, Dessert          //دسر
        , Appetizer       //پیش غذا
        , Fried           //سوخاری
        , Steaks, Breakfast, International, all
    }
}



