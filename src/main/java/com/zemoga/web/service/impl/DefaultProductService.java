package com.zemoga.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoga.web.dao.ProductDAO;
import com.zemoga.web.model.Product;
import com.zemoga.web.service.ProductService;

@Service
public class DefaultProductService implements ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> list() {
		return this.productDAO.list();
	}

	@Override
	public Product get(String sku) {
		return this.productDAO.get(sku);
	}

	@Override
	public void save(Product product) {
		this.productDAO.save(product);
	}

	@Override
	public void delete(String sku) {
		this.productDAO.delete(sku);
	}

}
