package com.br.trackDonation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trackDonation.dao.DonatorDAO;
import com.br.trackDonation.service.DonatorService;

@Service
public class DonatorServiceImpl implements DonatorService {
	
	@Autowired
	private DonatorDAO donatorDAO;
	
	@Override
	public String registerDonator(String name, String donation, String email, String phone) {
		donatorDAO.registerDonator(name, donation, email, phone);
		return "Doador cadastrado com sucesso";
	}

}
