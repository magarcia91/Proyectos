package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * InsJornada - desarrollo.
 */
@Entity
@Table(name = "INS_JORNADA")
@SequenceGenerator(name = "SEQ_INS_JORNADA_GEN", sequenceName = "SEQ_INS_JORNADA", allocationSize = 1)

public class InsJornada implements Serializable {

	private static final long serialVersionUID = -2244193817715084642L;
	
	private Integer codigo;
	private String descripcion;
	private Date fechaCreacion;
	private int estado;
	private List<InsCursoCenso> insCursoCensos = new ArrayList<InsCursoCenso>(0);

	public InsJornada() {
	}

	/*public InsJornada(Integer codigo, String descripcion,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsJornada(Integer codigo, String descripcion,
			Date fechaCreacion, int estado,
			List<InsCursoCenso> insCursoCensos) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insCursoCensos = insCursoCensos;
	}*/

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_JORNADA_GEN", strategy = GenerationType.SEQUENCE)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CREACION", nullable = false, length = 7)
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Column(name = "ESTADO", nullable = false, precision = 1, scale = 0)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insJornada")
	@JsonIgnore
	public List<InsCursoCenso> getInsCursoCensos() {
		return this.insCursoCensos;
	}

	public void setInsCursoCensos(List<InsCursoCenso> insCursoCensos) {
		this.insCursoCensos = insCursoCensos;
	}
}
