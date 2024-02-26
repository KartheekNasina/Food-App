package com.jsp.foodapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.dto.Product;
import com.jsp.foodapp.dto.User;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@RequestMapping("/addproduct")
	public ModelAndView addProduct() {
		ModelAndView modelAndView = new ModelAndView("addproductform");
		Product product = new Product();
		modelAndView.addObject("product",product);
		return modelAndView;
	}
	@RequestMapping("/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
		ModelAndView modelAndView = new ModelAndView("adminoptions");
		productDao.saveProduct(product);
		modelAndView.addObject("message","product saved successfully");
		return modelAndView;
	}
	@RequestMapping("/viewallproducts")
	public ModelAndView viewAllProducts() {
		ModelAndView modelAndView = new ModelAndView("allproducts");
		List<Product> products = productDao.fetchAllProducts();
		modelAndView.addObject("productslist",products);
		return modelAndView;
	}
	@RequestMapping("update")
	public ModelAndView update(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("updateproductform");
		Product product = productDao.findById(id);
		modelAndView.addObject("productinfo",product);
		return modelAndView;
	}
	@RequestMapping("updateproduct")
	public ModelAndView updateProduct(@ModelAttribute("productinfo") Product product) {
		ModelAndView modelAndView=new ModelAndView("redirect:/viewallproducts");
		productDao.updateProduct(product);
		return modelAndView;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/viewallproducts");
		productDao.deleteProduct(id);
		return modelAndView;
	}
	@RequestMapping("/viewallproduct")
	public ModelAndView viewAllProduct() {
		ModelAndView modelAndView = new ModelAndView("displayallproducts");
		List<Product> products = productDao.fetchAllProducts();
		modelAndView.addObject("productslist",products);
		return modelAndView;
	}
}
