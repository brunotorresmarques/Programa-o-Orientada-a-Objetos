package br.quixada.ufc.si.model;

public class Pedido {
	private String cpfHospede;
	private String nomePrato;
	
	public Pedido() {
		super();
	}
	
	public Pedido(String cpfHospede, String nomePrato) {
		super();
		this.cpfHospede = cpfHospede;
		this.nomePrato = nomePrato;
	}

	//Getters and Setters
	public String getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(String cpfHospede) {
		this.cpfHospede = cpfHospede;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
}
