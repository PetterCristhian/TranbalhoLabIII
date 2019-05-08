package br.com.david.facet.lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Banco {

	public int insert(Usuario usu) throws ClassNotFoundException, SQLException {
		Connection conn = this.getConnection();

		String sql = "insert into pessoa (nomeCompleto,sexo,idade,cpf,rg,nacionalidade,estadoCivil,celular,telefoneFixo,dtNasc,endereco,email)"
				+ "values ('" + usu.getNomeCompleto() + "'" + ",'" + usu.getSexo() + "'" + ",'" + usu.getIdade() + "'"
				+ ",'" + usu.getCpf() + "'," + " '" + usu.getRg() + "'," + " '" + usu.getNacionalidade() + "'," + " '"
				+ usu.getEstadoCivil() + "'," + " '" + usu.getCelular() + "'," + " '" + usu.getTelefoneFixo() + "',"
				+ " '" + usu.getDtNasc() + "'," + " '" + usu.getEndereco() + "'," + " '" + usu.getEmail() + "')";

		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int ret = ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			ret = rs.getInt(1);
		}

		conn.close();
		return ret;

	}

	public List<Usuario> selectAll() throws ClassNotFoundException, SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = this.getConnection();
		String sql = "select * from pessoa";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		Usuario usuario = null;

		while (rs.next()) {

			usuario = new Usuario();
			usuario.setId(rs.getInt("idPessoa"));
			usuario.setNomeCompleto(rs.getString("nomeCompleto"));
			usuario.setSexo(rs.getString("sexo"));
			usuario.setIdade(rs.getInt("idade"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setRg(rs.getString("rg"));
			usuario.setNacionalidade(rs.getString("nacionalidade"));
			usuario.setEstadoCivil(rs.getString("estadoCivil"));
			usuario.setCelular(rs.getString("celular"));
			usuario.setTelefoneFixo(rs.getString("telefoneFixo"));
			usuario.setDtNasc(rs.getString("dtNasc"));
			usuario.setEndereco(rs.getString("endereco"));
			usuario.setEmail(rs.getString("email"));
			usuarios.add(usuario);

		}

		conn.close();

		return usuarios;
	}

	public List<Usuario> selectName(String name) throws ClassNotFoundException, SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = this.getConnection();
		String sql = "select * from pessoa where nomeCompleto like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		ResultSet rs = ps.executeQuery();
		Usuario usuario = null;

		while (rs.next()) {

			usuario = new Usuario();
			usuario.setId(rs.getInt("idPessoa"));
			usuario.setNomeCompleto(rs.getString("nomeCompleto"));
			usuario.setSexo(rs.getString("sexo"));
			usuario.setIdade(rs.getInt("idade"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setRg(rs.getString("rg"));
			usuario.setNacionalidade(rs.getString("nacionalidade"));
			usuario.setEstadoCivil(rs.getString("estadoCivil"));
			usuario.setCelular(rs.getString("celular"));
			usuario.setTelefoneFixo(rs.getString("telefoneFixo"));
			usuario.setDtNasc(rs.getString("dtNasc"));
			usuario.setEndereco(rs.getString("endereco"));
			usuario.setEmail(rs.getString("email"));
			usuarios.add(usuario);

		}

		conn.close();

		return usuarios;

	}

	public List<Usuario> selectId(int id) throws ClassNotFoundException, SQLException {

		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = this.getConnection();
		String sql = "select * from pessoa where idPessoa = '" + id + "'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Usuario usuario = null;
		if (rs.next()) {

			usuario = new Usuario();
			usuario.setId(rs.getInt("idPessoa"));
			usuario.setNomeCompleto(rs.getString("nomeCompleto"));
			usuario.setSexo(rs.getString("sexo"));
			usuario.setIdade(rs.getInt("idade"));
			usuario.setCpf(rs.getString("cpf"));
			usuario.setRg(rs.getString("rg"));
			usuario.setNacionalidade(rs.getString("nacionalidade"));
			usuario.setEstadoCivil(rs.getString("estadoCivil"));
			usuario.setCelular(rs.getString("celular"));
			usuario.setTelefoneFixo(rs.getString("telefoneFixo"));
			usuario.setDtNasc(rs.getString("dtNasc"));
			usuario.setEndereco(rs.getString("endereco"));
			usuario.setEmail(rs.getString("email"));
			usuarios.add(usuario);

		}

		conn.close();
		return usuarios;

	}

	public boolean delete(int id) throws ClassNotFoundException, SQLException {

		Connection conn = this.getConnection();
		boolean flag = false;
		String sql = "delete from pessoa where idPessoa = '" + id + "'";

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

	public boolean update(String banco, int id, String dado) throws ClassNotFoundException, SQLException {

		Connection conn = this.getConnection();
		boolean flag = false;
		String query = "update pessoa set " + banco + " = ? where idPessoa = ?";
		PreparedStatement preparedStmt = conn.prepareStatement(query);
		preparedStmt.setString(1, dado);
		preparedStmt.setInt(2, id);
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
		Class.forName(com.mysql.cj.jdbc.Driver.class.getName());
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/facetlab3?allowPublicKeyRetrieval=true&useSSL=false", "39862",
				"Positivo@99");
		return conn;
	}

}
