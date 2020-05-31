package com.br.trackDonation.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Receiver")
public class ReceiverVO {
	
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "DoacaoRecebida")
	private String donationReceived;
	
	@Column(name = "Nome")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "RG")
	private String rg;
	
	@Column(name = "DataNascimento")
	private String dateOfBirth;
	
	@Column(name = "Telefone")
	private String phone;
	
	@Column(name = "Endereco")
	private String address;
	
	@Column(name = "Familia")
	private String family;
	
	@Column(name = "QtdMoradores")
	private Integer residentsQuantity;
	
	@Column(name = "DataCadastro")
	private String registerDate;
	
	@Column(name = "MesesCestasPegas")
	private String monthGotDonation;
	
	@Column(name = "Foto")
	private String photo;
	
	public String getDonationReceived() {
		return donationReceived;
	}

	public void setDonationReceived(String donationReceived) {
		this.donationReceived = donationReceived;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getResidentsQuantity() {
		return residentsQuantity;
	}

	public void setResidentsQuantity(Integer residentsQuantity) {
		this.residentsQuantity = residentsQuantity;
	}

	public String getMonthGotDonation() {
		return monthGotDonation;
	}

	public void setMonthGotDonation(String monthGotDonation) {
		this.monthGotDonation = monthGotDonation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}


	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
}
