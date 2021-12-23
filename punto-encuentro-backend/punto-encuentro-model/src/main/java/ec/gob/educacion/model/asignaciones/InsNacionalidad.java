package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the INS_NACIONALIDAD database table.
 * 
 */
@Entity
@Table(name="INS_NACIONALIDAD")
@NamedQuery(name="InsNacionalidad.findAll", query="SELECT i FROM InsNacionalidad i")
public class InsNacionalidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long codigo;
	
	@Column(name="COD_ETNIA")
	private BigDecimal codEtnia;

	@Column(name="DESCRIPCION")
	private String descripcion;

	private BigDecimal estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_CREACION")
	private Date fechCreacion;

	public InsNacionalidad() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getCodEtnia() {
		return this.codEtnia;
	}

	public void setCodEtnia(BigDecimal codEtnia) {
		this.codEtnia = codEtnia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getEstado() {
		return this.estado;
	}

	public void setEstado(BigDecimal estado) {
		this.estado = estado;
	}

	public Date getFechCreacion() {
		return this.fechCreacion;
	}

	public void setFechCreacion(Date fechCreacion) {
		this.fechCreacion = fechCreacion;
	}

}