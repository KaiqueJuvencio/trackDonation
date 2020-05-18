package com.br.trackDonation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DonatorController {
	
	@GetMapping("/donator")
	public String home() {
		return "Teste";
	}
	
	@PostMapping("/")
	public String registerDonator(){
		return "String";
	}

}
