package cz.etn.etnshop.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface ProductDao {
	
	@Transactional(readOnly = false)
	void saveProduct(Product product);
    
	@Transactional(readOnly = true)
	List<Product> getProducts();

	@Transactional(readOnly = false)
    void deleteProduct(int productId);

	@Transactional(readOnly = false)
    void updateProduct(Product product);
	
	//Added for update product possibility
	@Transactional(readOnly = true)
	Product getProduct(int productId);
	
	//Added for fulltext search capability
	@Transactional(readOnly = true)
	List<Product> searchForProduct(String searchText);	
	
	//Added for indexing products from database for search purpose. Use it when there are products in database which were created outside the application
	@Transactional(readOnly = true)
	void indexProducts();
	
}
