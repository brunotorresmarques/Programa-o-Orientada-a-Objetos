package br.quixada.ufc.si.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.quixada.ufc.si.dao.HospedeDao;
import br.quixada.ufc.si.dao.RecepcionistaDao;
import br.quixada.ufc.si.model.*;

public class ControlerRecepcionista {
	Recepcionista recep = new Recepcionista();
	RecepcionistaDao recepDao = new RecepcionistaDao();
	Hospede hosp = new Hospede();
	HospedeDao hospDao = new HospedeDao();
	Pagamento pag = new Pagamento();
	QuartoAlugado quartoA = new QuartoAlugado();
	
	//Listando todos os Hospedes
	public void listarHospedes() {
		List<Hospede> listaHosp = recepDao.mostarHospede();
		for(Hospede h : listaHosp) {
			System.out.println("CPF: " + h.getCpf() + "\nNome: " + h.getNome() + "\nData Nascimento: " + h.getDataNasc() + "\nTelefone: " + h.getTelefone() + "\nE-mail: " + h.getEmail() + "\nLogradouro: " + h.getLogradouro() + "\nNúmero: " + h.getNumero() + "\nBairro: " + h.getBairro() + "\nCidade: " + h.getCidade() + "\n");
		}
	}
			
	//Listando o consumo do Hospede
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
		System.out.println("Pedido: " + recepDao.format(valorPedido) + "\nArea de Lazer: " + recepDao.format(valorArea) + "\nAluguel: " + recepDao.format(valorAluguel) + "\nConsumo total:" + recepDao.format(valorTotal) + "\n");
		read.close();
	}

	//cadastrar hospede
	public void cadastrarHospede() throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
		Scanner read = new Scanner(System.in);
		
		hosp.setCpf(read.nextLine());
		hosp.setNome(read.nextLine());
		hosp.setSenha(hospDao.criptografia(read.nextLine()));
		hosp.setEmail(read.nextLine());
		hosp.setTelefone(read.nextLine());
		String data = read.nextLine();
		Date teste = null;
		teste = Date.valueOf(data);
		hosp.setDataNasc(teste);
		hosp.setLogradouro(read.nextLine());
		hosp.setNumero(read.nextInt());
		read.nextLine();
		hosp.setBairro(read.nextLine());
		hosp.setCidade(read.nextLine());
		hospDao.addHospede(hosp);
		
		read.close();
	}
	
	//Listando todos os Quartos
	@SuppressWarnings("static-access")
	public void listarQuartos() {
		List<Quarto> listaQuarto = hospDao.mostrarQuarto();
		String status;
		for(Quarto quarto : listaQuarto) {
			if(quarto.isDisponivel())
				status = "Disponível";
			else
				status = "Indisponível";
			System.out.println("Numero: " + quarto.getNumero() + "\nDescricao: " + quarto.getDescricao() + "\nValor diária: " + hospDao.format(quarto.getValorDiaria()) + "\nDisponivel: " + status + "\n");
		}
	}
	
	//alugar quarto
	public void checkin() throws SQLException {
		Scanner read = new Scanner(System.in);
		quartoA.setCpfHospede(read.nextLine());
		if(!recepDao.verifica(quartoA.getCpfHospede())) {
			System.out.println("Alugue um quarto\n");
			quartoA.setNumeroQuarto(read.nextInt());
			read.nextLine();
			String di = read.nextLine();
			Date dataIni = null;
			dataIni = Date.valueOf(di);
			quartoA.setDataIni(dataIni);
			String df = read.nextLine();
			Date dataFim = null;
			dataFim = Date.valueOf(df);
			quartoA.setDataFim(dataFim);

			recepDao.addQuartoAlugado(quartoA);
		}else {			
			recepDao.alugarQuartoReserva(quartoA.getCpfHospede());
		}
		read.close();
	}
	
	//realizar consumo
	@SuppressWarnings("static-access")
	public void realizarPagamento() throws SQLException {
		Scanner read = new Scanner(System.in);
		pag.setCpfHospede(read.nextLine());
		pag.setTipo(read.nextLine());
		List<ConsumoHospede>  listaPag = hospDao.mostrarConsumo(pag.getCpfHospede());
		double valorTotal = 0;
		for(ConsumoHospede ch : listaPag) {
			valorTotal += ch.getAluguel();
			valorTotal += ch.getAreaLazer();
			valorTotal += ch.getPedido();
		}
		System.out.println("Valor total: " + recepDao.format(valorTotal));
		recepDao.pagar(pag);
		read.close();
	}
	//checkout
	public void checkout() throws SQLException {
		realizarPagamento();
		recepDao.excluirQuartoAlugado(pag.getCpfHospede());
	}
	
	//deletar hospede
	public void deletarHospede() {
		Scanner read = new Scanner(System.in);
		recepDao.excluirHospede(read.nextLine());
		read.close();
	}
}
