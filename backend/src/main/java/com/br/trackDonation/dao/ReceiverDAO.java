package com.br.trackDonation.dao;

import java.util.List;

public interface ReceiverDAO {
	
	public void registerReceiver(String name, String donation, String family, String photo);
	public List<Object[]> getAllReceivers();
	public void updateReceiver(Integer id, String name, String donation, String family, String photo);
	public void deleteReceiver(Integer id);
}
