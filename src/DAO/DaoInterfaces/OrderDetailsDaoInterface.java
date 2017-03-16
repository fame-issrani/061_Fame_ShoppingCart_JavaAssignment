package DAO.DaoInterfaces;

import DAO.DBConnection;
import DAO.OrderDaoImpl;
import DAO.ProductDaoImpl;
import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fame.issrani on 2/20/17.
 */
public interface OrderDetailsDaoInterface {

public void save(OrderDetails orderDetails) throws Exception;

public OrderDetails getOrderDetailsForId(int odId)throws Exception;

public List<OrderDetails> getAllOrderDetails()throws Exception;
}
