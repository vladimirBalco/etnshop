package cz.etn.etnshop.dao;

import java.util.List;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.WildcardQuery;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;


@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {

	@Override
	public void saveProduct(Product product) {
		persist(product);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProducts() {
		 Criteria criteria = getSession().createCriteria(Product.class);
	     return (List<Product>) criteria.list();
	}

	@Override
	public void deleteProduct(int productId) {
		Query query = getSession().createSQLQuery("delete from Product where id = :id");
        query.setInteger("id", productId);
        query.executeUpdate();
	}


	@Override
	public void updateProduct(Product product) {
		getSession().update(product);
		
	}

	//Added for update product possibility
	@Override
	public Product getProduct(int productId) {
		return (Product) getSession().get(Product.class, productId);
		
	}

	//Added for fulltext search capability
	@Override
	public List<Product> searchForProduct(String searchText) {
		    
		        FullTextSession fullTextSession = Search.getFullTextSession(getSession());
		        BooleanQuery bQuery = new BooleanQuery();
		        bQuery.add(new WildcardQuery(new Term("name", "*" + searchText + "*")), BooleanClause.Occur.SHOULD);
		        bQuery.add(new WildcardQuery(new Term("sn", "*" + searchText + "*")), BooleanClause.Occur.SHOULD);
		        org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(bQuery, Product.class);
		        @SuppressWarnings("unchecked")
				List<Product> result = hibQuery.list();
		        return result;		
	}

	//Added for indexing products from database for search purpose. Use it when there are products in database which were created outside the application
	@Override
	public void indexProducts() {
        try {
        	FullTextSession fullTextSession = Search.getFullTextSession(getSession());
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
	}
	
	
	

}
