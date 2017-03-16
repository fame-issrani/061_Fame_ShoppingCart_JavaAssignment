package Client;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import DAO.OrderDaoImpl;
import DAO.ProductDaoImpl;
import DAO.UserDaoImpl;
import Domain.Order;
import Domain.User;
import Service.OrderDetailsService;
import Service.OrderService;
import Service.UserService;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class OrderClient {
    public static void main(String[] args)throws Exception {

		OrderService ods=new OrderService();
		UserService us=new UserService();

		//To make a new Order


		ods.makeOrder(2,"pending");



        Order order=new Order();
		Timestamp t=new Timestamp(new Date().getTime());
        order.setTimestamp(t);
        order.setUserId(us.getUser(2));
        order.setStatus("pending");

		// To fetch any order using the orderID

		Order fetchedOrder=ods.getOrder(1);

		//To get a List of all orders

		List<Order> orders=ods.getAllOrders();

		//To update any order status by giving the orderId and the updates status:

		Order updatedOrder=ods.updateOrderStatus(1,"Delivered");

	}
}
