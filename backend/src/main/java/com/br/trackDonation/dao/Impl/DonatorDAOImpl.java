package com.br.trackDonation.dao.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.trackDonation.dao.DonatorDAO;
import com.br.trackDonation.domains.DonatorVO;

@Repository
public class DonatorDAOImpl implements DonatorDAO {
	
	@Override
	public void registerDonator(String name, String donation, String email, String phone) {
		
		DonatorVO donator = new DonatorVO();
		Date date = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		donator.setName(name);
		donator.setDonation(donation);
		donator.setEmail(email);
		donator.setPhone(phone);
		donator.setRegisterDate(formatador.format(date.getTime()));
		
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
        
        manager.getTransaction().begin();
        manager.persist(donator);
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
	}
	
	@Override
	public List<Object[]> getAllDonators() {
			
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
        
        Query query = manager.createNativeQuery("select D.Id, D.doacao, D.Nome as D_NOME, D.Email, D.Telefone, D.dataCadastro from Donator as D");
   
        List<Object[]> result = query.getResultList();
        
        manager.close();
        factory.close();
        
        return result;
	}
}
