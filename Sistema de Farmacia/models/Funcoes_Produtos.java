package br.ufc.si.model;

import java.util.ArrayList;


public class Funcoes_Produtos implements Imprimivel{
public ArrayList<Produtos> lista;
	
	public Funcoes_Produtos() {
		lista = new ArrayList<>();
	}
	
	public void inserir(Produtos p) {
		lista.add(p);
		System.out.println("Produto adicionado!");
	}
	
	public void remover(Produtos p) {
		if(lista.remove(p)) {
			System.out.println("Produto removido!");
		}
		else {
			System.out.println("Deu erro!");
		}
	}
	
	public Produtos procurarProduto(String nome) {
		for(Produtos lista:lista) {
			if(lista.getCodigo().equals(nome)) {
				
				return lista;
			}
		}
		return null;
		
	}
	
	

	@Override
	public void mostrarDados() {
		for(Produtos lista:lista) {
			System.out.println(lista.toString());
			System.out.println("\n");
	}
		
	}
	
}
