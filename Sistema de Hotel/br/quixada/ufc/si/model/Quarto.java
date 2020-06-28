package br.quixada.ufc.si.model;

import java.text.DecimalFormat;

public class Quarto {
	private int numero;
	private double valorDiaria;
	private String descricao;
	private boolean disponivel;
	private String tipo;

	public Quarto() {
		super();
	}

	public Quarto(int numero, double valorDiaria, String descricao, boolean disponivel) {
		super();
		this.numero = numero;
		this.valorDiaria = valorDiaria;
		this.descricao = descricao;
		this.disponivel = disponivel;
	}
	
	public static String format(double x) {  
	    DecimalFormat df = new DecimalFormat("#0.00");  
	    return df.format(x);
	}

	//Getters and Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
