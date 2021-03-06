package com.picpay.users.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@Column(unique = true)
	private String cpf;
	private String telefone;
	@Column(unique=true)
	private String email;
	private String senha;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "userId")
	private Consumer consumer;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "userId")
	private Seller seller;
	
	@JsonIgnore
	@OneToMany(mappedBy = "payer")
	private List<Transaction> payerTransactions = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "receiver")
	private List<Transaction> receiverTransactions = new ArrayList<>();
	
	public User() {
		
	}

	

	public User(Integer id, String nome, String cpf, String telefone, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome.toLowerCase();
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<Transaction> getPayerTransactions() {
		return payerTransactions;
	}

	public List<Transaction> getReceiverTransactions() {
		return receiverTransactions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
