package br.quixada.ufc.si.dao;

import java.sql.SQLException;

import br.quixada.ufc.si.connect.FabricaConexao;
import br.quixada.ufc.si.model.*;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministradorDao{
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
	
	public Administrador procurarAdm(Login login) {
		String sql = "SELECT * FROM Administrador where cpf = ?;";
		Administrador adm = null;
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getUser());
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String nome = rs.getString("cpf");
				String cpf = rs.getString("nome");
				String senha = rs.getString("senha");
				adm = new Administrador(cpf, nome, senha);

			}
			stmt.close();

			return adm;

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				this.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public boolean numberQuarto(Quarto quarto) {
		String sql = "SELECT numero_quarto FROM quarto where tipo = '"+ quarto.getTipo() +"' and descricao = '"+quarto.getDescricao()+"' and valor = '"+quarto.getValorDiaria()+"'";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				int num = rs.getInt("numero_quarto");
				System.out.println("num quarto e"+num);
				quarto.setNumero(num);
				return true;
			}
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				this.con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Adicionando um Quarto no Hotel
	public boolean addQuarto(Quarto quarto){
		String sql = "INSERT INTO quarto(numero_quarto, tipo, descricao, disponivel, valor) VALUES (default, ?, ?, ?, ?);";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstmn = con.prepareStatement(sql);
			pstmn.setString(1, quarto.getTipo());
			pstmn.setString(2, quarto.getDescricao());
			pstmn.setBoolean(3, quarto.isDisponivel());
			pstmn.setDouble(4, quarto.getValorDiaria());
			
			int linhasAfetadas = pstmn.executeUpdate();
			pstmn.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Quarto adicionado!");
				return true;
			}
			
			System.out.println("Erro ao adicionar");
			return false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Atualizando valor do Quarto
	public boolean upQuarto(Quarto quarto) throws SQLException{
		String sql = "UPDATE quarto SET valor = ? WHERE numero_quarto = ?";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstmn = con.prepareStatement(sql);
			pstmn.setDouble(1, quarto.getValorDiaria());
			pstmn.setInt(2, quarto.getNumero());
			
			int linhasAfetadas = pstmn.executeUpdate();
			pstmn.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Valor atualizado!");
				return true;
			}
			
			System.out.println("Erro ao atualizar");
			return false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Adicionando Recepcionista
	public boolean addRecepcionista(Recepcionista recep){
		String sql = "INSERT INTO recepcionista(cpf, nome, senha, turno, salario, data_contrato) VALUES(?, ?, ?, ?, ?, default);";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstmn = con.prepareStatement(sql);
			pstmn.setString(1, recep.getCpf());
			pstmn.setString(2, recep.getNome());
			pstmn.setString(3, recep.getSenha());
			pstmn.setString(4, recep.getTurno());
			pstmn.setDouble(5, recep.getSalario());
			
			int linhasAfetadas = pstmn.executeUpdate();
			pstmn.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Recepcionista cadastrada!");
				return true;
			}
			
			System.out.println("Erro ao adicionar");
			return false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//Adicionando Pratos ao Restaurante
	public boolean addPrato(Prato prato) throws SQLException{
		String sql = "INSERT INTO restaurante(nome_prato, descricao, valor) VALUES(?, ?, ?)";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstmn = con.prepareStatement(sql);
			pstmn.setString(1, prato.getNomePrato());
			pstmn.setString(2, prato.getDescricaoPrato());
			pstmn.setDouble(3, prato.getPreco());
			
			int linhasAfetadas = pstmn.executeUpdate();
			pstmn.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Prato adicionado!");
				return true;
			}
			
			System.out.println("Erro ao adicionar");
			return false;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Erro ao adicionar	");
		return false;
	}
	
	//excluir recepcionista
	public boolean excluirRecepcionista(String cpf) throws SQLException {
		String sql = "DELETE FROM recepcionista WHERE cpf = ?;" ;
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);					
		    stmt.setString(1, cpf);
		    
		    int linhasAfetadas = stmt.executeUpdate();
			stmt.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Deletado!");
				return true;
			}
			
			System.out.println("Erro ao deletar");
			return false;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
