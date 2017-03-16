package DAO;

import java.sql.*;

import DAO.DaoInterfaces.ProductDaoInterface;
import Domain.Product;
import Exceptions.DataNotFound;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class ProductDaoImpl implements ProductDaoInterface{

    public void save(Product product) throws Exception {

        Connection conn= DBConnection.getConnection();

        String productName=product.getProductName();
        String productCode=product.getProductCode();
        int productQuantity=product.getQuantity();
        int productUnitPrice=product.getUnitPrice();

        PreparedStatement pst=conn.prepareCall("Insert into PRODUCT VALUES (null,?,?,?,?)");
        pst.setString(1,productCode);
        pst.setString(2,productName);
        pst.setInt(3,productQuantity);
        pst.setInt(4,productUnitPrice);
        pst.execute();
        System.out.println("Product Data has been saved to databse with primary Key as productId:");

    }

    public Product getProductForProductId(int productId){
    Product product=null;
    Connection conn= null;
    ResultSet rs=null;
    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = "+productId;
        PreparedStatement pst=conn.prepareStatement(sql);
        rs=pst.executeQuery(sql);

        while(rs.next()){
            //Retrieve by column name
            product=new Product(rs.getInt("PRODUCT_ID"),rs.getString("PRODUCT_CODE"),rs.getString("PRODUCT_NAME"),rs.getInt("PRODUCT_QUANTITY"),rs.getInt("PRODUCT_UNITPRICE"));
        }
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return product;
}

    public Product updateProductInfo(int productId, Product product)throws Exception{
        Product p=getProductForProductId(productId);
        if(p == null){
            throw new DataNotFound("Product with Product_Id"+productId+" does not exist");
        }else{
            Connection conn=DBConnection.getConnection();
            String sql="UPDATE PRODUCT set PRODUCT_CODE = ?, PRODUCT_NAME = ?, PRODUCT_QUANTITY= ?, PRODUCT_UNITPRICE= ? where PRODUCT_ID= ?";
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,product.getProductCode());
            pst.setString(2,product.getProductName());
            pst.setInt(3,product.getQuantity());
            pst.setInt(4,product.getUnitPrice());
            pst.setInt(5,productId);
            pst.execute();
            conn.close();
            System.out.println("Product details has been updated");
        }
            return getProductForProductId(productId);
    }
}
