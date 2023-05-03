package com.pfg.soledad_aprendizaje.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping(path = "/")
	public String index() {
		return "index";
	}

}
