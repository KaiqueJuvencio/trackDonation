package com.br.trackDonation.service;

import java.io.IOException;
import java.util.List;

public interface ReceiverService {
	public String registerReceiver(String name, String donation, String family) throws IOException;
	public List<Object[]> getAllReceivers();
	public String updateReceiver(Integer id, String name, String donation, String family) throws IOException;
	public String deleteReceiver(Integer id);
}
