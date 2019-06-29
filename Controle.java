package control;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import model.Banco;
import user.Usuario;

public class Controle {

	public int insereUsuario(String nomeCompleto, String cpf, String dtNasc, String endereco, String nomeMae,
			String nomePai, String telefoneFixo, String celular, String email) {

		Banco database = new Banco();

		int chave = -1;

		try {
			Usuario u = new Usuario();

			u.setNomeCompleto(nomeCompleto);
			u.setCpf(cpf);
			u.setDtNasc(dtNasc);
			u.setNomeMae(nomeMae);
			u.setNomePai(nomePai);
			u.setEndereco(endereco);
			u.setCelular(celular);
			u.setTelefoneFixo(telefoneFixo);
			u.setEmail(email);
			chave = database.insert(u);
			
			} 
		catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de insert" + e.getMessage());
		}
		return chave;

	}

	public int insereAluno(int matricula, String cpf, String curso) {

		Banco database = new Banco();

		int chave = -1;

		try {
			Usuario u = new Usuario();

			u.setMatricula(matricula);
			u.setCpf(cpf);
			u.setEmail(curso);
			chave = database.insert(u);
			
			} 
		catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de insert" + e.getMessage());
		}
		return chave;

	}
	
	public List<Usuario> selecionaTudo() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Banco database = new Banco();
			usuarios = database.selectAllUsuario();

		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de select" + e.getMessage());
		}
		return usuarios;
	}

	
	public boolean deletarLinha(String cpf) {
		boolean verifica = false;
		try {
			Banco database = new Banco();
			verifica = database.delete(cpf);
		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de DELETE" + e.getMessage());
		}
		return verifica;

	}

	public boolean atualizarTabela(String coluna, String cpf, String atualizacao) {
		boolean verifica = false;
		Banco database = new Banco();
		try {

			verifica = database.update(coluna, cpf, atualizacao);

		} catch (ClassNotFoundException e) {
			System.err.println("O driver do banco não foi encontrado no ClassPath");
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao executar a instrução de DELETE" + e.getMessage());
		}
		return verifica;

	}


	public int geraMatricula() {
		int matricula=0;
		Random gerador = new Random();
		matricula = (int) (gerador.nextDouble()*1000000000);
		
		if(matricula <= 0) {
			matricula = matricula*(-1);
		}		
				
		return matricula;
	}

	public String geraSenha() {
		String uuid = UUID.randomUUID().toString();
		String senha = uuid.substring(0,8); 
		return senha;
	}
}