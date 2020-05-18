package com.br.trackDonation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ReceiverController {
	
	@GetMapping("/receiver")
	public String getReceiver() {
		return "String";
	}
	
	@PostMapping
	public String registerReceiver(){
		return "String";
	}

}
