package DAO;

import DAO.DaoInterfaces.OrderDetailsDaoInterface;
import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class OrderDetailsDaoImpl implements OrderDetailsDaoInterface {

public void save(OrderDetails orderDetails) throws Exception {

        Product prId=orderDetails.getOrderDetailsProductId();
        int odQty=orderDetails.getOrderDetailsQty();
        int odUnitPrice=orderDetails.getOrderDetailsUnitPrice();
        int odTotalPrice=orderDetails.getOrderDetailsTotalPrice();
        Order orderId= orderDetails.getOrderDetailsOrderId();

        Connection conn= DBConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("Insert into ORDER_DETAILS values (null,?,?,?,?,?)");
        pst.setInt(1,prId.getProductId());
        pst.setInt(2,odQty);
        pst.setInt(3,odUnitPrice);
        pst.setInt(4,odTotalPrice);
        pst.setInt(5,orderId.getOrderId());
        pst.execute();
        System.out.println("User Data has been saved to databse with primary Key as OD_ID :");
        conn.close();
    }

public OrderDetails getOrderDetailsForId(int odId)throws Exception{
        OrderDaoImpl odDao=new OrderDaoImpl();

        ProductDaoImpl pdDao=new ProductDaoImpl();
			OrderDetails orderDetails=null;
            Connection conn= null;
            ResultSet rs=null;
            try {
                conn = DBConnection.getConnection();
                String sql = "select * from ORDER_DETAILS where OD_ID= "+odId;
                PreparedStatement pst=conn.prepareStatement(sql);

//                pst.setInt(1,odId);
                rs=pst.executeQuery(sql);
                while(rs.next()){
                    //Retrieve by column name
					Product p=pdDao.getProductForProductId(rs.getInt("OD_PRODUCT_ID"));
					Order o=odDao.getOrderForOrderId(rs.getInt("OD_ORDER_ID"));
                     orderDetails = new OrderDetails(rs.getInt("OD_ID"),p ,rs.getInt("OD_QTY"),rs.getInt("OD_UNITPRICE"),rs.getInt("OD_TOTALPRICE"),o);
                }
                rs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
		return orderDetails;

    }

public List<OrderDetails> getAllOrderDetails()throws Exception{
    OrderDaoImpl odDao=new OrderDaoImpl();
    ProductDaoImpl pdDao=new ProductDaoImpl();
    List<OrderDetails> orderDetailsList=new ArrayList<OrderDetails>();
    OrderDetails orderDetails=null;
    Connection conn= null;
    ResultSet rs=null;
    try {
        conn = DBConnection.getConnection();
        String sql = "select * from ORDER_DETAILS";
        PreparedStatement pst=conn.prepareStatement(sql);
        rs=pst.executeQuery(sql);
        while(rs.next()){
            //Retrieve by column name
            Product p=pdDao.getProductForProductId(rs.getInt("OD_PRODUCT_ID"));
            Order o=odDao.getOrderForOrderId(rs.getInt("OD_ORDER_ID"));
            orderDetails = new OrderDetails(rs.getInt("OD_ID"),p ,rs.getInt("OD_QTY"),rs.getInt("OD_UNITPRICE"),rs.getInt("OD_TOTALPRICE"),o);
            orderDetailsList.add(orderDetails);
        }
        rs.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return orderDetailsList;

}
}
