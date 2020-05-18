package com.br.trackDonation.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.domains.Persistence;

@RestController
@RequestMapping("/")
public class DonatorController {
	Persistence persist = new Persistence();
	
	@GetMapping("/donator")
	public String home() {
		persist.teste();
		return "Teste";
	}
	
	@PostMapping("/")
	public String registerDonator(){
		return "String";
	}

}
