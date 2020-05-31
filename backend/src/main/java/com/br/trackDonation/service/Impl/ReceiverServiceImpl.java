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
	public String registerReceiver(String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation) throws IOException {
		FileHelper file = new FileHelper();
		String photoName = file.verifiedDonationPhoto(donationReceived);
		
		receiverDAO.registerReceiver(name, donationReceived, email, rg, dateOfBirth, phone, address, family, residentsQuantity, monthGotDonation, photoName);
		return "Receptor cadastrado com sucesso";
	}
	
	@Override
	public List<Object[]> getAllReceivers() {
		return receiverDAO.getAllReceivers();
	}
	
	@Override
	public String updateReceiver(Integer id, String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation) throws IOException {
		FileHelper file = new FileHelper();
		String photoName = file.verifiedDonationPhoto(donationReceived);
		
		receiverDAO.updateReceiver(id, name, donationReceived, email, rg, dateOfBirth, phone, address, family, residentsQuantity, monthGotDonation, photoName);
		return "Receptor atualizado com sucesso";
	}
	
	@Override
	public String deleteReceiver(Integer id) {
		receiverDAO.deleteReceiver(id);
		return "Receptor excluído com sucesso";
	}

}