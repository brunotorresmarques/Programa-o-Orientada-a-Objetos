package br.ufc.si.model;

public abstract class Pessoa {
	private String nome;
	private String cpf;
	
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

	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	public Pessoa() {
		
	}

	public abstract void editarNome(String nome); 
	public abstract void editarCpf(String CPF);
	
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n" + "CPF: " + cpf + "\n";
		
	}

	
	
	
	
}
