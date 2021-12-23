package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INS_ETNIA database table.
 * 
 */
@Entity
@Table(name="INS_ETNIA")
@NamedQuery(name="InsEtnia.findAll", query="SELECT i FROM InsEtnia i")
public class InsEtnia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigo;

	private String descripcion;

	public InsEtnia() {
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