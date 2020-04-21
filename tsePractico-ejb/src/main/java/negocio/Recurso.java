package negocio;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "recurso")
public class Recurso implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="codigo")
	private String codigo;
	@Column(name="precioUnitario")
	private double precioUnitario;
	@Column(name="cantidad")
	private int cantidad;
	
	@ManyToOne
	private TipoRecurso tipoRecurso;
	
	public Recurso(String codigo, double precioUnitario, int cantidad, TipoRecurso tipoRecurso) {
		super();
		this.codigo = codigo;
		this.precioUnitario = precioUnitario;
		this.cantidad = cantidad;
		this.tipoRecurso = tipoRecurso;
	}
	
	

	public Recurso() {
		super();
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public TipoRecurso getTipoRecurso() {
		return tipoRecurso;
	}

	public void setTipoRecurso(TipoRecurso tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}
	
}

