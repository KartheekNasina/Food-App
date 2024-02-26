package com.jsp.foodapp.controller;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.foodapp.dao.AdminDao;
import com.jsp.foodapp.dto.Admin;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;
	
	@RequestMapping("/addadmin")
	public ModelAndView m1() {
		ModelAndView modelAndView = new ModelAndView("adminform");
		Admin admin = new Admin();
		admin.setEmail("admin");
		admin.setPassword("admin");
		adminDao.saveAdmin(admin);
		return modelAndView;
	}
	@RequestMapping("/validate")
	public ModelAndView login(HttpServletRequest httpServletRequest) {
		String email=httpServletRequest.getParameter("email");
		String password=httpServletRequest.getParameter("password");
		Admin admin =adminDao.fetchAdminByEmailAndPassword(email, password);
		if(admin!=null) {
			ModelAndView modelAndView = new ModelAndView("adminoptions");
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView("adminloginform");
			modelAndView.addObject("msg","Invalid credentials");
			return modelAndView;
		}
	}
}
