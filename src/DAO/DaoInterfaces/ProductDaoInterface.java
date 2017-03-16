package DAO.DaoInterfaces;

import Domain.Product;

/**
 * Created by fame.issrani on 2/20/17.
 */
public interface ProductDaoInterface {

public void save(Product product)throws Exception;

public Product getProductForProductId(int productId);

public Product updateProductInfo(int productId, Product product)throws Exception;
}
