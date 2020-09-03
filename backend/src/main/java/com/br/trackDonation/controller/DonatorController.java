package com.br.trackDonation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.domains.DonatorVO;
import com.br.trackDonation.service.DonatorService;

@CrossOrigin
@RestController
@RequestMapping("/donator")
public class DonatorController {

	@Autowired
	private DonatorService donatorService;

	@PostMapping
	public ResponseEntity<DonatorVO> register(@RequestParam(required = false) String name, @RequestParam(required = false) String donation,
			@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
		DonatorVO donatorVO = donatorService.registerDonator(name, donation, email, phone); 
		return ResponseEntity.ok(donatorVO); 
	}

	@GetMapping
	public List<Object[]> getAllDonators() {
		return donatorService.getAllDonators();
	}

	@PutMapping
	public String updateDonator(@RequestParam Integer id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String donation, @RequestParam(required = false) String email,
			@RequestParam(required = false) String phone) {
		return donatorService.updateDonator(id, name, donation, email, phone);
	}
	@CrossOrigin
	@DeleteMapping
	public String deleteDonator(@RequestParam Integer id) {
		return donatorService.deleteDonator(id);
	}
}
