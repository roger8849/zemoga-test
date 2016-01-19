package com.zemoga.web.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zemoga.web.dao.ProductDAO;
import com.zemoga.web.model.Product;

@Repository
public class DefaultProductDAO implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Product> list() {
		List<Product> products = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return products;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Product get(String sku) {
		Product product = null;
		StringBuilder builder = new StringBuilder("from PRODUCTS where sku=").append(sku);
		Query query = sessionFactory.getCurrentSession().createQuery(builder.toString());
		List<Product> products = (List<Product>) query.list();
		
		if (products != null && !products.isEmpty()) {
			product = products.get(0);
		}
		
		return product;
	}

	@Override
	@Transactional
	public void save(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@Override
	@Transactional
	public void delete(String sku) {
		Product product = new Product();
		product.setSku(sku);
		sessionFactory.getCurrentSession().delete(product);
	}

}
