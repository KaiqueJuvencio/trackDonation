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
		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
	    EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
		ReceiverVO receiver = new ReceiverVO();
		DonatorVO donator = new DonatorVO();
        
        Query query = manager.createNativeQuery(
        		 "SELECT D.doacao, "
	        		+ "D.Email, "
	        		+ "D.Nome as D_NOME, "
	        		+ "D.Telefone, "
	        		+ "R.Nome as R_NOME, "
	        		+ "R.Familia FROM Donator AS D, Receiver AS R "
        	   + "WHERE D.doacao=:donationParam AND R.DoacaoRecebida=:donationParam");
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
