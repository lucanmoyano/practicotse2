package negocio;

import java.util.List;

import javax.ejb.Local;

@Local
public interface NegocioLocal {
	public abstract void newRecurso(String codigo, double precioUnitario, int cantidad, String tipoRecurso);
	public abstract List<TipoRecurso> getTipoRecursos();
	public abstract List<Recurso> getRecursos();
	public abstract List<Recurso> getRecursoTipoRecurso(String nombre);
	public abstract boolean precioMaximo(String nombre, double precio);
	public abstract boolean consultaTRecurso(String nombre);
	public abstract void addRecursoREST(Recurso recurso);
}
