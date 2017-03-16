package Service;

import DAO.DaoInterfaces.ProductDaoInterface;
import DAO.ProductDaoImpl;
import Domain.Product;

/**
 * Created by fame.issrani on 2/18/17.
 */
public class ProductService {

ProductDaoInterface productDaoInterface;

public ProductService(){
	this.productDaoInterface=new ProductDaoImpl();
}

public void insertProduct(String productCode,String productName,int product_quantity_availability, int productUnitPrice)throws Exception{
	Product product=new Product(productCode,productName,product_quantity_availability,productUnitPrice);
	productDaoInterface.save(product);
}

public Product getProduct(int productId){
	return productDaoInterface.getProductForProductId(productId);
}

public Product updateProduct(int productId, Product product) throws Exception {
	return productDaoInterface.updateProductInfo(productId,product);
}

}
