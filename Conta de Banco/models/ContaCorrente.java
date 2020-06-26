package br.ufc.quixada.poo;

public class ContaCorrente extends ContaBancaria implements Inter{

	private double taxaDeOperação;

	public double getTaxaDeOperação() {
		return taxaDeOperação;
	}

	public void setTaxaDeOperação(double taxaDeOperação) {
		this.taxaDeOperação = taxaDeOperação;
	}
	
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int numeroConta, double saldo, double taxaDeOperação) {
		super(numeroConta, saldo);
		this.taxaDeOperação = taxaDeOperação;
	}
	
	

	

	@Override
	public boolean sacar(double dinheiro) {
		dinheiro = getSaldo() - (dinheiro + taxaDeOperação);
		setSaldo(dinheiro);
		return true;
	}

	@Override
	public boolean depositar(double salario) {
		salario = getSaldo() + (salario - taxaDeOperação);
		setSaldo(salario);
		return true;
	}

	@Override
	public void mostrarDados() {
		System.out.println(super.toString() +"\n"+ "Taxa de Operação: " + taxaDeOperação);
	}

	@Override
	public String toString() {
		return super.toString() +"\n"+ "Taxa de Operação: " + taxaDeOperação;
	}
	
	
	
	
	
}
