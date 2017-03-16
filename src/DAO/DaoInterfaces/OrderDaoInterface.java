package DAO.DaoInterfaces;

import Domain.Order;

import java.util.List;

/**
 * Created by fame.issrani on 2/20/17.
 */
public interface OrderDaoInterface {

public void save(Order order)throws Exception;

public Order getOrderForOrderId(int orderId);

public List<Order> getAllOrders();

public Order updateOrder(int orderId, String status)throws Exception;
}
