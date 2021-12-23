package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INS_PAIS database table.
 * 
 */
@Entity
@Table(name="INS_PAIS")
@NamedQuery(name="InsPais.findAll", query="SELECT i FROM InsPais i")
public class InsPais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigo;

	private String descripcion;

	public InsPais() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}