package datosJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionSingleton {
	private static SessionSingleton instancia = null;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	SessionSingleton() {
		super();
	}
	
	public static SessionSingleton getInstancia() {
		if(instancia==null) {
			System.out.println("hola mudno sesion");
				instancia = new SessionSingleton();
				System.out.println("hola mudno sesio2n");
				
				emf = Persistence.createEntityManagerFactory("Conexion");
				System.out.println("hola mudno sesio3n");
				em = emf.createEntityManager();
				em.getTransaction().begin();
		}
		return instancia;
	}
	
	public EntityManager getEm() {
		return em;
	}
	

}
