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
import com.br.trackDonation.domains.ReceiverVO;

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
        
        Query query = manager.createNativeQuery("select D.Id, D.doacao, D.Nome as D_NOME, D.Email, D.Telefone, D.dataCadastro from Donator as D ORDER BY D_NOME ASC");
   
        List<Object[]> result = query.getResultList();
        
        manager.close();
        factory.close();
        
        return result;
	}
	
	@Override
	public void updateDonator(Integer id, String name, String donation, String email, String phone) {
		
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
        
        Date date = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        DonatorVO donator = manager.find(DonatorVO.class, id);
         
        manager.getTransaction().begin();
        if(id.toString().isEmpty()==false) {donator.setId(id);}
        if(name.isEmpty()==false) {donator.setName(name);}
        if(donation.isEmpty()==false) {donator.setDonation(donation);}
        if(email.isEmpty()==false) {donator.setEmail(email);}
        if(phone.isEmpty()==false) {donator.setPhone(phone);}
        donator.setRegisterDate(formatador.format(date.getTime()));
        
        Query query = manager.createNativeQuery(
        		"UPDATE Donator SET Id=:id, "
	        		+ "Nome=:name, "
	        		+ "Email=:email, "
	        		+ "Telefone=:phone, "
	        		+ "Doacao=:donation "
        		+ "WHERE Id=:id");
        query.setParameter("id", donator.getId());
        query.setParameter("name", donator.getName());
        query.setParameter("email", donator.getEmail());
        query.setParameter("phone", donator.getPhone());
        query.setParameter("donation", donator.getDonation());
		query.executeUpdate();
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
	}
	
	@Override
	public void deleteDonator(Integer id) {
		
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA

        DonatorVO donator = manager.find(DonatorVO.class, id);
         
        manager.getTransaction().begin();
        manager.remove(donator);
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
	}
}
