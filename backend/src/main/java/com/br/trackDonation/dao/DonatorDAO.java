package com.br.trackDonation.dao;

import java.util.List;

import com.br.trackDonation.domains.DonatorVO;

public interface DonatorDAO {
	public DonatorVO registerDonator(String name, String donation, String email, String phone);
	public List<Object[]> getAllDonators();
	public List<Object[]> getDonator();
	public DonatorVO updateDonator(Integer id, String name, String donation, String email, String phone);
	public void deleteDonator(Integer id);
}
