package com.br.trackDonation.dao.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.trackDonation.dao.ReceiverDAO;
import com.br.trackDonation.domains.ReceiverVO;

@Repository
public class ReceiverDAOImpl implements ReceiverDAO{

	@Override
	public ReceiverVO registerReceiver(String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, String photo) {	
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
        
        return receiver;
	}

	@Override
	public List<Object[]> getAllReceivers() {
		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
		EntityManager manager = factory.createEntityManager();

		Query query = manager.createNativeQuery(
				 "SELECT R.Id, "
					+ "R.DoacaoRecebida, "
					+ "R.Nome as D_NOME, "
					+ "R.Email, R.RG, "
					+ "R.DataNascimento, "
					+ "R.Telefone, "
					+ "R.Endereco, "
					+ "R.Familia, "
					+ "R.QtdMoradores, "
					+ "R.MesesCestasPegas, "
					+ "R.DataCadastro, "
					+ "R.Foto "
			   + "FROM Receiver AS R ORDER BY D_NOME ASC");
		List<Object[]> result = query.getResultList();
		manager.close();
		factory.close();

		return result;
	}

	@Override
	public ReceiverVO updateReceiver(Integer id, String name, String donationReceived, String email, String rg, String dateOfBirth, String phone, String address, String family, Integer residentsQuantity, String monthGotDonation, String photo) {
		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
		EntityManager manager = factory.createEntityManager();

		ReceiverVO receiver = manager.find(ReceiverVO.class, id);
		
		manager.getTransaction().begin();
		if(id.toString().isEmpty()==false) {receiver.setId(id);}
		if(name.isEmpty()==false) {receiver.setName(name);}
		if(donationReceived.isEmpty()==false) {receiver.setDonationReceived(donationReceived);}
		if(email.isEmpty()==false) {receiver.setEmail(email);}
		if(rg.isEmpty()==false) {receiver.setRg(rg);}
		if(dateOfBirth.isEmpty()==false) {receiver.setDateOfBirth(dateOfBirth);}
		if(phone.isEmpty()==false) {receiver.setPhone(phone);}
		if(address.isEmpty()==false) {receiver.setAddress(address);}
		if(family.isEmpty()==false) {receiver.setFamily(family);}
		if(monthGotDonation.isEmpty()==false) {receiver.setMonthGotDonation(monthGotDonation);}
		if(photo.isEmpty()==false) {receiver.setPhoto(photo);}
		if(residentsQuantity != null) {receiver.setResidentsQuantity(residentsQuantity);}

		Query query = manager.createNativeQuery(
				 "UPDATE Receiver SET Id=:id, "
					+ "Nome=:name, "
					+ "DoacaoRecebida=:donationReceived, "
					+ "Email=:email, "
					+ "RG=:rg, DataNascimento=:dateOfBirth, "
					+ "Telefone=:phone, "
					+ "Endereco=:address, "
					+ "Familia=:family, "
					+ "QtdMoradores=:residentsQuantity, "
					+ "MesesCestasPegas=:monthGotDonation, "
					+ "Foto=:photo "
			   + "WHERE Id=:id");
		query.setParameter("id", receiver.getId());
		query.setParameter("name", receiver.getName());
		query.setParameter("donationReceived", receiver.getDonationReceived());
		query.setParameter("email", receiver.getEmail());
		query.setParameter("rg", receiver.getRg());
		query.setParameter("dateOfBirth", receiver.getDateOfBirth());
		query.setParameter("phone", receiver.getPhone());
		query.setParameter("address", receiver.getAddress());
		query.setParameter("family", receiver.getFamily());
		query.setParameter("residentsQuantity", receiver.getResidentsQuantity());
		query.setParameter("monthGotDonation", receiver.getMonthGotDonation());
		query.setParameter("photo", receiver.getPhoto());
		query.executeUpdate();
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return receiver;
	}

	@Override
	public void deleteReceiver(Integer id) {
		EntityManagerFactory factory = javax.persistence.Persistence.createEntityManagerFactory("trackDonation");
		EntityManager manager = factory.createEntityManager();

		ReceiverVO receiver = manager.find(ReceiverVO.class, id);

		manager.getTransaction().begin();
		manager.remove(receiver);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
	}
}
