package com.br.trackDonation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.service.DonatorService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class DonatorController {

	@Autowired
	private DonatorService donatorService;

	@PostMapping("/donator/register")
	public String register(@RequestParam(required = false) String name, @RequestParam(required = false) String donation,
			@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
		return donatorService.registerDonator(name, donation, email, phone);
	}

	@GetMapping("/donator")
	public List<Object[]> getAllDonators() {
		return donatorService.getAllDonators();
	}

	@PutMapping("/donator")
	public String updateDonator(@RequestParam Integer id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String donation, @RequestParam(required = false) String email,
			@RequestParam(required = false) String phone) {
		return donatorService.updateDonator(id, name, donation, email, phone);
	}

	@DeleteMapping("/donator")
	public String deleteDonator(@RequestParam Integer id) {
		return donatorService.deleteDonator(id);
	}
}
