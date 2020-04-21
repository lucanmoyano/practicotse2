package datos;

import java.util.List;

import javax.ejb.Local;

import negocio.Recurso;
import negocio.TipoRecurso;

@Local
public interface DatosLocal {
	public abstract void addRecurso(Recurso recurso);
	public abstract List<Recurso> getRecursos();
	public abstract void addTipoRecurso(TipoRecurso tipoRecurso);
	public abstract List<TipoRecurso> getTipoRecursos();
	public abstract TipoRecurso consultaTipoRecurso(String nombre);
}
