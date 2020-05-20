package com.br.trackDonation.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trackDonation.dao.TrackDonationDAO;
import com.br.trackDonation.service.TrackDonationService;

@Service
public class TrackDonationServiceImpl implements TrackDonationService{
	
	@Autowired
	private TrackDonationDAO trackDonationDAO;
	
	@Override
	public List<Object[]> tracking(String donation) {
		return trackDonationDAO.tracking(donation);
	}
}
