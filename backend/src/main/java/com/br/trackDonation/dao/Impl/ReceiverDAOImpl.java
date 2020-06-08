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
public class ReceiverDAOImpl implements ReceiverDAO {

	@Override
	public void registerReceiver(String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, String photo) {
		
		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
        EntityManager manager = factory.createEntityManager();//Para se comunicar com o JPA
		
		ReceiverVO receiver = new ReceiverVO();
		Date date = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		receiver.setDonationReceived(donationReceived);
		receiver.setName(name);
		receiver.setEmail(email);
		receiver.setRg(rg);
		receiver.setDateOfBirth(dateOfBirth);
		receiver.setPhone(phone);
		receiver.setAddress(address);
		receiver.setFamily(family);
		receiver.setResidentsQuantity(residentsQuantity);
		receiver.setMonthGotDonation(monthGotDonation);
		receiver.setRegisterDate(formatador.format(date.getTime()));
		receiver.setPhoto(photo);
		      
        manager.getTransaction().begin();
        manager.persist(receiver);
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
	}

	@Override
	public List<Object[]> getAllReceivers() {

		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
		EntityManager manager = factory.createEntityManager();// Para se comunicar com o JPA

		Query query = manager.createNativeQuery(
				"select R.Id, R.DoacaoRecebida, R.Nome as D_NOME, R.Email, R.RG, R.DataNascimento, R.Telefone, R.Endereco, R.Familia, R.QtdMoradores, R.MesesCestasPegas, R.DataCadastro, R.Foto from Receiver as R ORDER BY D_NOME ASC");

		List<Object[]> result = query.getResultList();

		manager.close();
		factory.close();

		return result;
	}

	@Override
	public void updateReceiver(Integer id, String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, String photo) {

		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
		EntityManager manager = factory.createEntityManager();// Para se comunicar com o JPA

		ReceiverVO receiver = manager.find(ReceiverVO.class, id);

		manager.getTransaction().begin();
		receiver.setDonationReceived(donationReceived);
		receiver.setName(name);
		receiver.setEmail(email);
		receiver.setRg(rg);
		receiver.setDateOfBirth(dateOfBirth);
		receiver.setPhone(phone);
		receiver.setAddress(address);
		receiver.setFamily(family);
		receiver.setResidentsQuantity(residentsQuantity);
		receiver.setMonthGotDonation(monthGotDonation);
		receiver.setPhoto(photo);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}

	@Override
	public void deleteReceiver(Integer id) {

		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
		EntityManager manager = factory.createEntityManager();// Para se comunicar com o JPA

		ReceiverVO receiver = manager.find(ReceiverVO.class, id);

		manager.getTransaction().begin();
		manager.remove(receiver);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}
