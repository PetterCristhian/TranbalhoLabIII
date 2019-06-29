package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Controle;
import user.Usuario;

/**
 * Servlet implementation class TelaWeb
 */
@WebServlet("/TelaWeb")
public class TelaWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TelaWeb() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: Computador do David ").append(request.getContextPath());
		Controle control = new Controle();
		PrintWriter print = response.getWriter();
		
		int teste = control.geraMatricula();
		System.out.println(teste);
/*
		print.append("<html>");
		print.append("TESTE ARQUIVO SERVLET");

		List<Usuario> user = control.selecionaTudo();

		print.append("<table>");
		print.append("<tr>");
		print.append("<th>ID</th>");
		print.append("<th>Nome: </th>");
		print.append("<th>Sexo: </th>");
		print.append("<th>Idade: </th>");
		print.append("<th>CPF: </th>");
		print.append("<th>RG: </th>");
		print.append("<th>Nacionalidade: </th>");
		print.append("<th>Estado Civil: </th>");
		print.append("<th>Celular: </th>");
		print.append("<th>Telefone Fixo: </th>");
		print.append("<th>Data de Nascimento: </th>");
		print.append("<th>Endereço: </th>");
		print.append("<th>E-mail: </th>");
		print.append("</tr>");

		for (Usuario usu : user) {
			print.append("<tr>");
			print.append("<td>" + usu.getId() + "</td>");
			print.append("<td>" + usu.getNomeCompleto() + "</td>");
			print.append("<td>" + usu.getSexo() + "</td>");
			print.append("<td>" + usu.getIdade() + "</td>");
			print.append("<td>" + usu.getCpf() + "</td>");
			print.append("<td>" + usu.getRg() + "</td>");
			print.append("<td>" + usu.getNacionalidade() + "</td>");
			print.append("<td>" + usu.getEstadoCivil() + "</td>");
			print.append("<td>" + usu.getCelular() + "</td>");
			print.append("<td>" + usu.getTelefoneFixo() + "</td>");
			print.append("<td>" + usu.getDtNasc() + "</td>");
			print.append("<td>" + usu.getEndereco() + "</td>");
			print.append("<td>" + usu.getEmail() + "</td>");
		}
		print.append("</table>");
		print.append("</html>");*/
	}
	

}
