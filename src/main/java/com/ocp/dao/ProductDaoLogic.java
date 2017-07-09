package com.ocp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ocp.model.Product;

@Repository("productDao")
public class ProductDaoLogic extends AbstractDao implements ProductDao {

	public void saveEmployee(Product employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {

			Criteria criteria = getSession().createCriteria(Product.class);
		List<Product> products = criteria.list();
	
		
		return products;
	}

	@Override
	public void saveProduct(Product product) {
		persist(product);

	}

	@Override
	public Product findProductById(String id) {
		Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("productId", Integer.parseInt(id) ) );
		Product product = (Product) criteria.uniqueResult();
			
		
		return product;
	}

	@Override
	public void updateProduct(Product product) {
		getSession().update(product);
	}



	@Override
	public void deleteProductById(String id) {
		Query query = getSession().createQuery("DELETE Product WHERE productId = :id");
        query.setInteger("id", Integer.parseInt(id));
        query.executeUpdate();
	}

	@Override
	public Product findProductByCode(String productCode) {
		final Criteria criteria = getSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("productCode", productCode ) );
		Product product = (Product) criteria.uniqueResult();
		return product;
	}
}