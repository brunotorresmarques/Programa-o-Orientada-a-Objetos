package br.quixada.ufc.si.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	private String driver = "org.postgresql.Driver";
	private String user = "assvvlea";
	private String senha = "DK17RiXvEZsJpwWQNen0kvqlT0byGgcz";
	private String url = "jdbc:postgresql://tuffi.db.elephantsql.com:5432/assvvlea";
	protected Connection con = null;

	public FabricaConexao() {
		try{
			Class.forName(driver);
			this.con = (Connection) DriverManager.getConnection(url, user, senha);
		}catch(ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		}catch(SQLException e) {
			System.err.print(e.getMessage());
			e.printStackTrace();
		}	
	}
	
	public Connection getConexao() {
		return this.con;
	}
}
