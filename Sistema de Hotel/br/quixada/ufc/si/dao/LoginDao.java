package br.quixada.ufc.si.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.quixada.ufc.si.connect.FabricaConexao;
import br.quixada.ufc.si.model.*;

public class LoginDao {
	private Connection con;

	//criptogafando para MD5
	public String criptografia(String a) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest cripto = MessageDigest.getInstance("MD5");
		byte hashing[] = cripto.digest(a.getBytes("UTF-8"));
		StringBuilder hexString = new StringBuilder();
		for (byte b : hashing) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();
	}

	
	
	public boolean obterLogin(Login login) {
		if(login.getNivel() == 1) {
			try {
				String sql = "SELECT * FROM administrador a WHERE a.cpf = '" + login.getUser() + "' AND a.senha ='" + login.getPass() + "';";
				this.con = new FabricaConexao().getConexao();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					login.setUser(rs.getString("cpf"));
					login.setPass(rs.getString("senha"));
					
					System.out.println("Logado!");
					return true;
				}else {
					return false;
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(login.getNivel() == 2) {
			try {
				String sql = "SELECT h.cpf, h.senha FROM hospede h WHERE h.cpf = " + login.getUser() + " AND h.senha =" + login.getPass() + ";";
				this.con = new FabricaConexao().getConexao();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					login.setUser(rs.getString("cpf"));
					login.setPass(rs.getString("senha"));
					
					System.out.println("Logado!");
					return true;
				}else {
					return false;
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		if(login.getNivel() == 3) {
			try {
				String sql = "SELECT r.cpf, r.senha FROM recepcionista r WHERE r.cpf ILIKE '" + login.getUser() + "' AND r.senha ILIKE'" + login.getPass() + "';";
				this.con = new FabricaConexao().getConexao();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next()) {
					login.setUser(rs.getString("cpf"));
					login.setPass(rs.getString("senha"));
					
					System.out.println("Logado!");
					return true;
				}else {
					return false;
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Usuario invalido");
		return true;
	}
}