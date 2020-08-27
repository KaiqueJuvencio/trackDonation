package com.br.trackDonation.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.trackDonation.domains.ReceiverVO;
import com.br.trackDonation.service.ReceiverService;

@CrossOrigin
@RestController
@RequestMapping("/receiver")
public class ReceiverController {

	@Autowired
	private ReceiverService receiverService;

	@PostMapping
	public ResponseEntity<ReceiverVO> register(@RequestParam(required=false) String donationReceived, @RequestParam(required=false) String name, @RequestParam(required=false) String email,
			@RequestParam(required=false) String rg, @RequestParam(required=false) String dateOfBirth, @RequestParam(required=false) String phone,
			@RequestParam(required=false) String address, @RequestParam(required=false) String family, @RequestParam(required=false) Integer residentsQuantity,
			@RequestParam(required=false) String monthGotDonation, @RequestPart(required=false) MultipartFile receiverPhoto)
			throws IOException {
		if(receiverPhoto!=null) {
		receiverPhoto.transferTo(
				new File("C:\\Users\\kaiqu\\Desktop\\trackDonation\\" + receiverPhoto.getOriginalFilename()));
		}

		ReceiverVO receiverVO = receiverService.registerReceiver(name, donationReceived, email, rg, dateOfBirth, phone, address, family,
				residentsQuantity, monthGotDonation);
		
		return ResponseEntity.ok(receiverVO);
	}

	@GetMapping
	public List<Object[]> getAllReceivers() {
		return receiverService.getAllReceivers();
	}

	@PutMapping
	public String updateReceiver(@RequestParam Integer id, @RequestParam(required=false) String donationReceived,
			@RequestParam(required=false) String name, @RequestParam(required=false) String email, @RequestParam(required=false) String rg,
			@RequestParam(required=false) String dateOfBirth, @RequestParam(required=false) String phone, @RequestParam(required=false) String address,
			@RequestParam(required=false) String family, @RequestParam(required=false) Integer residentsQuantity, @RequestParam(required=false) String monthGotDonation,
			@RequestPart(required=false) MultipartFile receiverPhoto) throws IOException {
		return receiverService.updateReceiver(id, name, donationReceived, email, rg, dateOfBirth, phone, address,
				family, residentsQuantity, monthGotDonation);
	}

	@DeleteMapping
	public String deleteReceiver(@RequestParam Integer id) {
		return receiverService.deleteReceiver(id);
	}
}
