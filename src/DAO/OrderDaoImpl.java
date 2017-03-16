package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import DAO.DaoInterfaces.OrderDaoInterface;
import Domain.Order;
import Domain.User;
import Exceptions.DataNotFound;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class OrderDaoImpl implements OrderDaoInterface {

    public void save(Order order) throws Exception {
		Connection conn= DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into ORDERS VALUES (null,?,?,?)");
		System.out.println(order.getUserId().getUserId());
        ps.setInt(1,order.getUserId().getUserId());
        ps.setTimestamp(2,order.getTimestamp());
        ps.setString(3,order.getStatus());
        ps.execute();

        System.out.println("Order Data has been saved to database with primary Key as ORDER_ID :");
    }

    public Order getOrderForOrderId(int orderId){
		Order order=null;
		UserDaoImpl udao=new UserDaoImpl();
		Connection conn= null;
		ResultSet rs=null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM ORDERS WHERE ORDER_ID = "+orderId;
			PreparedStatement pst=conn.prepareStatement(sql);
			rs=pst.executeQuery(sql);

			while(rs.next()){
				//Retrieve by column name

				User u=udao.getUserForId(rs.getInt("ORDER_ID"));
				order=new Order(rs.getInt("ORDER_ID"),u,rs.getTimestamp("ORDER_CREATED_DATE"),rs.getString("ORDER_STATUS"));
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return order;
    }

    public List<Order> getAllOrders(){
		UserDaoImpl udao=new UserDaoImpl();
		List<Order> orders=new ArrayList<Order>();
		Connection conn= null;
		ResultSet rs=null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM ORDERS";
			PreparedStatement pst=conn.prepareStatement(sql);
			rs=pst.executeQuery(sql);

			while(rs.next()){
				//Retrieve by column name

				User u=udao.getUserForId(rs.getInt("ORDER_ID"));
				Order order=new Order(rs.getInt("ORDER_ID"),u,rs.getTimestamp("ORDER_CREATED_DATE"),rs.getString("ORDER_STATUS"));
				orders.add(order);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return orders;
	}

	public Order updateOrder(int orderId, String status)throws Exception{
		Order o=getOrderForOrderId(orderId);
		if(o == null){
			throw new DataNotFound("Order with Order Id: "+orderId+" does not exists ");
		}else{
			Connection conn=DBConnection.getConnection();
			String sql="Update ORDERS set ORDER_STATUS= ? WHERE ORDER_ID=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,status);
			pst.setInt(2,orderId);
			pst.execute();
			System.out.println("Order Updated Successfully");
			conn.close();

		}
		return getOrderForOrderId(orderId);
	}
}
