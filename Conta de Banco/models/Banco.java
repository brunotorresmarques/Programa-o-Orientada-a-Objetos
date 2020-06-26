package br.ufc.quixada.poo;

import java.util.ArrayList;


public class Banco implements Inter{

public ArrayList<ContaBancaria> lista;
	
	public Banco() {
		lista = new ArrayList<>();
	}
	
	public void inserir(ContaBancaria c) {
		lista.add(c);
		System.out.println("Conta adicionada!");
	}
	
	
	public void remover(ContaBancaria c) {
		if(lista.remove(c)) {
			System.out.println("Conta removida!");
		}
		else {
			System.out.println("Deu erro!");
		}
	}
	
	public ContaBancaria procurarConta(int a) {
		for(ContaBancaria lista:lista) {
			if(lista.getNumeroConta()==(a)) {
				
				return lista;
			}
		}
		return null;
		
		
	}

	@Override
	public void mostrarDados() {
		for(ContaBancaria lista:lista) {
				System.out.println(lista.toString());
				System.out.println("\n");
		}
			
	}
	
	
	
	
	
	}
	
	
	
	
	
		
	

