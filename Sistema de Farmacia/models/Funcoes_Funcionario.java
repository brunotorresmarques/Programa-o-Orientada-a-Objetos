package br.ufc.si.model;

import java.util.ArrayList;

public class Funcoes_Funcionario implements Imprimivel{
public ArrayList<Funcionario> lista;
	
	public Funcoes_Funcionario() {
		lista = new ArrayList<>();
	}
	
	public void inserir(Funcionario f) {
		lista.add(f);
		System.out.println("Funcionario adicionado!");
	}
	
	public void remover(Funcionario f) {
		if(lista.remove(f)) {
			System.out.println("Funcionario removido!");
		}
		else {
			System.out.println("Deu erro!");
		}
	}
	
	public Funcionario procurarFuncionario(String login, String senha) {
		for(Funcionario lista:lista) {
			if(lista.getLogin().equals(login) && lista.getSenha().equals(senha)) {
				
				return lista;
			}
		}
		return null;
		
	}
	
	

	@Override
	public void mostrarDados() {
		for(Funcionario lista:lista) {
			lista.mostrarDados();
			System.out.println("\n");
	}
		
	}
	


}
