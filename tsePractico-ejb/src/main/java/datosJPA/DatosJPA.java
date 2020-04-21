package datosJPA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import negocio.Recurso;
import negocio.TipoRecurso;

/**
 * Session Bean implementation class DatosJPA
 */
@Singleton
@LocalBean
public class DatosJPA implements DatosJPARemote, DatosJPALocal {
    public DatosJPA() {
    	//datosPrueba(); 
    	//Cargar unica vez, luego comentar
    }
    
    private SessionSingleton s = SessionSingleton.getInstancia();
	private EntityManager em = s.getEm();

    public void addRecurso(Recurso recurso) {
    	em.clear();
    	em.persist(recurso);	
		em.getTransaction().commit();
		em.getTransaction().begin();
    }
    
    
    public void addRecursoREST(Recurso recurso){
    	em.clear();
    	em.persist(recurso);	
		em.getTransaction().commit();
		em.getTransaction().begin();
    }
    
    public List<Recurso> getRecursos(){
    	em.clear();
    	List<Recurso> recursos = em.createQuery("SELECT u FROM Recurso u").getResultList();
    	return  recursos;
    }
    
    public void addTipoRecurso(TipoRecurso tipoRecurso) {
    	em.clear();
    	em.persist(tipoRecurso);	
		em.getTransaction().commit();
		em.getTransaction().begin();
    	
    }
    
    public List<TipoRecurso> getTipoRecursos(){
    	em.clear();
    	List<TipoRecurso> tRecursos = em.createQuery("SELECT u FROM TipoRecurso u").getResultList();
    	return tRecursos;
    }
    
    public TipoRecurso consultaTipoRecurso(String nombre) {
    	em.clear();
    	TipoRecurso tRecurso = null;
    	tRecurso = (TipoRecurso) em.createQuery("SELECT u FROM TipoRecurso u WHERE u.nombre="+"'"+nombre+"'").getSingleResult();
    	return tRecurso;
    }
    

    public List<Recurso> recursosTipoRecurso(String nombre) {
    	em.clear();
    	List<Recurso> recursos = em.createQuery("SELECT u FROM Recurso u WHERE u.tipoRecurso.nombre ="+"'"+nombre+"'").getResultList();
    	return recursos;
    }
    
    
    public void datosPrueba() {
    	TipoRecurso uno = new TipoRecurso("uno","tipo recurso uno", 1000 );
    	TipoRecurso dos = new TipoRecurso("dos","tipo recurso dos", 2000 );
    	TipoRecurso tres = new TipoRecurso("tres","tipo recurso tres", 3000 );
    	
    	addTipoRecurso(uno);
    	addTipoRecurso(dos);
    	addTipoRecurso(tres);
    	
    	System.out.println("Datos de prueba JPA cargados con éxito"); 	   	
    }

}
