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
	
	@Column(name = "Nome")
	private String name;
	
	@Column(name = "Familia")
	private String family;
	
	@Column(name = "DoacaoRecebida")
	private String donationReceived;
	
	@Column(name = "DataCadastrada")
	private String registerDate;

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

	public String getDoacao() {
		return donationReceived;
	}

	public void setDoacao(String donationReceived) {
		this.donationReceived = donationReceived;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
}
