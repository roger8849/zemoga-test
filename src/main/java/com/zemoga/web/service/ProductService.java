package com.zemoga.web.service;

import java.util.List;

import com.zemoga.web.model.Product;

public interface ProductService {
	public List<Product> list();
	public Product get(String sku);
	public void save(Product product);
	public void delete(String sku);
}
