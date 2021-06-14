package Objects;
import java.time.LocalDateTime;

public class Comment {
    String comment, reply, customerName, restaurantName;
    LocalDateTime timeComment, timeReply;

    public Comment(String comment) {
        this.comment =comment;
        timeComment = LocalDateTime.now();
    }
    public void setReply(String reply){
        this.reply =reply;
        timeReply = LocalDateTime.now();
    }
    public void setRestaurantName(String restaurantName){
        this.restaurantName =restaurantName;
    }
    public void setCustomerName(String customerName){
        this.customerName =customerName;
    }
    String getComment(){
        return comment;
    }
    String getReply(){
        return reply;
    }
    String getRestaurantName(){
        return restaurantName;
    }
    String getCustomerName(){
        return customerName;
    }
    LocalDateTime getTimeComment(){
        return timeComment;
    }
    LocalDateTime getTimeReply(){
        return timeReply;
    }
}
