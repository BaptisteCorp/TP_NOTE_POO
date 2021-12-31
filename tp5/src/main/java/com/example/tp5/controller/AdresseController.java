package com.example.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdresseController {
	
	
	@GetMapping("/adresse")
	public String showAddresses(Model model) {
		
		return "adresse";
	}
}
