package br.quixada.ufc.si.model;

import java.sql.Date;

public class QuartoAlugado {
	private String cpfHospede;
	private int numeroQuarto;
	private Date dataIni;
	private Date dataFim;
	
	public QuartoAlugado() {
		super();
	}

	public QuartoAlugado(String cpfHospede, int numeroQuarto, Date dataIni, Date dataFim) {
		super();
		this.cpfHospede = cpfHospede;
		this.numeroQuarto = numeroQuarto;
		this.dataIni = dataIni;
		this.dataFim = dataFim;
	}

	//Getters and Setters
	public String getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(String cpfHospede) {
		this.cpfHospede = cpfHospede;
	}

	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataIni() {
		return dataIni;
	}

	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
