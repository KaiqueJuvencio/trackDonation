package com.br.trackDonation.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String updateDonator(Integer id, String name, String donation, String email, String phone) {
		donatorDAO.updateDonator(id, name, donation, email, phone);
		return "Doador atualizado com sucesso";
	}
	
	@Override
	public String deleteDonator(Integer id) {
		donatorDAO.deleteDonator(id);
		return "Doador excluído com sucesso";
	}

}
