package Domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class Order {

    private int orderId;
    private User userId;
    private Timestamp timestamp;
    private String status;

public Order() {
}

public Order(int orderId, User userId, Timestamp timestamp, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.timestamp=timestamp;
        this.status = status;
    }

    public Order(User userId, Timestamp timestamp, String status) {
        this.userId = userId;
        this.timestamp=timestamp;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId.toString() +
                ", createdDate=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}
