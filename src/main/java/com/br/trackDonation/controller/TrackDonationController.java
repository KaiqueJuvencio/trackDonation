package com.br.trackDonation.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.trackDonation.helper.FileHelper;
import com.br.trackDonation.helper.JavaMailHelper;
import com.br.trackDonation.service.TrackDonationService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/")
public class TrackDonationController {

	@Autowired
	private TrackDonationService trackDonationService;

	@PostMapping("/track-donation")
	public String tracking(@RequestParam String donation)
			throws IOException, JSONException {

		List<Object[]> trackDonationQuery = trackDonationService.tracking(donation);

		Gson gson = new Gson();
		String trackDonationQueryStr = gson.toJson(trackDonationQuery);

		JavaMailHelper javaMail = new JavaMailHelper();

		FileHelper file = new FileHelper();

		for (Object[] each : trackDonationQuery) {
			String receiverDonationNumber = gson.toJson(each[0]).replace("\"", "");
			String donatorMail = gson.toJson(each[1]).replace("\"", "");
			String donatorName = gson.toJson(each[2]).replace("\"", "");
			String donatorPhone = gson.toJson(each[3]).replace("\"", "");
			String receiverName = gson.toJson(each[4]).replace("\"", "");
			String receiverFamily = gson.toJson(each[5]).replace("\"", "");

			String receiverPhoto = file.verifiedDonationPhoto(receiverDonationNumber);

			javaMail.sendMail(donatorMail, donatorName, receiverName, receiverFamily, receiverPhoto);
		}

		System.out.println("RESULTADO: " + trackDonationQueryStr);
	
		return "Sucesso";
	}
}
