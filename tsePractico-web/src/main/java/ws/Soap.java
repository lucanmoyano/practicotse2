package ws;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import negocio.NegocioLocal;
import negocio.Recurso;
import negocio.TipoRecurso;

@WebService(serviceName = "ws")
public class Soap {
	
	@EJB 
	NegocioLocal data;
	
	//http://localhost:8080/tsePractico-web/ws?wsdl

	//@WebMethod(operationName="nuevoRecurso")
	public String newRecurso(
			@WebParam(name = "codigo") String codigo,
			@WebParam(name = "precio") int cantidad,
			@WebParam(name = "cantidad") double precio,
			//@WebParam(name = "tipoRecurso") String tipoRecurso
			@XmlElement(required=true, nillable=false, name="tipoRecurso"
			//, namespace="tipoRecurso"
			) String tipoRecurso
			) {
		try {
		data.newRecurso(codigo, precio, cantidad, tipoRecurso);
			return "success";
		} catch(Exception e){
			return "error";
		}
	}

	
	@WebMethod(operationName="listarRecursos")
	 public List<Recurso> listarRecursos() {
		try {
			return data.getRecursos();
			} catch(Exception e){
				return null;
			}
	 }

	@WebMethod(operationName="listarTRecursos")
	public List<TipoRecurso> listarTiposRecursos(){
		try {
			return data.getTipoRecursos();
		} catch(Exception e){
			return null;
		}
	}
	
	@WebMethod(operationName="listarRecursosTRecurso")
	public List<Recurso> listarRecursoTipoRecurso(String nombre){
		try {
			return data.getRecursoTipoRecurso(nombre);
		} catch(Exception e){
			return null;
		}
	}
}
