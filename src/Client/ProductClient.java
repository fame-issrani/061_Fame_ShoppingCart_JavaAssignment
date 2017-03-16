package Client;

import java.sql.SQLException;
import java.util.List;

import DAO.ProductDaoImpl;
import Domain.Product;
import Service.ProductService;

/**
 * Created by fame.issrani on 2/16/17.
 */
public class ProductClient {
    public static void main(String[] args) {
        try {

			ProductService productService=new ProductService();

			// Fetching all the products from csv file productCsv.csv
        	List<Product> products=CSVFileReader.readProductCSV();

			//Saving the List of products

			for(Product p:products){
				productService.insertProduct(p.getProductCode(),p.getProductName(),p.getQuantity(),p.getUnitPrice());
            }

     //Getting a specific product by passing a productId
        Product p=productService.getProduct(2);
        System.out.println(p.toString());

			//To update a product
			Product product=new Product("AppJenga","Jenga Puzzle",34,200);
			Product updatedProduct=productService.updateProduct(1,product);
				System.out.println(updatedProduct.toString());

        } /*catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/ catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
