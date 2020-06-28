package br.quixada.ufc.si.model;

public class ConsumoHospede {
	private String cpfHospede;
	private Double pedido;
	private Double areaLazer;
	private Double aluguel;
	
	public ConsumoHospede() {
		super();
	}

	public ConsumoHospede(String cpfHospede, Double pedido, Double areaLazer, Double aluguel) {
		super();
		this.cpfHospede = cpfHospede;
		this.pedido = pedido;
		this.areaLazer = areaLazer;
		this.aluguel = aluguel;
	}

	public String getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(String cpfHospede) {
		this.cpfHospede = cpfHospede;
	}

	public Double getPedido() {
		return pedido;
	}

	public void setPedido(Double pedido) {
		this.pedido = pedido;
	}

	public Double getAreaLazer() {
		return areaLazer;
	}

	public void setAreaLazer(Double areaLazer) {
		this.areaLazer = areaLazer;
	}

	public Double getAluguel() {
		return aluguel;
	}

	public void setAluguel(Double aluguel) {
		this.aluguel = aluguel;
	}
}