package br.com.david.facet.lab3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controle {

	public int insereUsuario(String nomeCompleto, String sexo, int idade, String cpf, String rg, String nacionalidade,
			String estadoCivil, String celular, String telefoneFixo, String dtNasc, String endereco, String email) {

		Banco database = new Banco();

		int chave = -1;

		try {
			Usuario u = new Usuario();

			u.setNomeCompleto("petterson");
			u.setSexo("M");
			u.setIdade(28);
			u.setCpf("teste");
			u.setRg("teste");
			u.setNacionalidade("teste");
			u.setEstadoCivil("teste");
			u.setCelular("teste");
			u.setTelefoneFixo("teste");
			u.setDtNasc("teste");
			u.setEndereco("teste");
			u.setEmail("teste@teste.com");
			chave = database.insert(u);
			System.out.println("A chave gerada para este registro foi: " + chave);

		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de insert" + e.getMessage());
		}
		return chave;

	}

	public List<Usuario> selecionaTudo() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Banco database = new Banco();
			usuarios = database.selectAll();

		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de select" + e.getMessage());
		}
		return usuarios;
	}

	public List<Usuario> selecionaNome(String nome) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Banco database = new Banco();
			usuarios = database.selectName(nome);

		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de select Name" + e.getMessage());
		}
		return usuarios;
	}

	public List<Usuario> selecionaId(int id) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Banco database = new Banco();
			usuarios = database.selectId(id);

		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de select ID" + e.getMessage());
		}
		return usuarios;
	}

	public boolean deletarLinha(int id) {
		boolean verifica = false;
		try {
			Banco database = new Banco();
			verifica = database.delete(id);
		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de DELETE" + e.getMessage());
		}
		return verifica;

	}

	public boolean atualizarTabela(String coluna, int id, String atualizacao) {
		boolean verifica = false;
		Banco database = new Banco();
		try {

			verifica = database.update(coluna, id, atualizacao);

		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de DELETE" + e.getMessage());
		}
		return verifica;

	}

}