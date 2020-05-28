package com.br.trackDonation.dao.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.trackDonation.dao.ReceiverDAO;
import com.br.trackDonation.domains.DonatorVO;
import com.br.trackDonation.domains.ReceiverVO;

@Repository
public class ReceiverDAOImpl implements ReceiverDAO{
	
	@Override
	public void registerReceiver(String name, String donation, String family, String photo) {
		ReceiverVO receiver = new ReceiverVO();
		Date date = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		receiver.setName(name);
		receiver.setDoacao(donation);
		receiver.setFamily(family);
		receiver.setRegisterDate(formatador.format(date.getTime()));
		receiver.setPhoto(photo);
		
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
        
        manager.getTransaction().begin();
        manager.persist(receiver);
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
	}
	
	@Override
	public List<Object[]> getAllReceivers() {
			
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
        
        Query query = manager.createNativeQuery("select R.Id, R.DoacaoRecebida, R.Nome as D_NOME, R.Familia, R.Foto, R.DataCadastrada from Receiver as R");

        List<Object[]> result = query.getResultList();
        
        manager.close();
        factory.close();
        
        return result;
	}
}
