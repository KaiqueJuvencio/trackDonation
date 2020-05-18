package com.br.trackDonation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.service.DonatorService;

@RestController
@RequestMapping("/")
public class DonatorController {
	
	@Autowired
	private DonatorService donatorService;
	
	@GetMapping("/donator/register")
	public String register(@RequestParam String name, @RequestParam String donation, @RequestParam String email, @RequestParam String phone) {
		return donatorService.registerDonator(name, donation, email, phone);
	}
	
	@PostMapping("/")
	public String registerDonator(){
		return "String";
	}

}
