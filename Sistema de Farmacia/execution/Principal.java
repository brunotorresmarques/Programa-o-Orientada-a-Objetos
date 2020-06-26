package br.ufc.si.exec;

import java.util.Scanner;


import br.ufc.si.model.Cliente;

import br.ufc.si.model.Funcoes_Cliente;
import br.ufc.si.model.Pessoa;
import br.ufc.si.model.Funcionario;
import br.ufc.si.model.Funcoes_Funcionario;
import br.ufc.si.model.Produtos;
import br.ufc.si.model.Funcoes_Produtos;



public class Principal {

	static Scanner ler = new Scanner(System.in);
	public static void main(String[] args) {
		
		Funcoes_Funcionario Adm = new Funcoes_Funcionario();
		
		Funcoes_Cliente Clien = new Funcoes_Cliente();
		
		Funcoes_Produtos produto = new Funcoes_Produtos();
		
		int numero;
		
			System.out.println("                +-----------------------+");
			System.out.println("                | Bem vindo a Farmacia! |");
			System.out.println("                +-----------------------+");
			System.out.println("\n");
		
		do {
			
			System.out.println("                   +------------------+");
			System.out.println("                   | 1-Funcionario:   |");
			System.out.println("                   | 2-Cliente:       |");
			System.out.println("                   | 3-Finalizar:     |");
			System.out.println("                   +------------------+");
			
			
			numero = ler.nextInt();
			
			if(numero == 1) {
				
				int opcao;
				
				do {
					System.out.println("\n");
					System.out.println("             +------------------------------+");
					System.out.println("             | 1-Realizar cadastro:         |");
					System.out.println("             | 2-Já sou cadastrado:         |");
					System.out.println("             | 3-Retornar ao Menu anterior: |");
					System.out.println("             +------------------------------+");
					
					
					opcao = ler.nextInt();
					
					//Cadastra Administrador
					if(opcao == 1) {
						System.out.println("\n");
						
						System.out.println("Nome: ");
						ler.nextLine();
						String nome = ler.nextLine();
						
						System.out.println("CPF: ");
						String CPF = ler.nextLine();
						
						System.out.println("Login: ");
						String login = ler.nextLine();
						
						System.out.println("Senha: ");
						String senha = ler.nextLine();
						
						Funcionario f = new Funcionario(nome, CPF, login, senha);
						
						Adm.inserir(f);
						
						System.out.println("\n");
					}
					
					else if(opcao == 2) {
						System.out.println("Digite seu Login: ");
						ler.nextLine();
						String lo = ler.nextLine();
						
						System.out.println("Digite sua senha: ");
						String sen = ler.nextLine();
							
							
						if(Adm.procurarFuncionario(lo, sen) != null) {
						
						int escolha;
						
						do {
							System.out.println("\n");
							System.out.println("          +-------------------------------------+");
							System.out.println("          | 1-Cadastrar produto:                |");
							System.out.println("          | 2-Remover produto:                  |");
							System.out.println("          | 3-Editar produto:                   |");
							System.out.println("          | 4-Editar Dados de cadastro:         |");
							System.out.println("          | 5-Remover cadastro:                 |");
							System.out.println("          | 6-Listar produtos cadastrados:      |");
							System.out.println("          | 7-Gerar relatório de Funcionarios:  |");
							System.out.println("          | 8-Retornar ao Menu anterior:        |");
							System.out.println("          +-------------------------------------+");
							
							escolha = ler.nextInt();
							
							
							//Cadastrar Jogo
							if(escolha == 1) {
								
								System.out.println("Digite o nome do produto: ");
								ler.nextLine();
								String nome = ler.nextLine();
								
								
								//cadastra produto não cadastrado
								if(produto.procurarProduto(nome) == null) {
								
									System.out.println("Codigo: ");
									String codigo = ler.nextLine();
								
									System.out.println("Preço: ");
									double preco = ler.nextDouble();
								
									System.out.println("Quantidade: ");
									int quantidade = ler.nextInt();
								
									Produtos p = new Produtos(nome, codigo, preco, quantidade);
								
									produto.inserir(p);
								
									System.out.println("\n");
								}
								
								//adiciona mais produto ja cadastrados
								else {
									System.out.println("Digite a quantidade de produtos q deseja cadastrar: ");
									int Qtd = ler.nextInt();
									
									produto.procurarProduto(nome).setQuantidade(produto.procurarProduto(nome).getQuantidade()+Qtd);
								}
							}
							//Excluir produto
							else if(escolha == 2) {
								System.out.println("Digite o codigo do produto que deseja excluir: ");
								ler.nextLine();
								String codigo = ler.nextLine();
								if(produto.procurarProduto(codigo) != null) {
									produto.remover(produto.procurarProduto(codigo));
									
								}
								else {
									System.out.println("Produto não cadastrado!");
								}
							}
							
							//Editar Produto
							else if(escolha == 3) {
								System.out.println("Digite o codigo do Produto: ");
								ler.nextLine();
								String op = ler.nextLine();
								
								if(produto.procurarProduto(op) != null) {
								
								
								int num;
								
								do {
									System.out.println("1-Editar nome:");
									System.out.println("2-Editar Codigo: ");
									System.out.println("3-Editar preço: ");
									System.out.println("4-Retornar ao Menu anterior: ");
									
									num = ler.nextInt();
									
									if(num == 1) {
										System.out.println("Digite o novo nome: ");
										ler.nextLine();
										String nome = ler.nextLine();
										
										produto.procurarProduto(op).setNome(nome);
									}
									
									else if(num == 2) {
										System.out.println("Digite o novo codigo: ");
										ler.nextLine();
										String tipo = ler.nextLine();
										
										produto.procurarProduto(op).setCodigo(tipo);
									}
									
									else if(num == 3) {
										System.out.println("Digite o novo preco: ");
										ler.nextLine();
										double preco = ler.nextDouble();
										
										produto.procurarProduto(op).setPreco(preco);
									}
								}while(num != 4);
									
								}
								else {
									System.out.println("Produto não cadastrado!");
									System.out.println("\n");
								}
							}
							
							//Edita Dados de cadastro do Funcionario
							else if(escolha == 4) {
								System.out.println("Digite o Login: ");
								ler.nextLine();
								String op = ler.nextLine();
								
								System.out.println("Digite a senha: ");
								String senha = ler.nextLine();
								
								if(Adm.procurarFuncionario(op,senha) != null) {
								
								
								int num;
								
								do {
									System.out.println("1-Editar nome:");
									System.out.println("2-Editar CPF: ");
									System.out.println("3-Editar Login: ");
									System.out.println("4-Editar Senha: ");
									System.out.println("5-Retornar ao Menu anterior: ");
									
									num = ler.nextInt();
									
									if(num == 1) {
										System.out.println("Digite o novo nome: ");
										ler.nextLine();
										String nome = ler.nextLine();
										
										Adm.procurarFuncionario(op,senha).editarNome(nome);
									}
									
									else if(num == 2) {
										System.out.println("Digite o novo CPF: ");
										ler.nextLine();
										String cpf = ler.nextLine();
										
										Adm.procurarFuncionario(op,senha).editarCpf(cpf);
									}
									
									else if(num == 3) {
										System.out.println("Digite o novo Login: ");
										ler.nextLine();
										String login = ler.nextLine();
										
										Adm.procurarFuncionario(op,senha).editarLogin(login);
									}
									
									else if(num == 4) {
										System.out.println("Digite a nova Senha: ");
										ler.nextLine();
										String senh = ler.nextLine();
										
										Adm.procurarFuncionario(op,senha).editarSenha(sen);
									}
								}while(num != 5);
									
								}
								else {
									System.out.println("Funcionario não cadastrado!");
									System.out.println("\n");
								}
							}
							
							//Remover cadastro de funcionario
							else if(escolha == 5) {
								System.out.println("Digite o Login: ");
								ler.nextLine();
								String str = ler.nextLine();
								
								System.out.println("Digite a senha: ");
								ler.nextLine();
								String senh = ler.nextLine();
								
								if(Adm.procurarFuncionario(str,senh) != null) {
									Adm.remover(Adm.procurarFuncionario(str,senh));
								}else {
									System.out.println("Funcionario não cadastrado");
								}
							}
							
							//Mostrar funcionarios cadastrados
							else if(escolha == 6) {
								produto.mostrarDados();
							}
							//Mostrar produtos cadastrados
							else if(escolha == 7) {
								Adm.mostrarDados();
							}
							else if(escolha != 8) {
								System.out.println("Opção invalida");
							}
							
							
						}while(escolha != 8);
					}else {
						System.out.println("\nLogin ou senha invalido!\n");
					}
					}
				}while(opcao != 3);
				
			}
			
			
			//Referente ao cliente
			else if(numero == 2) {
				
				int opcao;
				
				do {
					System.out.println("\n");
					System.out.println("	      +------------------------------+");
					System.out.println("	      | 1-Realizar cadastro:         |");
					System.out.println("	      | 2-Já sou cadastrado:         |");
					System.out.println("	      | 3-Retornar ao Menu anterior: |");
					System.out.println("	      +------------------------------+");
					opcao = ler.nextInt();
					
					if(opcao == 1) {
						System.out.println("Nome: ");
						ler.nextLine();
						String nome = ler.nextLine();
						
						System.out.println("CPF: ");
						String cpf = ler.nextLine();
						
						System.out.println("Login: ");
						
						String login = ler.nextLine();
						
						System.out.println("Senha: ");
						
						String senha = ler.nextLine();
						
						
						Cliente c = new Cliente(nome, cpf, login, senha);
						
						Clien.inserir(c);
						System.out.println("\n");
					}
					
					else if(opcao == 2) {
						System.out.println("Digite seu Login: ");
						ler.nextLine();
						String lo = ler.nextLine();
						
						System.out.println("Digite sua senha: ");
						String sen = ler.nextLine();
							
							
						if(Clien.procurarCliente(lo, sen) != null) {
							
						
						
						int escolha;
						
						do {
							
						System.out.println("\n");
						System.out.println("		+--------------------------------+");
						System.out.println("		| 1-Editar dados de cadastro:    |");
						System.out.println("		| 2-Remover cadastro:            |");
						System.out.println("		| 3-Ver produtos disponiveis:    |");
						System.out.println("		| 4-Comprar produto:             |");
						System.out.println("		| 5-Retornar ao Menu anterior:   |");
						System.out.println("		+--------------------------------+");
						
						
						
						escolha = ler.nextInt();
						
						
						
						 if(escolha == 1) {
							System.out.println("Digite seu Login: ");
							ler.nextLine();
							String logi = ler.nextLine();
							
							System.out.println("Digite sua senha: ");
							ler.nextLine();
							String senh = ler.nextLine();
							
							
							if(Clien.procurarCliente(logi,senh) != null) {
								int n;
								
								do {
									System.out.println("\n");
									System.out.println("	  +------------------------------+");
									System.out.println("	  | 1-Editar nome:               |");
									System.out.println("	  | 2-Editar CPF:                |");
									System.out.println("	  | 3-Editar Login:              |");
									System.out.println("	  | 4-Editar senha:              |");
									System.out.println("	  | 5-Retornar ao Menu anterior: |");
									System.out.println("	  +------------------------------+");
									
									
									
									n = ler.nextInt();
									
									if(n == 1) {
										System.out.println("Digite o novo nome: ");
										ler.nextLine();
										String nome = ler.nextLine();
										
										Clien.procurarCliente(logi,senh).editarNome(nome);
										System.out.println("\n");
									}
									
									else if(n == 2) {
										System.out.println("Digite o novo CPF: ");
										ler.nextLine();
										String cpf = ler.nextLine();
										
										Clien.procurarCliente(logi,senh).editarCpf(cpf);
										System.out.println("\n");
									}
									
									else if(n == 3) {
										System.out.println("Digite o novo Login: ");
										ler.nextLine();
										String login = ler.nextLine();
										
										Clien.procurarCliente(logi,senh).editarLogin(login);
										System.out.println("\n");
									}
									
									else if(n == 4) {
										System.out.println("Digite a nova senha: ");
										ler.nextLine();
										String senha = ler.nextLine();
										
										Clien.procurarCliente(logi,senh).editarSenha(senha);
										System.out.println("\n");
									}
									
									else if(n != 5){
										System.out.println("Opção inválida!");
										System.out.println("\n");
									}
									
								}while(n != 5);
								
							}
							
							else {
								System.out.println("Cliente não cadastrado!");
								System.out.println("\n");
							}
						}
						// Remove cliente
						else if(escolha == 2) {
							System.out.println("Digite seu Login: ");
							ler.nextLine();
							String logi = ler.nextLine();
							
							System.out.println("Digite sua senha: ");
							ler.nextLine();
							String senh = ler.nextLine();
							
							if(Clien.procurarCliente(logi,senh) != null) {
								Clien.remover(Clien.procurarCliente(logi,senh));
							}
							
							else {
								System.out.println("Cliente não cadastrado!");
							}
						}
						//Mostrar produtos disponiveis
						else if(escolha == 3) {
							produto.mostrarDados();
						}
						//Comprar produto
						else if(escolha == 4) {
							System.out.println("Digite codigo do produto que deseja comprar: ");
							ler.nextLine();
							String cod = ler.nextLine();
							
							if(produto.procurarProduto(cod) != null) {
								System.out.println("Digite quantos deseja comprar: ");
								int quant = ler.nextInt();
								
								if(produto.procurarProduto(cod).getQuantidade() >= quant) {
									produto.procurarProduto(cod).setQuantidade(produto.procurarProduto(cod).getQuantidade() - quant);
									System.out.println("\n Compra concluida com sucesso! \n");
								}
								else {
									System.out.println("Não temos essa quantidade de produtos!");
								}
								
							}
							else {
								System.out.println("Produto não disponivel!");
							}
						}
						
						
						else if(escolha != 5){
							System.out.println("Opção inválida!");
						}
						
						}while(escolha != 5);
						
						}
					}
					
					else if(opcao != 3){
						System.out.println("Opção invalida!");
					}
					
				}while(opcao != 3);
				
			}
			
		}while(numero != 3);
		
		System.out.println("\n");
		System.out.println("Operação finalizada! ");
	}

}

