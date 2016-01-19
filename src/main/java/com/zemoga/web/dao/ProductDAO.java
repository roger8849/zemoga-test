package com.zemoga.web.dao;

import java.util.List;

import com.zemoga.web.model.Product;

public interface ProductDAO {
	public List<Product> list();
	public Product get(String sku);
	public void save(Product product);
	public void delete(String sku);
}
