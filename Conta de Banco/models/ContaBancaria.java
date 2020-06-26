package br.ufc.quixada.poo;

public abstract class ContaBancaria {

	private int numeroConta;
	private double saldo;

	
	
	
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	public ContaBancaria(int numeroConta, double saldo) {
		super();
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	
	public boolean transferir(double a, ContaBancaria contBanc) {
		setSaldo(getSaldo()-a);
		contBanc.depositar(a);
		return true;
	}
	
	public ContaBancaria() {
		super();
	}
	public abstract boolean sacar(double dinheiro);
	public abstract boolean depositar(double salario);
	
	@Override
	public String toString() {
		return "Numero da Conta: " + numeroConta + "\n" + "Saldo: " + saldo;
	}
	
	 
		
	
	
	
	
}
