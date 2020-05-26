package com.br.trackDonation.dao;

import java.util.List;

public interface ReceiverDAO {
	
	public void registerReceiver(String name, String donation, String family, String photo);
	public List<Object[]> getAllReceivers();
}
