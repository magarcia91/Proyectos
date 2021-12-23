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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * InsEspecialidad - desarrollo.
 */
@Entity
@Table(name = "INS_ESPECIALIDAD")
@SequenceGenerator(name = "SEQ_INS_ESPECIALIDAD_GEN", sequenceName = "SEQ_INS_ESPECIALIDAD", allocationSize = 1)

public class InsEspecialidad implements Serializable {

	private static final long serialVersionUID = 3948254636263684700L;
	
	private long codigo;
	private InsNivel insNivel;
	private String descripcion;
	private String nemonico;
	private Date fechaCreacion;
	private int estado;
	
	private List<InsCursoCenso> insCursoCensos = new ArrayList<InsCursoCenso>(0);

	public InsEspecialidad() {
	}

	public InsEspecialidad(long codigo, 
			InsNivel insNivel,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.insNivel = insNivel;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsEspecialidad(long codigo, 
			InsNivel insNivel,
			String descripcion, String nemonico, Date fechaCreacion,
			int estado, List<InsCursoCenso> insCursoCensos) {
		this.codigo = codigo;
		this.insNivel = insNivel;
		this.descripcion = descripcion;
		this.nemonico = nemonico;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insCursoCensos = insCursoCensos;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_ESPECIALIDAD_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_NIVEL", nullable = false)
	public InsNivel getInsNivel() {
		return this.insNivel;
	}

	public void setInsNivel(InsNivel insNivel) {
		this.insNivel = insNivel;
	}

	@Column(name = "DESCRIPCION", length = 250)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "NEMONICO", length = 60)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insEspecialidad")
	public List<InsCursoCenso> getInsCursoCensos() {
		return this.insCursoCensos;
	}

	public void setInsCursoCensos(List<InsCursoCenso> insCursoCensos) {
		this.insCursoCensos = insCursoCensos;
	}
}
