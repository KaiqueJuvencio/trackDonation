package com.br.trackDonation.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.trackDonation.service.ReceiverService;

@RestController
@RequestMapping
public class ReceiverController {

	@Autowired
	private ReceiverService receiverService;
	
	@CrossOrigin
//	@ApiImplicitParam(name = "file-data", value = "inscrito, para-inscricao, historico", paramType = "formData", dataType = "file", required = false)
	@PostMapping("receiver/register")
	public String register(@RequestParam String name, @RequestParam String donation, @RequestParam String family,
			@RequestPart("file-data") MultipartFile receiverPhoto) throws IOException {
		receiverPhoto.transferTo(
				new File("C:\\Users\\kaiqu\\Desktop\\trackDonation\\" + receiverPhoto.getOriginalFilename()));

		return receiverService.registerReceiver(name, donation, family);
	}
	
	@GetMapping("/receiver")
	public List<Object[]> getAllReceivers() {
		return receiverService.getAllReceivers();
	}
}
