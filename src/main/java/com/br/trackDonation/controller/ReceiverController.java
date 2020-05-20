package com.br.trackDonation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.service.ReceiverService;

@RestController
@RequestMapping
public class ReceiverController {
	
	@Autowired
	private ReceiverService receiverService;
	
	@PostMapping("receiver/register")
	public String register(@RequestParam String name, @RequestParam String donation, @RequestParam String family) {
		return receiverService.registerReceiver(name, donation, family);
	}
}
