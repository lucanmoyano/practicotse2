package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.NegocioRemote;
import negocio.TipoRecurso;

/**
 * Servlet implementation class ListarTiposRecursos
 */
@WebServlet("/ListarTiposRecursos")
public class ListarTiposRecursos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB NegocioRemote negocio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTiposRecursos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// TODO Auto-generated method stub
				System.out.println("entre a servlet 1");
				List<TipoRecurso> tRecursos = negocio.getTipoRecursos();
				
				System.out.println(tRecursos);
				
				request.setAttribute("TRecursos", tRecursos);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarTiposRecursos.jsp");
		        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
