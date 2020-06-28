package br.quixada.ufc.si.model;

public class Pagamento {
	private String cpfHospede;
	private String tipo;
	private double valorTotal;
	
	public Pagamento() {
		super();
	}
	
	public Pagamento(String cpfHospede, String tipo, double valorTotal) {
		super();
		this.cpfHospede = cpfHospede;
		this.tipo = tipo;
		this.valorTotal = valorTotal;
	}

	//Getters and Setters
	public String getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(String cpfHospede) {
		this.cpfHospede = cpfHospede;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}