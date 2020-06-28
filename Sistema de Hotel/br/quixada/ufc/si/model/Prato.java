package br.quixada.ufc.si.model;

public class Prato {
	private String nomePrato;
	private String descricaoPrato;
	private double preco;
	
	public Prato() {
		super();
	}

	public Prato(String nomePrato, String descricao, double preco) {
		super();
		this.nomePrato = nomePrato;
		this.descricaoPrato = descricao;
		this.preco = preco;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	//Getters and Setters
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public String getDescricaoPrato() {
		return descricaoPrato;
	}

	public void setDescricaoPrato(String descricaoPrato) {
		this.descricaoPrato = descricaoPrato;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
