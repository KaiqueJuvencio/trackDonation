package com.br.trackDonation.service;

import java.io.IOException;
import java.util.List;

public interface ReceiverService {
	public String registerReceiver(String name, String donationReceived, String email, String rg, String dateOfBirth,
			String phone, String address, String family, Integer residentsQuantity, String monthGotDonation) throws IOException;

	public List<Object[]> getAllReceivers();

	public String updateReceiver(Integer id, String name, String donationReceived, String email, String rg,
			String dateOfBirth, String phone, String address, String family, Integer residentsQuantity,
			String monthGotDonation) throws IOException;

	public String deleteReceiver(Integer id);
}
