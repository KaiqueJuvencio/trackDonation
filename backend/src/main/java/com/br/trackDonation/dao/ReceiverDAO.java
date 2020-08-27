package com.br.trackDonation.dao;

import java.util.List;

import com.br.trackDonation.domains.ReceiverVO;

public interface ReceiverDAO {
	
	public ReceiverVO registerReceiver(String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, String photo);
	public List<Object[]> getAllReceivers();
	public void updateReceiver(Integer id, String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, String photo);
	public void deleteReceiver(Integer id);
}
