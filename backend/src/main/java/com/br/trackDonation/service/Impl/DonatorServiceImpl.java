package com.br.trackDonation.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trackDonation.dao.DonatorDAO;
import com.br.trackDonation.domains.DonatorVO;
import com.br.trackDonation.exception.BadRequestException;
import com.br.trackDonation.exception.UserNotFoundException;
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
		try {
			return donatorDAO.getAllDonators(); 
		}catch(Exception e){
			throw new BadRequestException("Falha ao retornar doadores");
		}
	}
	
	@Override
	public List<Object[]> getDonator(Integer id) {
		this.checkDonatorExistence(id);
		try {
			return donatorDAO.getDonator(id); 
		}catch(Exception e){
			throw new BadRequestException("Falha ao retornar doador");
		}
	}
	
	@Override
	public DonatorVO updateDonator(Integer id, String name, String donation, String email, String phone) {
		this.checkDonatorExistence(id);
		try {
			return donatorDAO.updateDonator(id, name, donation, email, phone);
		}catch(Exception e){
			throw new BadRequestException("Falha ao atualizar doador");
		}
	}
	
	@Override
	public void deleteDonator(Integer id) {
		this.checkDonatorExistence(id);
		try {
			donatorDAO.deleteDonator(id);
		}catch(Exception e){
			throw new BadRequestException("Falha ao excluir doador");
		}
	}
	
	@Override
	public void checkDonatorExistence(Integer id) {
		if(donatorDAO.getDonator(id).isEmpty()) {
			throw new UserNotFoundException("Não existe um usuário com esse id");
		}	
	}
}
