package br.quixada.ufc.si.model;

import java.sql.Date;

public class Hospede extends Pessoa{
	private String telefone;
	private String email;
	private Date dataNasc;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	
	public Hospede() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Hospede [telefone=" + telefone + ", email=" + email + ", dataNasc=" + dataNasc + ", logradouro="
				+ logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + "]";
	}

	public Hospede(String cpf, String nome, String senha, String telefone, String email, Date dataNasc, String logradouro, int numero, String bairro, String cidade) {
		super(cpf, nome, senha);
		// TODO Auto-generated constructor stub
		this.telefone = telefone;
		this.email = email;
		this.dataNasc = dataNasc;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	//Getters and Setters
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}	
}
