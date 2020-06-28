package br.quixada.ufc.si.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.quixada.ufc.si.model.Administrador;
import br.quixada.ufc.si.dao.AdministradorDao;
import br.quixada.ufc.si.model.*;


public class ControlerAdmin {
	AdministradorDao admin = new AdministradorDao();
	Prato prato = new Prato();
	Quarto quarto = new Quarto();
	Recepcionista recep = new Recepcionista();
	
	//adicionando um quarto
	public int adicionarQuarto(Double valorDiaria, String tipo, String descricao){
		quarto.setValorDiaria(valorDiaria);
		quarto.setTipo(tipo);
		quarto.setDescricao(descricao);
		quarto.setDisponivel(true);
		if(admin.addQuarto(quarto)) {
			System.out.println("descrição: "+quarto.getDescricao());
			System.out.println("tipo: "+quarto.getTipo());
			System.out.println("valor: "+quarto.getValorDiaria());
			if(admin.numberQuarto(quarto)) {
				System.out.println("numero: "+quarto.getNumero());
				return quarto.getNumero();
			}
		}
		return -1;
		
	}
	
	//atualizando valor do quarto
	public void atualizarValorQuarto() throws SQLException {
		Scanner read = new Scanner(System.in);
		
		quarto.setValorDiaria(read.nextDouble());
		quarto.setNumero(read.nextInt());
		admin.upQuarto(quarto);
		
		read.close();
	}
	
	//adicionando recepcionista
	public void cadastroRecepcionista(String CPF, String Nome, String Senha, String Salario, String Turno){
			recep.setCpf(CPF);
			recep.setNome(Nome);
			try {
				recep.setSenha(admin.criptografia(Senha));
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				recep.setSalario(Double.parseDouble(Salario));
			}catch(NumberFormatException e) {
				e.getMessage();
			}
			recep.setTurno(Turno);
			if(admin.addRecepcionista(recep)) {
				JOptionPane.showMessageDialog(null, "Recepcionista "+recep.getNome()+" cadastrado com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, "Error ao Cadastrar");
			}
			
	}
	
	//adicionando prato
	public void adicionarPrato() throws SQLException {
		Scanner read = new Scanner(System.in);
		
		prato.setNomePrato(read.nextLine());
		prato.setDescricaoPrato(read.nextLine());
		prato.setPreco(read.nextDouble());
		admin.addPrato(prato);
		
		read.close();
	}
	
	public void deletarRecepcionista() throws SQLException {
		Scanner read = new Scanner(System.in);
		
		admin.excluirRecepcionista(read.nextLine());
		
		read.close();
	}
}
