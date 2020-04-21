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
import negocio.Recurso;
import negocio.TipoRecurso;

/**
 * Servlet implementation class ListarTiposRecursos
 */
@WebServlet("/ListarRecurso")
public class ListarRecurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB NegocioRemote negocio;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRecurso() {
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
				List<Recurso> recursos = negocio.getRecursos();
				
				String tipoRecurso = request.getParameter("nombretiporecurso");
				

					if( negocio.consultaTRecurso(tipoRecurso) ) {
					List<Recurso> recursos2 = negocio.getRecursoTipoRecurso(tipoRecurso);
					System.out.println("buscar");
					System.out.println(recursos);
					request.setAttribute("Recursos", recursos2);
					}
				
				else {
				request.setAttribute("Recursos", recursos);
				}
				
				RequestDispatcher rd = request.getRequestDispatcher("/ListarRecurso.jsp");
		        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipoRecurso = request.getParameter("nombretiporecurso");
		List<Recurso> recursos = negocio.getRecursoTipoRecurso(tipoRecurso);
		System.out.println("buscar");
		System.out.println(recursos);
		
		request.setAttribute("Recursos", recursos);
		getServletContext().getRequestDispatcher("/ListarRecurso.jsp").forward(request, response);
	}

}
