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
	
	@PostMapping("track-donation")
	public List<Object[]> tracking(@RequestParam String donation) throws IOException, JSONException {
		FileHelper file = new FileHelper();
		file.visualizarArquivos();
		
		List<Object[]> result = trackDonationService.tracking(donation);
		
		Gson g = new Gson();
		String str = g.toJson(result);
		
		StringBuilder strBuilder = new StringBuilder();
		
		for(Object[] obj: result) {
			String emailDonators = g.toJson(obj[1]);
			String phoneDonators = g.toJson(obj[3]);
			
			strBuilder.append(emailDonators.replace("\"", ""));
			strBuilder.append(",");
				
			System.out.println("Email Donators: " + emailDonators + " Phone Donators: " + phoneDonators);
		}
		
		JavaMailHelper javaMail = new JavaMailHelper();
		javaMail.sendMail(strBuilder.toString());
		
		System.out.println(strBuilder.toString());
		
//		JSONObject jsonObject = new JSONObject(str);
		
		System.out.println("RESULTADO: " + str);
		return result;
	}
}
