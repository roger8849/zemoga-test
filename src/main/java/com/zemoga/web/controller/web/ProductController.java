package com.zemoga.web.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zemoga.web.model.Product;
import com.zemoga.web.service.ProductService;
import com.zemoga.web.util.ApplicationConstants;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "getProducts")
	public ModelAndView showProducts(){
		List<Product> products = productService.list();
		ModelAndView model = new ModelAndView(ApplicationConstants.PRODUCTS_PATH);
		model.addObject("products", products);
		return model;
	}
	
}
