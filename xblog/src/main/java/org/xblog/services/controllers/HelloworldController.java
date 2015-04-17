package org.xblog.services.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xblog.services.models.Helloworld;

@Controller
public class HelloworldController {

	@RequestMapping("/hello")
	public String hello(String name, Model model) {
		model.addAttribute("helloworld", new Helloworld(1, String.format("Hi %s!", name)));
		return "helloView";
	}
}
