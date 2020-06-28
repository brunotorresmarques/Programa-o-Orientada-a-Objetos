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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.quixada.ufc.si.connect.FabricaConexao;
import br.quixada.ufc.si.model.*;


public class HospedeDao{
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
	
	public boolean atualiza(String cpf) {
		String sql = "UPDATE consumo_hospede SET consumo_pedido = ?, consumo_area_lazer = ? WHERE cpf_hospede ILIKE ?;";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, 0);
			stmt.setDouble(2, 0);
			stmt.setString(3, cpf);
			
			int linhasAfetadas = stmt.executeUpdate();
			stmt.close();
			
			if(linhasAfetadas > 0) {
				return true;
			}
			
			System.out.println("Erro ao pagar");
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
	
	public Hospede procurarHospede(Login login) {
		String sql = "SELECT * FROM Hospede where cpf = ?;";
		Hospede Hospede = null;
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getUser());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("cpf");
				String cpf = rs.getString("nome");
				String telefone = rs.getString("telefone");
				String email = rs.getString("email");
				Date dataNasc = rs.getDate("data_nascimento");
				String logradouro = rs.getString("logradouro");
				int numero = rs.getInt("numero");
				String bairro = rs.getString("bairro");
				String cidade = rs.getString("cidade");
				String senha = rs.getString("senha");
				Hospede = new Hospede(cpf, nome, senha, telefone, email, dataNasc, logradouro, numero, bairro, cidade);

			}
			stmt.close();

			return Hospede;

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
	
	public boolean pagar(Pagamento pag) throws SQLException {
		String sql = "INSERT INTO pagamento (cpf_hospede, tipo) VALUES(?, ?);";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstmn = con.prepareStatement(sql);
			pstmn.setString(1, pag.getCpfHospede());
			pstmn.setString(2, pag.getTipo());
			
			int linhasAfetadas = pstmn.executeUpdate();
			pstmn.close();
			
			if(linhasAfetadas > 0 && atualiza(pag.getCpfHospede())) {
				System.out.println("Pagamento realizado!");
				return true;
			}
			
			System.out.println("CPF não encontrado!");
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
	
	//função que adiciona um Hospede no banco
	public boolean addHospede(Hospede hosp){
		String sql = "INSERT INTO hospede (cpf, nome, telefone, email, data_nascimento,	 logradouro, numero, bairro, cidade, senha) VALUES ('?', '?', '?', '?', ?, '?', ?, '?', '?', '?');";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, hosp.getCpf());
			pstm.setString(2, hosp.getNome());
			pstm.setString(3, hosp.getTelefone());
			pstm.setString(4, hosp.getEmail());
			pstm.setDate(5, hosp.getDataNasc());
			pstm.setString(6, hosp.getLogradouro());
			pstm.setInt(7, hosp.getNumero());
			pstm.setString(8, hosp.getBairro());
			pstm.setString(9, hosp.getCidade());
			pstm.setString(10, hosp.getSenha());
			
			int linhasAfetadas = pstm.executeUpdate();
			pstm.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Cadastrado!");
				return true;
			}
			
			System.out.println("Erro no cadastro");
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
	
	
	
	//mostrando Quarto
	public ArrayList<Quarto> mostrarQuarto(){
		String sql = "SELECT * FROM quarto ORDER BY numero_quarto";
		this.con = new FabricaConexao().getConexao();
		ArrayList<Quarto> lista = new ArrayList<Quarto>();
		try {
			PreparedStatement pstmn = con.prepareStatement(sql);
			ResultSet rs = pstmn.executeQuery();
			while(rs.next()) {
				Quarto q = new Quarto();
				q.setNumero(rs.getInt("numero_quarto"));
				q.setTipo(rs.getString("tipo"));
				q.setValorDiaria(rs.getFloat("valor"));
				q.setDescricao(rs.getString("descricao"));
				q.setDisponivel(rs.getBoolean("disponivel"));
				
				lista.add(q);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	//funcao para reservar quarto
	public boolean addReserva(Reserva re){
		String sql = "INSERT INTO reserva (cpf_hospede, numero_quarto, data_inicial, data_final) VALUES (?, ?, ?, ?);";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, re.getCpfHospede());
			pstm.setInt(2, re.getNumeroQuarto());
			pstm.setDate(3, re.getDataInicio());
			pstm.setDate(4, re.getDataFim());
			
			int linhasAfetadas = pstm.executeUpdate();
			pstm.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Reserva realizada!");
				return true;
			}
			System.out.println("Erro na reserva!");
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
	
	//mostrando consumo do hospede
	public List<ConsumoHospede> mostrarConsumo(String cpf) throws SQLException {
		String sql = "SELECT * FROM consumo_hospede ch WHERE ch.cpf_hospede ILIKE '" + cpf + "';";
		this.con = new FabricaConexao().getConexao();
		List<ConsumoHospede> lista = new ArrayList<ConsumoHospede>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ConsumoHospede ch = new ConsumoHospede();
			while(rs.next()) {
				ch.setPedido(rs.getDouble("consumo_pedido"));
				ch.setAreaLazer(rs.getDouble("consumo_area_lazer"));
				ch.setAluguel(rs.getDouble("consumo_aluguel"));
				
				lista.add(ch);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	//liberando a disponibilidade do quarto para true
	public boolean liberar(Reserva reserva) throws SQLException {
		String sql = "SELECT * FROM reserva WHERE cpf_hospede ILIKE '" + reserva.getCpfHospede() +"';";
		this.con = new FabricaConexao().getConexao();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				reserva.setNumeroQuarto(rs.getInt("numero_quarto"));
			}
			stmt.close();
			
			String altera = "UPDATE quarto SET disponivel = ? WHERE numero_quarto = '" + reserva.getNumeroQuarto() + "';";
			PreparedStatement pstmt = con.prepareStatement(altera);
			pstmt.setBoolean(1, true);
			
			int linhasAfetadas = pstmt.executeUpdate();
			pstmt.close();
			
			if(linhasAfetadas > 0) {
				return true;
			}
			
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
	
	//excluir reserva do hospede
	public boolean excluirReserva(String cpf) throws SQLException {	
		Reserva reserva = new Reserva();
		reserva.setCpfHospede(cpf);
		if(liberar(reserva)) {
			String sql = "DELETE FROM reserva WHERE cpf_hospede ILIKE ?;" ;
			this.con = new FabricaConexao().getConexao();
			try {
				PreparedStatement stmt = con.prepareStatement(sql);					
				stmt.setString(1, reserva.getCpfHospede());
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
		return false;
	}
	
	//usando a area de lazer
	public boolean areaLazer(String cpf) {
		String sql = "UPDATE consumo_hospede SET consumo_area_lazer = consumo_area_lazer + ? WHERE cpf_hospede ILIKE ?;";
		this.con = new FabricaConexao().getConexao();
		AreaLazer al = new AreaLazer(80);
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, al.getTaxa());
			stmt.setString(2, cpf);
			int linhasAfetadas = stmt.executeUpdate();
			stmt.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Area de lazer acessada!");
				return true;
			}
			
			System.out.println("Não foi possível acessar");
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
	
	//listar pedidos
	public ArrayList<Prato> mostrarPratos() throws SQLException {
		String sql = "SELECT * FROM restaurante ORDER BY nome_prato";
		this.con = new FabricaConexao().getConexao();
		ArrayList<Prato> listaPratos = new ArrayList<Prato>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prato prato = new Prato();
				prato.setNomePrato(rs.getString("nome_prato"));
				prato.setDescricaoPrato(rs.getString("descricao"));
				prato.setPreco(rs.getDouble("valor"));
				
				listaPratos.add(prato);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
				return listaPratos;
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<Prato> menorPreco() throws SQLException {
		String sql = "SELECT * FROM restaurante ORDER BY valor ASC";
		this.con = new FabricaConexao().getConexao();
		ArrayList<Prato> listaPratos = new ArrayList<Prato>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prato prato = new Prato();
				prato.setNomePrato(rs.getString("nome_prato"));
				prato.setDescricaoPrato(rs.getString("descricao"));
				prato.setPreco(rs.getDouble("valor"));
				
				listaPratos.add(prato);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
				return listaPratos;
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<Prato> maiorPreco() throws SQLException {
		String sql = "SELECT * FROM restaurante ORDER BY valor DESC";
		this.con = new FabricaConexao().getConexao();
		ArrayList<Prato> listaPratos = new ArrayList<Prato>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Prato prato = new Prato();
				prato.setNomePrato(rs.getString("nome_prato"));
				prato.setDescricaoPrato(rs.getString("descricao"));
				prato.setPreco(rs.getDouble("valor"));
				
				listaPratos.add(prato);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				this.con.close();
				return listaPratos;
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//mostrando apenas duas casas decimais
	public static String format(double x) {  
	    DecimalFormat df = new DecimalFormat("#0.00");  
	    return df.format(x);
	}
	
	//realizar pedido
	public boolean realizarPedido(Pedido pedido) {
		String sql = "INSERT INTO pedido VALUES(?, ?);";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pedido.getCpfHospede());
			pstmt.setString(2, pedido.getNomePrato());
			
			int linhasAfetadas = pstmt.executeUpdate();
			pstmt.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Pedido realizado!");
				return true;
			}
			
			System.out.println("Não foi possível pedir");
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
}
