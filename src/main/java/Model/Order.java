package Model;
import java.time.LocalDateTime;
import java.util.*;
public class Order implements java.io.Serializable {
    private static int counter=0;
    private String orderId;
    private int clientId;
    private LocalDateTime orderDate;
    private int orderPrice;

    public Order (int clientId,LocalDateTime orderDate,int orderPrice) {
        this.clientId = clientId;
        this.orderDate = orderDate;
        this.orderPrice = orderPrice;
        this.orderId = Integer.toString(clientId) + Integer.toString(counter) +Integer.toString(orderPrice);
        counter++;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", clientId=" + clientId +
                ", orderDate=" + orderDate +
                ", orderPrice=" + orderPrice +
                '}';
    }

    public int getClientId() {
        return clientId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }
}