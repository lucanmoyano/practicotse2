package ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.PathVariable;

import negocio.NegocioLocal;
import negocio.Recurso;
import negocio.TipoRecurso;


@ApplicationPath("/resources")
@Path("/RestService")
public class Rest extends Application {
	
	@EJB 
	NegocioLocal data;

	//http://localhost:8080/tsePractico-web/resources/RestService/crearRecurso
	@POST
	@Path("/crearRecurso")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response newRecurso(Recurso recurso) {
		try {
		data.addRecursoREST(recurso);
			return Response.status(201).entity("success").build();
		} catch(Exception e){
			return Response.status(500).entity("error").build();
		}
		
	/* EJEMPLO DE COMO ENVIAR JSON
		{
		"codigo":"hell",
		"precioUnitario":2,
		"cantidad":1,
			"tipoRecurso":{
		      "nombre": "uno"
			}
		}
		  */
	}
	
	
	//http://localhost:8080/tsePractico-web/resources/RestService/listarRecursos
	@GET
	@Path("/listarRecursos")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarRecursos() {
		
		List<Recurso> recurso = data.getRecursos();
		return Response.status(200).entity(recurso).build();
		
	 }
	
	
	//http://localhost:8080/tsePractico-web/resources/RestService/listarTiposRecursos
	@GET
	@Path("/listarTiposRecursos")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTiposRecursos(){
		List<TipoRecurso> tRecurso = data.getTipoRecursos();
		return Response.status(200).entity(tRecurso).build();
	}
	
	
	//http://localhost:8080/tsePractico-web/resources/RestService/listarRecursoTipoRecurso
	@GET
	@Path("/listarRecursoTipoRecurso/{nombre}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarRecursoTipoRecurso(@PathParam("nombre") String nombre){
		List<Recurso> recurso = data.getRecursoTipoRecurso(nombre);
		
		return Response.status(200).entity(recurso).build();
		
		/*Ejemplo de envio url
		 *
		 http://localhost:8080/tsePractico-web/resources/RestService/listarRecursoTipoRecurso/uno
		 le pido los recursos del tipo de recurso {uno}
		 * */
	}
	
	
}
