package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.Controle;
import user.Usuario;

/**
 * Servlet implementation class TelaWebScriptless
 */
@WebServlet("/TelaWebScriptless")
public class TelaWebScriptless extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TelaWebScriptless() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: COMPUTADOR DO DAVID").append(request.getContextPath());
		
		Controle control = new Controle();
		control.geraMatricula();
		List<Usuario> user = control.selecionaTudo();
		
		request.setAttribute("control", control);
		request.setAttribute("usu", user);
		request.getRequestDispatcher("/lista.jsp").forward(request, response);
		
	
	
	
	
	
	}


}
