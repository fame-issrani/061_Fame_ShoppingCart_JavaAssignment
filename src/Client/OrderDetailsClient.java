package Client;

import DAO.OrderDaoImpl;
import DAO.OrderDetailsDaoImpl;
import DAO.ProductDaoImpl;
import DAO.UserDaoImpl;
import Domain.Order;
import Domain.OrderDetails;
import Domain.Product;
import Domain.User;
import Service.OrderDetailsService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by fame.issrani on 2/17/17.
 */
public class OrderDetailsClient {
    public static void main(String[] args){

        OrderDetailsService ods=new OrderDetailsService();
        List<OrderDetails> orderDetailsList=null;


        try{
            //To make Orders
            ods.makeOrderDetail(1,1,1);
            ods.makeOrderDetail(2,2,2);
            ods.makeOrderDetail(2,2,200);

            //To get the list of all orderDetails as a list
			orderDetailsList=ods.getAllOrderDetails();

            //To get a specific OrderDetail by passing OrderDetailId as a paramater
            ods.getOrderDetail(1);

			//To generate a CSV file as bill
			ods.generateOrderDetailsCSV();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}

