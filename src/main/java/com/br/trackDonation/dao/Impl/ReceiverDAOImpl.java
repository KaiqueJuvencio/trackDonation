package com.br.trackDonation.dao.Impl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ReceiverDAOImpl {
	
	@GetMapping("receiver/register")
	public String register(@RequestParam String name, @RequestParam String donation, @RequestParam String family) {
		return "Cadastrado com sucesso";
	}
}
