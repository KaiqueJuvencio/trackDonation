package com.br.trackDonation.service;

import java.io.IOException;
import java.util.List;

public interface ReceiverService {
	public String registerReceiver(String name, String donation, String family) throws IOException;
	public List<Object[]> getAllReceivers();
}
