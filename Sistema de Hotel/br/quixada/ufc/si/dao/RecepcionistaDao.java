package br.quixada.ufc.si.dao;

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

public class RecepcionistaDao{
	private Connection con;
	
	//mostrando hospedes
	public List<Hospede> mostarHospede(){
		String sql = "SELECT * FROM hospede ORDER BY cpf";
		this.con = new FabricaConexao().getConexao();
		List<Hospede> lista = new ArrayList<Hospede>();
		try {
			PreparedStatement pstmn = con.prepareStatement(sql);
			ResultSet rs = pstmn.executeQuery();
			while(rs.next()) {
				Hospede h = new Hospede();
				h.setCpf(rs.getString("cpf"));
				h.setNome(rs.getString("nome"));
				h.setTelefone(rs.getString("telefone"));
				h.setEmail(rs.getString("email"));
				h.setDataNasc(rs.getDate("data_nascimento"));
				h.setLogradouro(rs.getString("logradouro"));
				h.setNumero(rs.getInt("numero"));
				h.setBairro(rs.getString("bairro"));
				h.setCidade(rs.getString("cidade"));
					
				lista.add(h);
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
	
	public Recepcionista procurarRecepcionista(Login login) {
		String sql = "SELECT * FROM Recepcionista where cpf = ?;";
		Recepcionista recep = null;
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, login.getUser());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String nome = rs.getString("cpf");
				String cpf = rs.getString("nome");
				String senha = rs.getString("senha");
				String turno = rs.getString("turno");
				Date dataContrato = rs.getDate("data_contrato");
				Double salario = rs.getDouble("salario");
				recep = new Recepcionista(cpf, nome, senha, salario, turno, dataContrato);
			}
			stmt.close();

			return recep;

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
	
	//Atualizar consumo do Hospede
	public boolean atualiza(String cpf) {
		String sql = "UPDATE consumo_hospede SET consumo_pedido = ?, consumo_area_lazer = ?, consumo_aluguel = ? WHERE cpf_hospede ILIKE ?;";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDouble(1, 0);
			stmt.setDouble(2, 0);
			stmt.setDouble(3, 0);
			stmt.setString(4, cpf);
			
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
	
	//realizar pagamento
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
	
	//excluir Hospede
	public boolean excluirHospede(String cpf) {
		String sql = "DELETE FROM hospede WHERE cpf ILIKE ?;" ;
		this.con = new FabricaConexao().getConexao();
	    try {
	    	PreparedStatement stmt = con.prepareStatement(sql);					
	        stmt.setString(1, cpf);
	        
	        int linhasAfetadas = stmt.executeUpdate();
			stmt.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Deleteado!");
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
	
	//liberando o quarto
	public boolean liberarQuarto(QuartoAlugado quartoA) {
		String sql = "SELECT * FROM quarto_alugado WHERE cpf_hospede ILIKE '" + quartoA.getCpfHospede() + "';";
		this.con = new FabricaConexao().getConexao();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				quartoA.setNumeroQuarto(rs.getInt("numero_quarto"));
			}
			stmt.close();
			
			String libera = "UPDATE quarto SET disponivel = ? WHERE numero_quarto = '" + quartoA.getNumeroQuarto() + "';";
			PreparedStatement pstmt = con.prepareStatement(libera);
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
	
	//excluir Quarto_Alugado do Hospede
	public boolean excluirQuartoAlugado(String cpf) {
		QuartoAlugado quartoA = new QuartoAlugado();
		quartoA.setCpfHospede(cpf);
		if(liberarQuarto(quartoA)) {
			String sql = "DELETE FROM quarto_alugado WHERE cpf_hospede ILIKE ? AND numero_quarto = ?;" ;
			this.con = new FabricaConexao().getConexao();
		    try {
		    	PreparedStatement stmt = con.prepareStatement(sql);					
		    	stmt.setString(1, cpf);
		    	stmt.setInt(2, quartoA.getNumeroQuarto());
		    	
		    	int linhasAfetadas = stmt.executeUpdate();
				stmt.close();
				
				if(linhasAfetadas > 0) {
					System.out.println("Deletado!");
					return true;
				}
				
				System.out.println("Erro ao deletar");
				return false;
		    }catch (SQLException e) {
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
	
	//verifica se tem uma reserva e disponibiliza o quarto
	public boolean verifica(String cpf) {
		String sql = "SELECT * FROM reserva WHERE cpf_hospede ILIKE '" + cpf +"';";
		this.con = new FabricaConexao().getConexao();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			QuartoAlugado quartoA = new QuartoAlugado();
			while(rs.next()) {
				quartoA.setNumeroQuarto(rs.getInt("numero_quarto"));
				quartoA.setDataIni(rs.getDate("data_inicial"));
				quartoA.setDataFim(rs.getDate("data_final"));
			}
			stmt.close();
			
		String altera = "UPDATE quarto SET disponivel = ? WHERE numero_quarto = '" + quartoA.getNumeroQuarto() + "';";
			PreparedStatement pstmt = con.prepareStatement(altera);
			pstmt.setBoolean(1, true);
			
			int linhasAfetadas = pstmt.executeUpdate();
			pstmt.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Reserva encontrada!");
				return true;
			}
			
			System.out.println("Nenhuma reserva encontrada!");
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
	
	//funcao de alugar quarto
	public boolean addQuartoAlugado(QuartoAlugado quartoA) throws SQLException {
		String sql = "INSERT INTO quarto_alugado (cpf_hospede, numero_quarto, data_inicial, data_final) VALUES (?, ?, ?, ?);";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, quartoA.getCpfHospede());
			pstm.setInt(2, quartoA.getNumeroQuarto());
			pstm.setDate(3, quartoA.getDataIni());
			pstm.setDate(4, quartoA.getDataFim());
			
			int linhasAfetadas = pstm.executeUpdate();
			pstm.close();
			
			if(linhasAfetadas > 0) {
				System.out.println("Quarto Alugado!");
				return true;
			}
			
			System.out.println("Erro no aluguel");
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
	
	//excluir reserva do hospede que tem um quarto alugado
	public boolean excluirReserva(String cpf) throws SQLException {	
		String sql = "DELETE FROM reserva WHERE cpf_hospede ILIKE ?;" ;
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);					
			stmt.setString(1, cpf);
			int linhasAfetadas = stmt.executeUpdate();
			stmt.close();
				
			if(linhasAfetadas > 0) {
				return true;
			}
			
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
	//alugando um quarto com reserva
	public boolean alugarQuartoReserva(String cpf) {
		String sql = "INSERT INTO quarto_alugado SELECT * FROM reserva r WHERE r.cpf_hospede ILIKE ?;";
		this.con = new FabricaConexao().getConexao();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cpf);
			
			int linhasAfetadas = pstmt.executeUpdate();
			pstmt.close();
			
			if(linhasAfetadas > 0 && excluirReserva(cpf)) {
				System.out.println("Quarto alugado!");
				return true;
			}
			System.out.println("Erro no aluguel!");
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
	
	//mostrando apenas duas casas decimais
	public static String format(double x) {  
	    DecimalFormat df = new DecimalFormat("#0.00");  
	    return df.format(x);
	}
}