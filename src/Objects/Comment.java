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
    public void setTimeComment(LocalDateTime  localDateTime) {
        this.timeComment = localDateTime;
    }
    public void setTimeReply(LocalDateTime localDateTime) {
        this.timeReply = localDateTime;
    }
    public String getComment(){
        return comment;
    }
    public String getReply(){
        return reply;
    }
    public String getRestaurantName(){
        return restaurantName;
    }
    public String getCustomerName(){
        return customerName;
    }
    public LocalDateTime getTimeComment(){
        return timeComment;
    }
    public LocalDateTime getTimeReply(){
        return timeReply;
    }
}
