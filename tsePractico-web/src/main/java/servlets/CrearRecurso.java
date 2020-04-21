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
 * Servlet implementation class CrearRecurso
 */
@WebServlet("/CrearRecurso")
public class CrearRecurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB NegocioRemote negocio;
    /**
     * Default constructor. 
     */
    public CrearRecurso() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TipoRecurso> tRecursos = negocio.getTipoRecursos();
		
		request.setAttribute("TRecursos", tRecursos);
		RequestDispatcher rd = request.getRequestDispatcher("/CrearRecurso.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		double precioUnitario = Double.valueOf(request.getParameter("precio"));
		int cantidad=Integer.valueOf(request.getParameter("cantidad"));
		String tipoRecurso = request.getParameter("tipoRecurso");
		
		if ( negocio.precioMaximo(tipoRecurso, precioUnitario) ) {
			negocio.newRecurso(codigo, precioUnitario, cantidad, tipoRecurso);		
			
			request.setAttribute("msj", true);
		}
		else request.setAttribute("msj", false);
		
		List<TipoRecurso> tRecursos = negocio.getTipoRecursos();
		request.setAttribute("TRecursos", tRecursos);
		
		getServletContext().getRequestDispatcher("/CrearRecurso.jsp").forward(request, response);

	}

}
