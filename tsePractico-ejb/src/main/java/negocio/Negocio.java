package negocio;


import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datos.Datos;
import datosJPA.DatosJPA;

/**
 * Session Bean implementation class Negocio
 */
@Stateless
@LocalBean
public class Negocio implements NegocioRemote, NegocioLocal {
	
	//static Datos dataL = new Datos();
	static DatosJPA dataJPA = new DatosJPA();

    public Negocio() {
        // TODO Auto-generated constructor stub
    }
    
    public void newRecurso(String codigo, double precioUnitario, int cantidad, String tipoRecurso) {
    	//TipoRecurso _tiporecurso = dataL.consultaTipoRecurso(tipoRecurso);
    	TipoRecurso _tiporecurso = dataJPA.consultaTipoRecurso(tipoRecurso);
    	if (_tiporecurso != null) {
    	Recurso nuevo = new Recurso(codigo, precioUnitario, cantidad, _tiporecurso);
    	//dataL.addRecurso(nuevo);
    	dataJPA.addRecurso(nuevo);
    	System.out.println("*Recurso creado*");
    	}
    	else System.out.println("El tipo de recurso ingresado no existe, intentenlo nuevamente");
    }
    
    //Función para servicio REST
    public void addRecursoREST(Recurso recurso) {
    	dataJPA.addRecursoREST(recurso);
    }
    
    
    public List<TipoRecurso> getTipoRecursos() {
    	//return dataL.getTipoRecursos();
		 return dataJPA.getTipoRecursos();
    }
    
    public List<Recurso> getRecursos() {
    	//return dataL.getRecursos();
    	return dataJPA.getRecursos();
    }
    
    public List<Recurso> getRecursoTipoRecurso(String nombre) {
    	//return dataL.recursosTipoRecurso(nombre);
    	return dataJPA.recursosTipoRecurso(nombre);
    }
    
    
    public boolean precioMaximo(String nombre, double precio) {
    	//TipoRecurso _tiporecurso = dataL.consultaTipoRecurso(nombre);
    	TipoRecurso _tiporecurso = dataJPA.consultaTipoRecurso(nombre);
    	
    		double tenporcent = (_tiporecurso.getPrecioReferencia()*0.10);
    		double maxPrecio = _tiporecurso.getPrecioReferencia()+tenporcent;
    		if ( precio > maxPrecio )
    			return false;
    		
    		else return true;
    	}
    
    public boolean consultaTRecurso(String nombre) {
    	//if( dataL.consultaTipoRecurso(nombre)!= null ) return true;
    	if( dataJPA.consultaTipoRecurso(nombre)!= null ) return true;
    	else return false;
	
    }
    



}

