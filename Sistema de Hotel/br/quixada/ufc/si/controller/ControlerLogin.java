package br.quixada.ufc.si.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.quixada.ufc.si.dao.*;
import br.quixada.ufc.si.model.*;

public class ControlerLogin {
	Login login = new Login();
	LoginDao loginDao = new LoginDao();
	AdministradorDao admCH = new AdministradorDao();
	HospedeDao hosCH = new HospedeDao();
	RecepcionistaDao recepCH = new RecepcionistaDao();
	
	public Administrador logarADM(String cpf, String senha, int nivel){	
		login.setUser(cpf);
		try {
			login.setPass(loginDao.criptografia(senha));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.setNivel(nivel);
		
		if(loginDao.obterLogin(login)) {
			if(nivel == 1) {
				Administrador adm = new Administrador();
				adm = admCH.procurarAdm(login);
				return adm;
			}
		}
		return null;
	}
	
	public Hospede logarClien(String cpf, String senha, int nivel) {
		login.setUser(cpf);		
		try {
			login.setPass(loginDao.criptografia(senha));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.setNivel(nivel);
		//System.out.println("Entrou em nada o nivel é " + login.getNivel() + "\ncpf e " + login.getUser() + "\n senha " + login.getPass());
		if(loginDao.obterLogin(login)) {
		//	System.out.println("Entrou no login");
			if(nivel == 2) {
				//System.out.println("Entrou no  nivel");
				Hospede hospede = new Hospede();
				hospede = hosCH.procurarHospede(login);
				System.out.println("passou do procurar" + hospede.getCpf());
				return hospede;
			}
		}
		return null;
	}
	
	public Recepcionista logarRecep(String cpf, String senha, int nivel) {
		login.setUser(cpf);
		try {
			login.setPass(loginDao.criptografia(senha));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.setNivel(nivel);
		
		if(loginDao.obterLogin(login)) {
			if(nivel == 3) {
				Recepcionista recep = new Recepcionista();
				recep = recepCH.procurarRecepcionista(login);
				return recep;
			}
		}
		return null;
	}
}
