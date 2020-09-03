package com.br.trackDonation.service;

import java.util.List;

import com.br.trackDonation.domains.DonatorVO;

public interface DonatorService {
	public DonatorVO registerDonator(String name, String donation, String email, String phone);
	public List<Object[]> getAllDonators();
	public DonatorVO updateDonator(Integer id, String name, String donation, String email, String phone);
	public String deleteDonator(Integer id);
}
