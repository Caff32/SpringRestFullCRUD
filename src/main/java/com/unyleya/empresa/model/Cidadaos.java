package com.unyleya.empresa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cidadaos")
public class Cidadaos {
	
	
	private long ID;
	private String CPF;
	private String nome;
	private String endereco;
	private String sexo;
	
	public Cidadaos() {
		
	}
	
	public Cidadaos(String CPF, String nome, String endereco, String sexo ) {
		this.CPF = CPF;
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	
	@Column(name = "CPF", nullable = false)
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	@Column(name = "Nome", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "Endereco", nullable = false)
	public String getEndereco() {
		return endereco;
	}	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name = "Sexo", nullable = false)
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {
		return "Cidadaos [ID=" + ID + ", Nome=" + nome + ", Endereco=" + endereco + ", Sexo=" + sexo
				+ "]";
	}

	

	
}
