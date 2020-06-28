package br.quixada.ufc.si.model;

import java.sql.Date;

public class Recepcionista extends Pessoa{
	private double salario;
	private String turno;
	private Date dataAdmissao;
	
	public Recepcionista() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recepcionista(String cpf, String nome, String senha, double salario, String turno, Date data) {
		super(cpf, nome, senha);
		// TODO Auto-generated constructor stub
		this.salario = salario;
		this.turno = turno;
		this.dataAdmissao = data;
	}
	
	//Getters and Setters
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
