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


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        if (discount != 0) {
            this.discount = discount;
        }
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public boolean getAvailable() {
        return available;
    }

    public TypeFood getTypeFood() {
        return typeFood;
    }

    public enum TypeFood {
        Pizza, Sandwich, Drinks, PersianFood, Dessert          //دسر
        , Appetizer       //پیش غذا
        , Fried           //سوخاری
        , Steaks, Breakfast, International, all
    }
}



