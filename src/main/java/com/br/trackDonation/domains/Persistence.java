package com.br.trackDonation.domains;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Persistence {
	public static void main(String[] args) {
		DonatorVO donator = new DonatorVO();
		donator.setName("Kaique");
		
        EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
        
        manager.getTransaction().begin();
        manager.persist(donator);
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
    }

}
