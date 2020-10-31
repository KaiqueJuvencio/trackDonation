package com.br.trackDonation.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trackDonation.controller.exception.UserNotFoundException;
import com.br.trackDonation.dao.DonatorDAO;
import com.br.trackDonation.domains.DonatorVO;
import com.br.trackDonation.service.DonatorService;

@Service
public class DonatorServiceImpl implements DonatorService {
	
	@Autowired
	private DonatorDAO donatorDAO;
	
	@Override
	public DonatorVO registerDonator(String name, String donation, String email, String phone) {
		return donatorDAO.registerDonator(name, donation, email, phone); 
	}
	
	@Override
	public List<Object[]> getAllDonators() {
		return donatorDAO.getAllDonators();
	}
	
	@Override
	public List<Object[]> getDonator(Integer id) {
		return donatorDAO.getDonator(id);
	}
	
	@Override
	public DonatorVO updateDonator(Integer id, String name, String donation, String email, String phone) {
		int a =1;
		if(a==1) {
			throw new UserNotFoundException("Usuário não existente");
		}
		return donatorDAO.updateDonator(id, name, donation, email, phone);
	}
	
	@Override
	public void deleteDonator(Integer id) {
		donatorDAO.deleteDonator(id);
	}

}
