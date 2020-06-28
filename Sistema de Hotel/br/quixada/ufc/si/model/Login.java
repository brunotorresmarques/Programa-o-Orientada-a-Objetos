package br.quixada.ufc.si.model;

public class Login {
	private String user;
	private String pass;
	private int nivel;

	public Login() {
		super();
	}
	
	public Login(String user, String pass, int nivel) {
		super();
		this.user = user;
		this.pass = pass;
		this.nivel = nivel;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
