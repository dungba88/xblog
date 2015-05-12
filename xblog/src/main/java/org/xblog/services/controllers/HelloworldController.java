package org.xblog.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xblog.models.dao.EntityHelper;
import org.xblog.models.entities.User;

@Controller
public class HelloworldController {
	
	@Autowired
	private EntityHelper helper;
	
	@RequestMapping("/hello/{id}")
	public String hello(@PathVariable int id, Model model) {
		User user = helper.getEntityFromId(User.class, id);
		model.addAttribute("user", user);
		return "helloView";
	}
}
