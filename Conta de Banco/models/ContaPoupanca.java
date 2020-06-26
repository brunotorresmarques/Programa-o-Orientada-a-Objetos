package br.ufc.quixada.poo;

public class ContaPoupanca extends ContaBancaria implements Inter{

	private double limite;
	
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int numeroConta, double saldo, double limite) {
		super(numeroConta, saldo);
		this.limite = limite;
	}
	
	

	



	@Override
	public boolean sacar(double dinheiro) {
		dinheiro = getSaldo() + limite - dinheiro;
		if(dinheiro >= 0) {
			setSaldo(dinheiro);
			return true;
		 
		}
		
		else {
			return false;
		}
	}

	@Override
	public boolean depositar(double salario) {
		salario = salario + getSaldo();
		setSaldo(salario);
		
		return true;
	}

	@Override
	public void mostrarDados() {
		System.out.println(super.toString() + "\n" + "Limite: " + limite);
		
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Limite: " + limite;
	}
	
	
	
}
