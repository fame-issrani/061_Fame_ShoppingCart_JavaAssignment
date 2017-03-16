package Service;

import DAO.DaoInterfaces.OrderDaoInterface;
import DAO.DaoInterfaces.UserDaoInterface;
import DAO.OrderDaoImpl;
import DAO.UserDaoImpl;
import Domain.Order;
import Domain.User;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by fame.issrani on 2/18/17.
 */
public class OrderService {

OrderDaoInterface orderDaoInterface;
UserDaoInterface userDaoInterface;

public OrderService() {
	this.orderDaoInterface=new OrderDaoImpl();
	this.userDaoInterface=new UserDaoImpl();
}

public void makeOrder(int userId,String status) throws Exception {
	System.out.println(userId+status);
	User user=userDaoInterface.getUserForId(userId);
	Timestamp time=new Timestamp(new Date().getTime());
	Order order =new Order(user,time,status);
	orderDaoInterface.save(order);
}

public Order getOrder(int orderId){
	return orderDaoInterface.getOrderForOrderId(orderId);
}

public List<Order> getAllOrders(){
	return orderDaoInterface.getAllOrders();
}

public Order updateOrderStatus(int orderId,String status) throws Exception {
return orderDaoInterface.updateOrder(orderId, status);
}
}
