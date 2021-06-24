package Objects;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    String comment, reply, customerName, restaurantName,timeComment, timeReply;


    public Comment(String comment) {
        this.comment =comment;
        timeComment = DateTimeFormatter.ofPattern("dd MMM HH:mm").format(LocalDateTime.now());
    }
    public void setReply(String reply){
        this.reply =reply;
        timeReply = DateTimeFormatter.ofPattern("dd MMM HH:mm").format(LocalDateTime.now());
    }
    public void setRestaurantName(String restaurantName){
        this.restaurantName =restaurantName;
    }
    public void setCustomerName(String customerName){
        this.customerName =customerName;
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
    public String getTimeComment(){
        return timeComment;
    }
    public String getTimeReply(){
        return timeReply;
    }
}
