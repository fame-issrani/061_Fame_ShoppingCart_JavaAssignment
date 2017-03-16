package Domain;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class Product {
    private int productId;
    private String productCode;
    private String productName;
    private int quantity;
    private int unitPrice;

    public Product() {
    }

public Product(int productId, String productCode, String productName, int quantity, int unitPrice) {
    this.productId = productId;
    this.productCode = productCode;
    this.productName = productName;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
}

public Product(String productCode, String productName, int quantity, int unitPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

@Override
public String toString() {
    return "Product{" +
            "productId=" + productId +
            ", productCode='" + productCode + '\'' +
            ", productName='" + productName + '\'' +
            ", quantity=" + quantity +
            ", unitPrice=" + unitPrice +
            '}';
}
}
