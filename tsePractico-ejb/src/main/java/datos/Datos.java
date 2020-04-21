package datos;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import negocio.Recurso;
import negocio.TipoRecurso;

/**
 * Session Bean implementation class Datos
 */
@Singleton
@LocalBean
public class Datos implements DatosRemote, DatosLocal {

	private List<Recurso> listaRecursos = new ArrayList<Recurso>();
	private List<TipoRecurso> listaTipoRecursos = new ArrayList<TipoRecurso>();
    /**
     * Default constructor. 
     */
    public Datos() {
    	datosPrueba();
        // TODO Auto-generated constructor stub
    }
    
    public void addRecurso(Recurso recurso) {
    	listaRecursos.add(recurso);
    }
    
    public List<Recurso> getRecursos(){
    	return listaRecursos;
    }
    
    public void addTipoRecurso(TipoRecurso tipoRecurso){
    	listaTipoRecursos.add(tipoRecurso);
    }
    
    public List<TipoRecurso> getTipoRecursos(){
    	return listaTipoRecursos;
    }
    
    public TipoRecurso consultaTipoRecurso(String nombre) {
		Iterator<TipoRecurso> it = listaTipoRecursos.iterator();		
		TipoRecurso tRecurso = null;
		
		while (it.hasNext() && tRecurso==null) {
			TipoRecurso aux = it.next();
			if(aux.getNombre().equals(nombre)) {
				tRecurso = aux;
			}
		}
		return tRecurso; //null == no existe tiporecurso
	}
    
    
    public List<Recurso> recursosTipoRecurso(String nombre) {
    	Iterator<Recurso> it = listaRecursos.iterator();
    	List<Recurso> aux = new ArrayList<Recurso>();
    	System.out.println("entre data ");
    	while (it.hasNext()) {
    		Recurso i = it.next();
			if(i.getTipoRecurso().getNombre().equals(nombre)) {	
				aux.add(i);
			}
		}
    	return aux;
    }
    

    public void datosPrueba() {
    	TipoRecurso uno = new TipoRecurso("uno","tipo recurso uno", 1000 );
    	TipoRecurso dos = new TipoRecurso("dos","tipo recurso dos", 2000 );
    	TipoRecurso tres = new TipoRecurso("tres","tipo recurso tres", 3000 );
    	
    	listaTipoRecursos.add(uno);
    	listaTipoRecursos.add(dos);
    	listaTipoRecursos.add(tres);
    	
    	System.out.println("Datos de prueba cargados con éxito");
    	
    }
}