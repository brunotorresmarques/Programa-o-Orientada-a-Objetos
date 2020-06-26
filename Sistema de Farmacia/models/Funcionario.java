package br.ufc.si.model;

public class Funcionario extends Pessoa implements Imprimivel{
	private String login;
	private String senha;
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String login, String senha) {
		super(nome, cpf);
		this.login = login;
		this.senha = senha;
	}

	@Override
	public void editarNome(String nome) {
		setNome(nome);
		
		System.out.println("Nome atualizado!");
		
	}

	@Override
	public void editarCpf(String CPF) {
		setCpf(CPF);
		
		System.out.println("CPF atualizado!");
		
	}
	
	public void editarLogin(String login) {
		setLogin(login);
		
		System.out.println("Login atualizado!");
		
	}
	
	public void editarSenha(String senha) {
		setSenha(senha);
		
		System.out.println("Senha atualizada!");
	}
	

	@Override
	public void mostrarDados() {
		System.out.println(super.toString() +"Login: "+ login + "\n" + "Senha: " + senha);
		
	}

}
