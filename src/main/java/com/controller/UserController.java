package com.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;


@Controller
public class UserController {
	@Autowired
	UserDao userDao;

	@GetMapping("/listusers")
	public String getAllUsers(Model model) {
		List<UserBean> users = userDao.getAllUsers();
		model.addAttribute("users",users);
		return "ListUsers";
	}
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") int userId,Model model) {
		userDao.deleteUser(userId);
//		List<UserBean> users = userDao.getAllUsers(); 
//		model.addAttribute("users",users);
//		return "ListUsers";//call jsp 

		return "redirect:/listusers";//call url 
	
	}
	@GetMapping("/viewuser")
		public String viewUser(@RequestParam("userId") int userId,Model model) {
			UserBean user = userDao.getUserByUserId(userId);
			model.addAttribute("user", user);
			return "ViewUser";
		}
		
	}

