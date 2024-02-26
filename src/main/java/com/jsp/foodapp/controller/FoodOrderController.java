package com.jsp.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.FoodOrderDao;
import com.jsp.foodapp.dao.ItemDao;
import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.dto.FoodOrder;
import com.jsp.foodapp.dto.Item;
import com.jsp.foodapp.dto.User;

@Controller
public class FoodOrderController {
	@Autowired
	UserDao userDao;
	@Autowired
	FoodOrderDao foodOrderDao;
	@Autowired
	ItemDao itemDao;
	@RequestMapping("/addfoodorder")
	public ModelAndView addFoodOrder() {
		ModelAndView modelAndView = new ModelAndView("addfoodorderform");
		FoodOrder foodOrder = new FoodOrder();
		modelAndView.addObject("foodorder",foodOrder);
		return modelAndView;
	}
	@RequestMapping("/savefoodorder")
	public ModelAndView saveFoodOrder(@ModelAttribute("foodorder") FoodOrder foodOrder,HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("redirect:/viewallproduct");
		httpSession.setAttribute("foodorder", foodOrder);
		return modelAndView;
	}
	@RequestMapping("/savefoodorders")
	public ModelAndView saveFoodOrders(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		FoodOrder foodOrder = (FoodOrder) httpSession.getAttribute("foodorder");
		List<FoodOrder> foodorders = user.getFoodorders();
		if(foodorders!=null) {
			foodorders.add(foodOrder);
			int totalcost=0;
			List<Item> items = foodOrder.getItems();
			for(Item item:items)totalcost+=item.getCost();
			foodOrder.setTotalcost(totalcost);
			user.setFoodorders(foodorders);
			foodOrder.setUser(user);
		}else {
			ArrayList<FoodOrder> foodOrders1 = new ArrayList<FoodOrder>();
			foodOrders1.add(foodOrder);
			int totalcost=0;
			List<Item> items = foodOrder.getItems();
			for(Item item:items)totalcost+=item.getCost();
			foodOrder.setTotalcost(totalcost);
			foodOrder.setUser(user);
			user.setFoodorders(foodOrders1);
		}
		userDao.updateUser(user);
		List<FoodOrder> fetchFoodOrder = foodOrderDao.fetchFoodOrder();
		List<Item> fetchItem = itemDao.fetchItem();
		ModelAndView modelAndView = new ModelAndView("displaybill");
		modelAndView.addObject("foodorder",fetchFoodOrder.get(fetchFoodOrder.size()-1));
		modelAndView.addObject("fetchitemlist",fetchItem);
		return modelAndView;
	}
}
