package com.br.trackDonation.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.trackDonation.dao.TrackDonationDAO;
import com.br.trackDonation.domains.DonatorVO;
import com.br.trackDonation.domains.ReceiverVO;

@Repository
public class TrackDonationDAOImpl implements TrackDonationDAO{
	
	@Override
	public List<Object[]> tracking(String donation){
		ReceiverVO receiver = new ReceiverVO();
		DonatorVO donator = new DonatorVO();
		
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
        
        Query query = manager.createNativeQuery("select D.doacao, D.Email, D.Nome as D_NOME, D.Telefone, R.Nome as R_NOME, R.Familia from Donator as D,Receiver as R where D.doacao=:donationParam and R.DoacaoRecebida=:donationParam");
        query.setParameter("donationParam", donation);
        
        manager.getTransaction().begin();
        manager.persist(receiver);
        manager.getTransaction().commit();
        
        List<Object[]> result = query.getResultList();
        
        manager.close();
        factory.close();
        
        return result;
		
	}
}
