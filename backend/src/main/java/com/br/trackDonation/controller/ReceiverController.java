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
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping
public class ReceiverController {

	@Autowired
	private ReceiverService receiverService;

	@CrossOrigin
//	@ApiImplicitParam(name = "file-data", value = "inscrito, para-inscricao, historico", paramType = "formData", dataType = "file", required = false)
	@PostMapping("receiver/register")
	public String register(@RequestParam(required=false) String donationReceived, @RequestParam(required=false) String name, @RequestParam(required=false) String email,
			@RequestParam(required=false) String rg, @RequestParam(required=false) String dateOfBirth, @RequestParam(required=false) String phone,
			@RequestParam(required=false) String address, @RequestParam(required=false) String family, @RequestParam(required=false) Integer residentsQuantity,
			@RequestParam(required=false) String monthGotDonation, @RequestPart(required=false) MultipartFile receiverPhoto)
			throws IOException {
		if(receiverPhoto!=null) {
		receiverPhoto.transferTo(
				new File("C:\\Users\\kaiqu\\Desktop\\trackDonation\\" + receiverPhoto.getOriginalFilename()));
		}

		return receiverService.registerReceiver(name, donationReceived, email, rg, dateOfBirth, phone, address, family,
				residentsQuantity, monthGotDonation);
	}

	@CrossOrigin
	@GetMapping("/receiver")
	public List<Object[]> getAllReceivers() {
		return receiverService.getAllReceivers();
	}

	@CrossOrigin
	@PutMapping("/receiver")
	public String updateReceiver(@RequestParam Integer id, @RequestParam(required=false) String donationReceived,
			@RequestParam(required=false) String name, @RequestParam(required=false) String email, @RequestParam(required=false) String rg,
			@RequestParam(required=false) String dateOfBirth, @RequestParam(required=false) String phone, @RequestParam(required=false) String address,
			@RequestParam(required=false) String family, @RequestParam(required=false) Integer residentsQuantity, @RequestParam(required=false) String monthGotDonation,
			@RequestPart(required=false) MultipartFile receiverPhoto) throws IOException {
		return receiverService.updateReceiver(id, name, donationReceived, email, rg, dateOfBirth, phone, address,
				family, residentsQuantity, monthGotDonation);
	}

	@CrossOrigin
	@DeleteMapping("/receiver")
	public String deleteReceiver(@RequestParam Integer id) {
		return receiverService.deleteReceiver(id);
	}
}
