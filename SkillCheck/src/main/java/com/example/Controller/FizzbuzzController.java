package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fizzbuzz")
public class FizzbuzzController {

	@GetMapping("/home")
	public String fizzbuzzController() {
		return "fizzbuzz/home";
	}
}
