package com.br.trackDonation.service.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trackDonation.dao.ReceiverDAO;
import com.br.trackDonation.helper.FileHelper;
import com.br.trackDonation.service.ReceiverService;

@Service
public class ReceiverServiceImpl implements ReceiverService {
	
	@Autowired
	private ReceiverDAO receiverDAO;
	
	@Override
	public String registerReceiver(String name, String donation, String family) throws IOException {
		FileHelper file = new FileHelper();
		String photoName = file.verifiedDonationPhoto(donation);
		receiverDAO.registerReceiver(name, donation, family, photoName);
		return "Receptor cadastrado com sucesso";
	}
	
	@Override
	public List<Object[]> getAllReceivers() {
		return receiverDAO.getAllReceivers();
	}

}
