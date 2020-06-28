package br.quixada.ufc.si.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.quixada.ufc.si.dao.HospedeDao;
import br.quixada.ufc.si.model.*;

public class ControlerHospede {
	Hospede hosp = new Hospede();
	HospedeDao hospDao = new HospedeDao();
	Reserva reserva = new Reserva();
	ConsumoHospede ch = new ConsumoHospede();
	Pedido pedido = new Pedido();
	Pagamento pag = new Pagamento();
	
	//Cadastrando Hospede
	public void cadastrarHospede(String Cpf, String Nome, String Senha, String Email, String Telefone, String dataNasc, String Logradouro, int numero, String Bairro, String Cidade){
		Scanner read = new Scanner(System.in);
		
		hosp.setCpf(Cpf);
		hosp.setNome(Nome);
		try {
			hosp.setSenha(hospDao.criptografia(Senha));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hosp.setEmail(Email);
		hosp.setTelefone(Telefone);
		hosp.setDataNasc(Date.valueOf(dataNasc));
		hosp.setLogradouro(Logradouro);
		hosp.setNumero(numero);
		hosp.setBairro(Bairro);
		hosp.setCidade(Cidade);
		System.out.println(hosp.toString());
		if(hospDao.addHospede(hosp)) {
			JOptionPane.showMessageDialog(null, "Cliente "+hosp.getNome()+" cadastrado com sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente");
		}
	}
	
	//Listando todos os Quartos
	public ArrayList<Quarto> listarQuartos() {
		ArrayList<Quarto> listaQuarto = hospDao.mostrarQuarto();
		for(int i = 0; i < listaQuarto.size();i++) {
			if(listaQuarto.get(i).isDisponivel() == false)
				listaQuarto.remove(i);
		}
		return listaQuarto;
	}
	
	//Reservando quarto
	public void reservarQuarto() throws SQLException {
		Scanner read = new Scanner(System.in);
		
		reserva.setCpfHospede(read.nextLine());
		reserva.setNumeroQuarto(read.nextInt());
		read.nextLine();
		String di = read.nextLine();
		Date dataIni = null;
		dataIni = Date.valueOf(di);
		reserva.setDataInicio(dataIni);
		String df = read.nextLine();
		Date dataFim = null;
		dataFim = Date.valueOf(df);
		reserva.setDataFim(dataFim);
		hospDao.addReserva(reserva);
		
		read.close();
	}
	
	// Area de lazer
	public void areaLazer() {
		Scanner read = new Scanner(System.in);
		hosp.setCpf(read.nextLine());
		hospDao.areaLazer(hosp.getCpf());
		read.close();
	}
	
	//listando o consumo do hospede
	@SuppressWarnings("static-access")
	public void listarConsumo() throws SQLException {
		Scanner read = new Scanner(System.in);
		List<ConsumoHospede> consumoHosp = hospDao.mostrarConsumo(read.nextLine());
		double valorPedido = 0;
		double valorArea = 0;
		double valorAluguel = 0;
		for(ConsumoHospede ch : consumoHosp) {
			valorPedido += ch.getPedido();
			valorArea += ch.getAreaLazer();
			valorAluguel += ch.getAluguel();
		}
		double valorTotal = valorPedido + valorArea + valorAluguel;
		System.out.println("Pedido: " + hospDao.format(valorPedido) + "\nArea de Lazer: " + hospDao.format(valorArea) + "\nAluguel: " + hospDao.format(valorAluguel) + "\nConsumo total:" + hospDao.format(valorTotal) + "\n");
		read.close();
	}
	
	//deletar reserva
	public void deletarReserva() throws SQLException {
		Scanner read = new Scanner(System.in);
		reserva.setCpfHospede(read.nextLine());
		hospDao.excluirReserva(reserva.getCpfHospede());
		read.close();
	}
	
	public ArrayList <Prato> mostrarPratos() {
		ArrayList<Prato> pratos = null;
		try {
			pratos = hospDao.mostrarPratos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return pratos;
	}
	
	public ArrayList <Prato> menorPreco() {
		ArrayList<Prato> pratos = null;
		try {
			pratos = hospDao.menorPreco();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return pratos;
	}
	
	public ArrayList <Prato> maiorPreco() {
		ArrayList<Prato> pratos = null;
		try {
			pratos = hospDao.maiorPreco();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return pratos;
	}
	
	public void fazerPedido(String cpf, String nomePrato) {
		pedido.setCpfHospede(cpf);
		pedido.setNomePrato(nomePrato);
		hospDao.realizarPedido(pedido);
	}
}