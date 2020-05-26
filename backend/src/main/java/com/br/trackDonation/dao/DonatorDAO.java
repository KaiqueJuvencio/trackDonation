package com.br.trackDonation.dao;

import java.util.List;

public interface DonatorDAO {
	public void registerDonator(String name, String donation, String email, String phone);
	public List<Object[]> getAllDonators();

}
