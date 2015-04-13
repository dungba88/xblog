package org.xblog.services.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xblog.services.models.Helloworld;

@RestController
public class HelloworldController {

	@RequestMapping("/hello")
	public Helloworld hello(String name) {
		return new Helloworld(1, String.format("Hi %s!", name));
	}
}
