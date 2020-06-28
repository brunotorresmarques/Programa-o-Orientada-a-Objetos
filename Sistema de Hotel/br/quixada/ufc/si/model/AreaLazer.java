package br.quixada.ufc.si.model;

public class AreaLazer {
	private double taxa;
	
	public AreaLazer() {
		super();
	}

	public AreaLazer(double taxa) {
		super();
		this.taxa = taxa;
	}

	//Get and Set
	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
}
