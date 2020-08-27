package com.br.trackDonation.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.br.trackDonation.domains.ReceiverVO;

public interface ReceiverService {
	public ReceiverVO registerReceiver(String name, String donationReceived, String email, String rg, String dateOfBirth,
			String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, MultipartFile receiverPhoto) throws IOException;

	public List<Object[]> getAllReceivers();

	public String updateReceiver(Integer id, String name, String donationReceived, String email, String rg,
			String dateOfBirth, String phone, String address, String family, Integer residentsQuantity,
			String monthGotDonation) throws IOException;

	public String deleteReceiver(Integer id);
}
