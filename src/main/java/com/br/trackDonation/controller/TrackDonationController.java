package com.br.trackDonation.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.helper.FileHelper;
import com.br.trackDonation.service.TrackDonationService;

@RestController
@RequestMapping("/")
public class TrackDonationController {
	
	@Autowired
	private TrackDonationService trackDonationService;
	
	@PostMapping("track-donation")
	public List<Object[]> tracking(@RequestParam String donation) throws IOException {
		FileHelper file = new FileHelper();
		file.visualizarArquivos();
		
		return trackDonationService.tracking(donation);
	}
}
