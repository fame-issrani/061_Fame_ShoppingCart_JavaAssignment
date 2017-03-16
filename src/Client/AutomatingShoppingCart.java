package Client;

import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;
import Domain.User;
import Service.OrderDetailsService;
import Service.OrderService;
import Service.ProductService;
import Service.UserService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by fame.issrani on 2/24/17.
 */

class ShoppingCart{
	UserService userService;
	ProductService productService;
	OrderService orderService;
	OrderDetailsService orderDetailsService;

	public ShoppingCart() {
		this.userService = new UserService();
		this.orderService = new OrderService();
		this.productService = new ProductService();
		this.orderDetailsService = new OrderDetailsService();
	}

	public void runUserSuite() {
		try {

			List<User> users = CSVFileReader.readUserCSV();

			for (User user : users) {
				userService.insertuser(user.getName(), user.getAddress(), user.getEmail());
			}

			//To get the list of all users
			List<User> list = userService.getAllUsers();
			for (User user : users) {
				System.out.println(user.toString());
			}

			//To get a specific user for its userId
			User user = userService.getUser(1);
			System.out.println(user.toString());
			System.out.println("\n Data Retrieval Successfull");

			//To remove a specific user from the database
			userService.deleteUser(3);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void runProductSuite() {
		try {

			// Fetching all the products from csv file productCsv.csv
			List<Product> products = CSVFileReader.readProductCSV();

			//Saving the List of products

			for (Product p : products) {
				productService.insertProduct(p.getProductCode(), p.getProductName(), p.getQuantity(), p.getUnitPrice());
			}

			//Getting a specific product by passing a productId
			Product p = productService.getProduct(2);
			System.out.println(p.toString());

			//To update a product
			Product product = new Product("AppJenga", "Jenga Puzzle", 34, 200);
			Product updatedProduct = productService.updateProduct(1, product);
			System.out.println(updatedProduct.toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void runOrderSuite() {
		try {


			//To make a new Order

			User user = userService.getUser(3);
			orderService.makeOrder(user.getUserId(), "Pending");


			Order order = new Order();
			Timestamp t = new Timestamp(new Date().getTime());
			order.setTimestamp(t);
			order.setUserId(userService.getUser(3));
			order.setStatus("pending");

			// To fetch any order using the orderID

			Order fetchedOrder = orderService.getOrder(1);

			//To get a List of all orders

			List<Order> orders = orderService.getAllOrders();

			//To update any order status by giving the orderId and the updates status:

			Order updatedOrder = orderService.updateOrderStatus(1, "Delivered");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void runOrderDetailsSuite() {
		List<OrderDetails> orderDetailsList=null;


		try{
			//To make Orders
			orderDetailsService.makeOrderDetail(1,1,1);
			orderDetailsService.makeOrderDetail(2,2,2);
			orderDetailsService.makeOrderDetail(2,2,200);

			//To get the list of all orderDetails as a list
			orderDetailsList=orderDetailsService.getAllOrderDetails();

			//To get a specific OrderDetail by passing OrderDetailId as a paramater
			orderDetailsService.getOrderDetail(1);

			//To generate a CSV file as bill
			orderDetailsService.generateOrderDetailsCSV();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}



	}
}
public class AutomatingShoppingCart {

	public static void main(String[] args) {
		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.runUserSuite();
		shoppingCart.runProductSuite();
		shoppingCart.runOrderSuite();
		shoppingCart.runOrderDetailsSuite();
	}
}
