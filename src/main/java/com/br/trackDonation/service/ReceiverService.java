package com.br.trackDonation.service;

import java.io.IOException;

public interface ReceiverService {
	public String registerReceiver(String name, String donation, String family) throws IOException;
}
