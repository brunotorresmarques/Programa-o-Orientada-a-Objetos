package br.ufc.si.model;

public class Produtos {
	private String nome;
	private String codigo;
	private double preco;
	private int quantidade;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public Produtos(String nome, String codigo, double preco, int quantidade) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Produtos() {
		super();
	}
	

	@Override
	public String toString() {
		return "Nome: " + nome +"\n"+ "Codigo: " + codigo +"\n"+ "Preço: " + preco +"\n" + "Quantidade: " + quantidade + "\n";
	}
	
	
	
	
	
}
