package com.johnabbott.finalexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.finalexam.model.User;
import com.johnabbott.finalexam.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin() {
		ModelAndView modelView = new ModelAndView("login");
		modelView.addObject("user", new User());

		return modelView;
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView userRegister() {
		ModelAndView modelView = new ModelAndView("register");
		modelView.addObject("user", new User());

		return modelView;
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelView = new ModelAndView("home");
		modelView.addObject("user", new User());

		return modelView;
	}
	
	@RequestMapping(value = "checkuser", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute("user") User user) {
		if (service.checkUser(user))
			return "redirect:/home";
		else {
			return "redirect:/register";
		}
	}

	@RequestMapping(value = "registeruser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {
		if (service.registerUser(user)) {
			return "redirect:/home";
		}
		else {
			return "redirect:/login";
		}
	}
}
