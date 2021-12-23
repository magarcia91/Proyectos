package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the INS_GRADO database table
 */
@Entity
@Table(name = "INS_GRADO")
@SequenceGenerator(name = "SEQ_INS_GRADO_GEN", sequenceName = "SEQ_INS_GRADO", allocationSize = 1)
public class InsGrado implements Serializable {

	private static final long serialVersionUID = 8649066220726203757L;
	
	private long codigo;
	private Long codNivel;
	private String descripcion;
	private String nemonico;
	private Date fechaCreacion;
	private int estado;
	private Integer mostrarGrado;

	public InsGrado() {
	}

	public InsGrado(long codigo, Long codNivel, String descripcion,
			String nemonico, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.codNivel = codNivel;
		this.descripcion = descripcion;
		this.nemonico = nemonico;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_GRADO_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "COD_NIVEL")
	public Long getCodNivel() {
		return this.codNivel;
	}

	public void setCodNivel(Long codNivel) {
		this.codNivel = codNivel;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 60)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "NEMONICO", nullable = false, length = 60)
	public String getNemonico() {
		return this.nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
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

	@Column(name = "MOSTRAR_GRADO")
	public Integer getMostrarGrado() {
		return mostrarGrado;
	}

	public void setMostrarGrado(Integer mostrarGrado) {
		this.mostrarGrado = mostrarGrado;
	}

}
