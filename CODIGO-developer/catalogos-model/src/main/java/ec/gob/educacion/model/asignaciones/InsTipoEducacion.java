package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the INS_TIPO_EDUCACION database table.
 * 
 */
@Entity
@Table(name="INS_TIPO_EDUCACION")
@NamedQuery(name="InsTipoEducacion.findAll", query="SELECT i FROM InsTipoEducacion i")
public class InsTipoEducacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigo;

	private String descripcion;

	private int estado;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	public InsTipoEducacion() {
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

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}