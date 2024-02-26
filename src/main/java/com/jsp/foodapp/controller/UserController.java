package com.jsp.foodapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.UserDao;
import com.jsp.foodapp.dto.User;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;
	@RequestMapping("/adduser")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("adduserform");
		User user = new User();
		modelAndView.addObject("user",user);
		return modelAndView;
	}
	@RequestMapping("/saveuser")
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		ModelAndView modelAndView = new ModelAndView("adminoptions");
		userDao.saveUser(user);
		modelAndView.addObject("message","user saved successfully");
		return modelAndView;
	}
	@RequestMapping("/loginuser")
	public ModelAndView loginUser() {
		ModelAndView modelAndView= new ModelAndView("userloginform");
		User user=new User();
		modelAndView.addObject(user);
		return modelAndView;
	}
	@RequestMapping("/validateuser")
	public ModelAndView loginUser(@ModelAttribute("user") User user,HttpServletRequest request) {
		User user1 = userDao.fetchUserByEmailAndPassword(user.getEmail(), user.getPassword());
		if(user1!=null) {
			ModelAndView modelAndView = new ModelAndView("useroptions");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user1);
			return modelAndView;
		}
		else {
			ModelAndView modelAndView = new ModelAndView("userloginform");
			modelAndView.addObject("message","Invalid User Credintials");
			return modelAndView;
		}
	}
}
