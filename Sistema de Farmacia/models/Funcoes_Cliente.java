package br.ufc.si.model;

import java.util.ArrayList;


public class Funcoes_Cliente implements Imprimivel{
public ArrayList<Cliente> lista;
	
	public Funcoes_Cliente() {
		lista = new ArrayList<>();
	}
	
	public void inserir(Cliente c) {
		lista.add(c);
		System.out.println("Cliente adicionado!");
	}
	
	
	public void remover(Cliente c) {
		if(lista.remove(c)) {
			System.out.println("Cliente removido!");
		}
		else {
			System.out.println("Deu erro!");
		}
	}
	
	public Cliente procurarCliente(String login,String senha) {
		for(Cliente lista:lista) {
			if(lista.getLogin().equals(login) && lista.getSenha().equals(senha)) {
				
				return lista;
			}
		}
		return null;
		
		
	}

	@Override
	public void mostrarDados() {
		for(Cliente lista:lista) {
				lista.mostrarDados();
				System.out.println("\n");
		}
			
	}

}
