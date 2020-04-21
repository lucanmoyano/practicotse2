package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_recurso")
public class TipoRecurso implements Serializable{
	@Id
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="precioReferencia")
	private double precioReferencia;
	
	/*@OneToMany(mappedBy = "tipoRecurso",orphanRemoval=true)
	private List<Recurso> recursos = new ArrayList<Recurso>();*/
	
	public TipoRecurso(String nombre, String descripcion, double precioReferencia) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioReferencia = precioReferencia;
	}
	
	public TipoRecurso() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioReferencia() {
		return precioReferencia;
	}
	public void setPrecioReferencia(double precioReferencia) {
		this.precioReferencia = precioReferencia;
	}
	/*public List<Recurso> getRecursos() {
		return recursos;
	}
	
	public void setRecursos(Recurso recurso) {
		this.recursos.add(recurso);
	}*/
	
	
}

