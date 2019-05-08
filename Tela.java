package br.com.david.facet.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tela {

	public static void main(String[] args) {

		Scanner option = new Scanner(System.in);

		int opcao;
		int id;
		int status;
		String atualizacao = null;
		Controle controla = new Controle();
		boolean flag = false;
		int idPessoa, idade;
		String nomeCompleto,sexo,cpf,rg,nacionalidade,estadoCivil,celular,telefoneFixo,dtNasc,endereco,email;
		List<Usuario> user = new ArrayList<Usuario>();
		do {
			System.out.println("Escolha uma das opções baixo: ");
			System.out.println("1 - Insert");
			System.out.println("2 - Select ALL");
			System.out.println("3 - Select Name");
			System.out.println("4 - Select ID");
			System.out.println("5 - Delete");
			System.out.println("6 - Update");
			System.out.println("0 - SAIR");
			System.out.print("Opçao escolhida: ");
			opcao = option.nextInt();
			option.nextLine();
			switch (opcao) {

			case 1:
				System.out.print("Digite seu nome: ");
				nomeCompleto = option.nextLine();
				System.out.print("Digite seu Sexo (M ou F)");
				sexo = option.nextLine();
				System.out.print("Digite sua idade: ");
				idade = option.nextInt();
				option.nextLine();
				System.out.print("Digite seu CPF: ");
				cpf = option.nextLine();
				System.out.print("Digite seu RG: ");
				rg = option.nextLine();
				System.out.print("Digite sua nacionalidade: ");
				nacionalidade = option.nextLine();
				System.out.print("Digite seu estado civil: ");
				estadoCivil = option.nextLine();
				System.out.print("Digite seu celular: ");
				celular = option.nextLine();
				System.out.print("Digite seu telefone fixo: ");
				telefoneFixo = option.nextLine();
				System.out.print("Digite sua data de nascimento (dd/mm/aaaa): ");
				dtNasc = option.nextLine();
				System.out.print("Digite seu endereço: ");
				endereco = option.nextLine();
				System.out.print("Digite seu email: ");
				email = option.nextLine();
							
				status = controla.insereUsuario(nomeCompleto,sexo,idade,cpf,rg,nacionalidade,estadoCivil,celular,telefoneFixo,dtNasc,endereco,email);
				if (status <= 0) {
					System.out.println("Erro ao inserir");
				} else {
					System.out.println("Linha inserida.");
				}
				break;

			case 2:

				user = controla.selecionaTudo();
				if (user.isEmpty()) {
					System.out.println("Não existem registros.");
				} else {

					for (Usuario usuario : user) {

						System.out.println(usuario.toString());
					}
				}
				break;

			case 3:
				System.out.println("Digite o nome que deseja pesquisar: ");
				String nome = null;
				nome = option.nextLine();
				user = controla.selecionaNome(nome);
				if (user.isEmpty()) {
					System.out.println("Não existem registros.");
				} else {

					for (Usuario usuario : user) {

						System.out.println(usuario.toString());
					}
				}
				break;

			case 4:

				System.out.print("Digite um ID: ");
				id = option.nextInt();
				user = controla.selecionaId(id);
				if (user.isEmpty()) {
					System.out.println("Não existem registros.");
				} else {

					for (Usuario usuario : user) {

						System.out.println(usuario.toString());
					}
				}
				break;

			case 5:

				System.out.print("Digite um ID: ");
				id = option.nextInt();
				flag = controla.deletarLinha(id);
				if (flag == true) {
					System.out.println("Foram deletadas: 1 linha");
				} else {
					System.out.println("Verifique o sistema");
				}
				break;

			case 6:

				System.out.println("Qual dado deseja atualizar?");
				System.out.println("1 - Nome Completo");
				System.out.println("2 - Sexo");
				System.out.println("3 - Idade");
				System.out.println("4 - CPF");
				System.out.println("5 - RG");
				System.out.println("6 - Nacionalidade");
				System.out.println("7 - Estado Civil");
				System.out.println("8 - Celular");
				System.out.println("9 - Telefone Fixo");
				System.out.println("10 - Data de Nascimento: ");
				System.out.println("11 - Endereço");
				System.out.println("12 - Email");
				int escolha = 0;
				escolha = option.nextInt();
				option.nextLine();
				String colunaBanco = null;

				if (escolha == 1) {
					colunaBanco = "nomeCompleto";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite o nome: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}

				} else if (escolha == 2) {
					colunaBanco = "sexo";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite o novo sexo: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}

				}

				else if (escolha == 3) {
					System.out.println(
							"Não é possível alterar sua idade, favor delete e cadastre seu usuário novamente.");
				}

				else if (escolha == 4) {
					System.out
							.println("Não é possível alterar seu CPF, favor delete e cadastre seu usuário novamente.");
				} else if (escolha == 5) {
					System.out.println("Não é possível alterar seu RG, favor delete e cadastre seu usuário novamente.");

				} else if (escolha == 6) {

					colunaBanco = "nacionalidade";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite a nova nacionalidade: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}
				} else if (escolha == 7) {

					colunaBanco = "estadoCivil";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite o estado civil: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}
				} else if (escolha == 8) {

					colunaBanco = "celular";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite o novo celular: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}
				}

				else if (escolha == 9) {

					colunaBanco = "telefoneFixo";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite o novo telefone fixo: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}
				}

				else if (escolha == 10) {

					System.out.println(
							"Não é possível atualizar sua data de nascimento, favor delete e cadastre seu usuário novamente");

				}

				else if (escolha == 11) {

					colunaBanco = "endereco";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite o novo endereço: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}
				}

				else if (escolha == 12) {

					colunaBanco = "email";
					System.out.println("Digite o ID que deseja atualizar:");
					System.out.print("Id: ");
					id = option.nextInt();
					option.nextLine();
					System.out.print("Digite o novo email: ");
					atualizacao = option.nextLine();

					flag = false;
					flag = controla.atualizarTabela(colunaBanco, id, atualizacao);
					if (flag == true) {
						System.out.println("Foram atualizadas: 1 linha");
					} else {
						System.out.println("Não foi possível atualizar");
					}
				} else {

					System.out.println("Opção inválida, você será redirecionado ao menu inicial.");
				}

				break;
			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("Opção inválida");

			}

		} while (opcao != 0);

		option.close();

	}
}
