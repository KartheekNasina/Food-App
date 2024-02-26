package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.ProductDao;
import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;
import com.jsp.foodapp.dto.Product;

@Controller
public class ItemController {
	@Autowired
	ProductDao productDao;
	@RequestMapping("additem")
	public ModelAndView addItem(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView("additemform");
		Product product = productDao.findById(id);
		Item item=new Item();
		item.setName(product.getName());
		item.setCost(product.getCost());
		modelAndView.addObject("item",item);
		return modelAndView;
	}
	@RequestMapping("saveitem")
	public ModelAndView saveItem(@ModelAttribute("item")Item item,HttpSession httpSession) {
		item.setCost(item.getCost()*item.getQuantity());
		FoodOrder foodOrder = (FoodOrder) httpSession.getAttribute("foodorder");
		List<Item> items = foodOrder.getItems();
		if(items!=null) {
			items.add(item);
			foodOrder.setItems(items);
		}else {
			ArrayList<Item> items1 = new ArrayList<Item>();
			items1.add(item);
			foodOrder.setItems(items1);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/viewallproduct");
		return modelAndView;
	}
}
