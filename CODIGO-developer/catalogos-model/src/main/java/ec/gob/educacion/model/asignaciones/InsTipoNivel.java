package ec.gob.educacion.model.asignaciones;



import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
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

/**
 * InsTipoNivel - VIMEWorks Cia. Ltda.
 */
@Entity
@Table(name = "INS_TIPO_NIVEL")
@SequenceGenerator(name = "SEQ_INS_TIPO_NIVEL_GEN", sequenceName = "SEQ_INS_TIPO_NIVEL", allocationSize = 1)

public class InsTipoNivel implements Serializable {

	private static final long serialVersionUID = 7343027752306785786L;
	
	private long codigo;
	private String descripcion;
	private Date fechaCreacion;
	private int estado;
	private List<InsNivel> insNivels = new ArrayList<InsNivel>(0);

	public InsTipoNivel() {
	}

	public InsTipoNivel(long codigo, String descripcion,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsTipoNivel(long codigo, String descripcion,
			Date fechaCreacion, int estado, List<InsNivel> insNivels) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insNivels = insNivels;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_TIPO_NIVEL_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insTipoNivel")
	public List<InsNivel> getInsNivels() {
		return this.insNivels;
	}

	public void setInsNivels(List<InsNivel> insNivels) {
		this.insNivels = insNivels;
	}

}
