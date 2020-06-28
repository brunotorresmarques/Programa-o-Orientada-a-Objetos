package br.quixada.ufc.si.model;

import java.sql.Date;

public class Reserva {
	private String cpfHospede;
	private int numeroQuarto;
	private Date dataInicio;
	private Date dataFim;

	
	public Reserva(String cpfHospede, int numeroQuarto, Date dataInicio, Date dataFim) {
		super();
		this.cpfHospede = cpfHospede;
		this.numeroQuarto = numeroQuarto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}



	public Reserva() {
		super();
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
