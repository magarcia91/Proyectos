package com.mkyong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

	private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
	String message;

	@GetMapping("/hello")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("tasks", tasks);
		return "welcome";
	}

}