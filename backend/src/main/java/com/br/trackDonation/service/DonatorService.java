package com.br.trackDonation.service;

import java.util.List;

public interface DonatorService {
	public String registerDonator(String name, String donation, String email, String phone);
	public List<Object[]> getAllDonators();
	public String updateDonator(Integer id, String name, String donation, String email, String phone);
	public String deleteDonator(Integer id);
}
