package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.Usuario;

public class Banco {

	public int insert(Usuario usu) throws ClassNotFoundException, SQLException {

		Connection conn = this.getConnection();

		String sql = "insert into pessoa (nomeCompleto,cpf,dtNasc,nomeMae,nomePai,endereco,telefone,celular,email)"
				+ "values ('" + usu.getNomeCompleto() + "'" + ",'" + usu.getCpf() + "'" + ",'" +  usu.getDtNasc() + "'"
				+ ",'" + usu.getNomeMae() + "'," + " '" + usu.getNomePai() + "'," + " '" + usu.getEndereco() + "'," + " '"
				+ usu.getTelefoneFixo() + "'," + " '" + usu.getCelular() + "'," + " '" + usu.getEmail() + "')";

		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int ret = ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			ret = rs.getInt(1);
		}

		conn.close();
		return ret;

	}
	
	public int insertAluno(Usuario usu) throws ClassNotFoundException, SQLException {

		Connection conn = this.getConnection();

		String sql = "insert into aluno (matricula,cpf,curso)"
				+ "values ('" + usu.getMatricula() + "'" + ",'" + usu.getCpf() + "'" + ",'" +  usu.getCurso() + "')";

		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int ret = ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			ret = rs.getInt(1);
		}

		conn.close();
		return ret;

	}
	public List<Usuario> selectAllUsuario() throws ClassNotFoundException, SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = this.getConnection();
		String sql = "select * from pessoa";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		Usuario usuario = null;

		while (rs.next()) {

			usuario = new Usuario();
			usuario.setNomeCompleto(rs.getString("nomeCompleto"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setDtNasc(rs.getString("dtNasc"));
			usuario.setEndereco(rs.getString("endereco"));
			usuario.setNomeMae(rs.getString("nomeMae"));
			usuario.setNomePai(rs.getString("nomePai"));
			usuario.setTelefoneFixo(rs.getString("telefoneFixo"));
			usuario.setCelular(rs.getString("celular"));
			usuario.setEmail(rs.getString("email"));
			usuarios.add(usuario);

		}

		conn.close();

		return usuarios;
	}
	
	public List<Usuario> selectAllCurso() throws ClassNotFoundException, SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = this.getConnection();
		String sql = "select * from curso";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		Usuario usuario = null;

		while (rs.next()) {

			usuario = new Usuario();
			usuario.setCurso(rs.getString("idCurso"));
			usuario.setNomeCurso(rs.getString("nomeCurso"));
			usuarios.add(usuario);

		}

		conn.close();

		return usuarios;
	}
	
	public List<Usuario> selectAllAluno() throws ClassNotFoundException, SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = this.getConnection();
		String sql = "select u.nome, a.aluno_matricula, a.aluno_cpf, c.nome_curso from aluno a join curso c on a.cpf = c.aluno_cpf join usuario u on u.cpf = a.aluno_cpf";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		Usuario usuario = null;

		while (rs.next()) {

			usuario = new Usuario();
			usuario.setNomeCompleto(rs.getString("nomeCompleto"));
			usuario.setMatricula(rs.getInt("matricula"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setCurso(rs.getString("curso"));
			usuarios.add(usuario);

		}

		conn.close();

		return usuarios;
	}

	public boolean delete(String cpf) throws ClassNotFoundException, SQLException {

		Connection conn = this.getConnection();
		boolean flag = false;
		String sql = "delete from pessoa where cpf = '" + cpf + "'";

		PreparedStatement ps = conn.prepareStatement(sql);
		int ret = ps.executeUpdate();

		if (ret == 1) {
			flag = true;
		} else {
			System.out.println("ID não existe na tabela");
		}

		conn.close();

		return flag;

	}

	public boolean update(String banco, String cpf, String dado) throws ClassNotFoundException, SQLException {

		Connection conn = this.getConnection();
		boolean flag = false;
		String query = "update usuario set " + banco + " = ? where cpf = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, dado);
		preparedStmt.setString(2, cpf);
		int ret = preparedStmt.executeUpdate();
		if (ret == 1) {
			flag = true;
		} else {
			System.out.println("ID não existe na tabela");
		}

		conn.close();

		return flag;

	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(org.sqlite.JDBC.class.getName());
		Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\multi\\eclipse-workspace2\\trabJava\\facetlab3.db");
		return conn;
	}	

}
