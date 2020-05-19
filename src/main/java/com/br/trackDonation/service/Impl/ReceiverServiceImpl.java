package com.br.trackDonation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trackDonation.dao.ReceiverDAO;
import com.br.trackDonation.service.ReceiverService;

@Service
public class ReceiverServiceImpl implements ReceiverService {
	
	@Autowired
	private ReceiverDAO receiverDAO;
	
	@Override
	public String registerReceiver(String name, String donation, String family) {
		receiverDAO.registerReceiver(name, donation, family);
		return "Receptor cadastrado com sucesso";
	}
}
