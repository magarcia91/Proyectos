package ec.gob.educacion.model.ministerio;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * InsNivel - VIMEWorks Cia. Ltda.
 */
@Entity
@Table(name = "INS_NIVEL")
@SequenceGenerator(name = "SEQ_INS_NIVEL_GEN", sequenceName = "SEQ_INS_NIVEL", allocationSize = 1)

public class InsNivel implements Serializable {

	private static final long serialVersionUID = 3124399636081546523L;
	
	private long codigo;
	private InsTipoNivel insTipoNivel;
	private InsNivel insNivel;
	private String descripcion;
	private String nemonico;
	private Date fechaCreacion;
	private int estado;
	
	private List<InsGrado> insGrados = new ArrayList<InsGrado>(0);
	private List<InsNivel> insNivels = new ArrayList<InsNivel>(0);
	private List<InsEspecialidad> insEspecialidads = new ArrayList<InsEspecialidad>(0);

	public InsNivel() {
	}

	public InsNivel(long codigo, String descripcion, String nemonico,
			Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nemonico = nemonico;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsNivel(long codigo, InsTipoNivel insTipoNivel,
			InsNivel insNivel, String descripcion, String nemonico,
			Date fechaCreacion, int estado, List<InsGrado> insGrados,
			List<InsNivel> insNivels, List<InsEspecialidad> insEspecialidads) {
		this.codigo = codigo;
		this.insTipoNivel = insTipoNivel;
		this.insNivel = insNivel;
		this.descripcion = descripcion;
		this.nemonico = nemonico;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insGrados = insGrados;
		this.insNivels = insNivels;
		this.insEspecialidads = insEspecialidads;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_NIVEL_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TIPO_NIVEL")
	public InsTipoNivel getInsTipoNivel() {
		return this.insTipoNivel;
	}

	public void setInsTipoNivel(InsTipoNivel insTipoNivel) {
		this.insTipoNivel = insTipoNivel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_NIVEL")
	public InsNivel getInsNivel() {
		return this.insNivel;
	}

	public void setInsNivel(InsNivel insNivel) {
		this.insNivel = insNivel;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insNivel")
	public List<InsGrado> getInsGrados() {
		return this.insGrados;
	}

	public void setInsGrados(List<InsGrado> insGrados) {
		this.insGrados = insGrados;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insNivel")
	public List<InsNivel> getInsNivels() {
		return this.insNivels;
	}

	public void setInsNivels(List<InsNivel> insNivels) {
		this.insNivels = insNivels;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insNivel")
	public List<InsEspecialidad> getInsEspecialidads() {
		return this.insEspecialidads;
	}

	public void setInsEspecialidads(List<InsEspecialidad> insEspecialidads) {
		this.insEspecialidads = insEspecialidads;
	}
}