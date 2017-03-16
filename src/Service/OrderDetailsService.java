package Service;

import DAO.DaoInterfaces.OrderDaoInterface;
import DAO.DaoInterfaces.OrderDetailsDaoInterface;
import DAO.DaoInterfaces.ProductDaoInterface;
import DAO.OrderDaoImpl;
import DAO.OrderDetailsDaoImpl;
import DAO.ProductDaoImpl;
import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;
import Exceptions.DataNotFound;
import Exceptions.OutOfStock;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by fame.issrani on 2/18/17.
 */
public class OrderDetailsService {

OrderDetailsDaoInterface orderDetailsDaoInterface;
ProductDaoInterface productDaoInterface;
OrderDaoInterface orderDaoInterface;


public OrderDetailsService(){
	this.orderDetailsDaoInterface=new OrderDetailsDaoImpl();
	this.productDaoInterface=new ProductDaoImpl();
	this.orderDaoInterface=new OrderDaoImpl();
}

public void generateOrderDetailsCSV(){
		try{
			List<OrderDetails> orderDetailsList= orderDetailsDaoInterface.getAllOrderDetails();
			BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/fame.issrani/Downloads/OrderDetailsCSV.csv"));
			String caVal="Serial No,\t Customer Name, \t Product Name,\t Quantity Ordered, \t Unit Price, \t Total Price, \t Order No. Reference \n";
			bw.write(caVal);
			for (OrderDetails orderDetails:orderDetailsList){

				int oDetailsId=orderDetails.getOrderDetailsId();
				Product product=orderDetails.getOrderDetailsProductId();
				int orderQty=orderDetails.getOrderDetailsQty();
				int unitPrice=product.getUnitPrice();
				int totalPrice=unitPrice*orderQty;
				Order order=orderDetails.getOrderDetailsOrderId();
				String userName=order.getUserId().getName();

				caVal=oDetailsId+", \t"+userName+", \t"+product.getProductName()+", \t"+orderQty+", \t"+unitPrice+", \t"+totalPrice+", \t"+order.getOrderId()+"\n";
				bw.write(caVal);
			}
			bw.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		System.out.println("OrderDetailsCSV.csv has been generated in Downloads directory");
	}

public void makeOrderDetail(int productId, int orderId,int qtyPurchased)throws Exception {

	Product product=productDaoInterface.getProductForProductId(productId);
	Order order=orderDaoInterface.getOrderForOrderId(orderId);
	if(product.getQuantity()-qtyPurchased>=0) {
		product.setQuantity(product.getQuantity() - qtyPurchased);
		try {
			productDaoInterface.updateProductInfo(productId, product);
			OrderDetails orderDetails = new OrderDetails(product, qtyPurchased, product.getUnitPrice(), qtyPurchased * product.getUnitPrice(), order);
			orderDetailsDaoInterface.save(orderDetails);
		} catch (Exception e) {
			throw e;
		}
	}else{
		throw new OutOfStock("The Order can't be placed, since this product is out of stock at the moment");
	}
}

public List<OrderDetails> getAllOrderDetails()throws Exception{
			return orderDetailsDaoInterface.getAllOrderDetails();
}

public OrderDetails getOrderDetail(int orderDetailId)throws Exception{
	return orderDetailsDaoInterface.getOrderDetailsForId(orderDetailId);
}

}
