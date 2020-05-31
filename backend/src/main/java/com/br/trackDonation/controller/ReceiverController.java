package com.br.trackDonation.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.trackDonation.service.ReceiverService;

import io.swagger.annotations.ApiImplicitParam;

@RestController
@RequestMapping
public class ReceiverController {

	@Autowired
	private ReceiverService receiverService;

	@CrossOrigin
//	@ApiImplicitParam(name = "file-data", value = "inscrito, para-inscricao, historico", paramType = "formData", dataType = "file", required = false)
	@ApiImplicitParam(name = "address", value = "address", paramType = "query", dataType = "string", required = false)
	@PostMapping("receiver/register")
	public String register(@RequestParam String donationReceived, @RequestParam String name,
			@RequestParam String email, @RequestParam String rg, @RequestParam String dateOfBirth,
			@RequestParam String phone, @RequestParam String address, @RequestParam String family,
			@RequestParam Integer residentsQuantity, @RequestParam String monthGotDonation,
			@RequestPart("file-data") MultipartFile receiverPhoto) throws IOException {
		receiverPhoto.transferTo(
				new File("C:\\Users\\kaiqu\\Desktop\\trackDonation\\" + receiverPhoto.getOriginalFilename()));

		return receiverService.registerReceiver(name, donationReceived, email, rg, dateOfBirth, phone, address, family, residentsQuantity, monthGotDonation);
	}

	@CrossOrigin
	@GetMapping("/receiver")
	public List<Object[]> getAllReceivers() {
		return receiverService.getAllReceivers();
	}

	@CrossOrigin
	@PutMapping("/receiver")
	public String updateReceiver(@RequestParam Integer id, @RequestParam String donationReceived, @RequestParam String name,
			@RequestParam String email, @RequestParam String rg, @RequestParam String dateOfBirth,
			@RequestParam String phone, @RequestParam String address, @RequestParam String family,
			@RequestParam Integer residentsQuantity, @RequestParam String monthGotDonation,
			@RequestPart("file-data") MultipartFile receiverPhoto) throws IOException {
		return receiverService.updateReceiver(id, name, donationReceived, email, rg, dateOfBirth, phone, address, family, residentsQuantity, monthGotDonation);
	}

	@CrossOrigin
	@DeleteMapping("/receiver")
	public String deleteReceiver(@RequestParam Integer id) {
		return receiverService.deleteReceiver(id);
	}
}
