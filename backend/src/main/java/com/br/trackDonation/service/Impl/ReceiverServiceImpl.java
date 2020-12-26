package com.br.trackDonation.service.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.br.trackDonation.dao.ReceiverDAO;
import com.br.trackDonation.domains.ReceiverVO;
import com.br.trackDonation.exception.BadRequestException;
import com.br.trackDonation.helper.FileHelper;
import com.br.trackDonation.service.ReceiverService;

@Service
public class ReceiverServiceImpl implements ReceiverService {
	
	@Autowired
	private ReceiverDAO receiverDAO;
	
	@Override
	public ReceiverVO registerReceiver(String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, MultipartFile receiverPhoto) throws IOException {
		String photoName = "Não selecionada";
		if(receiverPhoto!=null) {
			FileHelper file = new FileHelper();
			photoName = file.verifiedDonationPhoto(donationReceived);
		}
		try {
			return receiverDAO.registerReceiver(name, donationReceived, email, rg, dateOfBirth, phone, address, family, residentsQuantity, monthGotDonation, photoName);
		}catch(Exception e){
			throw new BadRequestException("Falha ao registrar receptor");
		}
	}
	
	@Override
	public List<Object[]> getAllReceivers() {
		try {
			return receiverDAO.getAllReceivers();
		}catch(Exception e){
			throw new BadRequestException("Falha ao retornar receptores");
		}
	}
	
	@Override
	public ReceiverVO updateReceiver(Integer id, String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, MultipartFile receiverPhoto) throws IOException {
		String photoName = "Não selecionada";
		if(receiverPhoto!=null) {
			FileHelper file = new FileHelper();
			photoName = file.verifiedDonationPhoto(donationReceived);
		}
		try {
			return receiverDAO.updateReceiver(id, name, donationReceived, email, rg, dateOfBirth, phone, address, family, residentsQuantity, monthGotDonation, photoName);
		}catch(Exception e){
			throw new BadRequestException("Falha ao atualizar receptor");
		}
	}
	
	@Override
	public void deleteReceiver(Integer id) {
		try {
			receiverDAO.deleteReceiver(id);
		}catch(Exception e){
			throw new BadRequestException("Falha ao excluir receptor");
		}
	}
}
