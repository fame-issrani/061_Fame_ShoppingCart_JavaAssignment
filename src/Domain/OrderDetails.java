package Domain;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class OrderDetails {
    private int orderDetailsId;
    private Product orderDetailsProductId;
    private int orderDetailsQty;
    private int orderDetailsUnitPrice;
    private int orderDetailsTotalPrice;
    private Order orderDetailsOrderId;

    public OrderDetails() {
    }

    public OrderDetails(int orderDetailsId, Product orderDetailsProductId, int orderDetailsQty, int orderDetailsUnitPrice, int orderDetailsTotalPrice, Order orderDetailsOrderId) {
        this.orderDetailsId = orderDetailsId;
        this.orderDetailsProductId = orderDetailsProductId;
        this.orderDetailsQty = orderDetailsQty;
        this.orderDetailsUnitPrice = orderDetailsUnitPrice;
        this.orderDetailsTotalPrice = orderDetailsTotalPrice;
        this.orderDetailsOrderId = orderDetailsOrderId;
    }

    public OrderDetails(Product orderDetailsProductId, int orderDetailsQty, int orderDetailsUnitPrice, int orderDetailsTotalPrice, Order orderDetailsOrderId) {
        this.orderDetailsProductId = orderDetailsProductId;
        this.orderDetailsQty = orderDetailsQty;
        this.orderDetailsUnitPrice = orderDetailsUnitPrice;
        this.orderDetailsTotalPrice = orderDetailsTotalPrice;
        this.orderDetailsOrderId = orderDetailsOrderId;
    }

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Product getOrderDetailsProductId() {
        return orderDetailsProductId;
    }

    public void setOrderDetailsProductId(Product orderDetailsProductId) {
        this.orderDetailsProductId = orderDetailsProductId;
    }

    public int getOrderDetailsQty() {
        return orderDetailsQty;
    }

    public void setOrderDetailsQty(int orderDetailsQty) {
        this.orderDetailsQty = orderDetailsQty;
    }

    public int getOrderDetailsUnitPrice() {
        return orderDetailsUnitPrice;
    }

    public void setOrderDetailsUnitPrice(int orderDetailsUnitPrice) {
        this.orderDetailsUnitPrice = orderDetailsUnitPrice;
    }

    public int getOrderDetailsTotalPrice() {
        return orderDetailsTotalPrice;
    }

    public void setOrderDetailsTotalPrice(int orderDetailsTotalPrice) {
        this.orderDetailsTotalPrice = orderDetailsTotalPrice;
    }

    public Order getOrderDetailsOrderId() {
        return orderDetailsOrderId;
    }

    public void setOrderDetailsOrderId(Order orderDetailsOrderId) {
        this.orderDetailsOrderId = orderDetailsOrderId;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailsId=" + orderDetailsId +
                ", orderDetailsProductId=" + orderDetailsProductId +
                ", orderDetailsQty=" + orderDetailsQty +
                ", orderDetailsUnitPrice=" + orderDetailsUnitPrice +
                ", orderDetailsTotalPrice=" + orderDetailsTotalPrice +
                ", orderDetailsOrderId=" + orderDetailsOrderId +
                '}';
    }
}
