package ec.gob.educacion.model.ministerio;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.gob.educacion.model.ministerio.InsRegAniLec;

/**
 * InsIncAnioLectivo - desarrollo.
 */
@Entity
@Table(name = "INS_INC_ANIO_LECTIVO")
@NamedQuery(name="InsIncAnioLectivo.findAll", query="SELECT i FROM InsIncAnioLectivo i")

public class InsIncAnioLectivo implements Serializable {
	private static final long serialVersionUID = 1L;

	private long codigo;
	private int anioInicio;
	private int anioFin;
	private String estado;
	private List<InsRegAniLec> insRegAniLecs = new ArrayList<InsRegAniLec>(0);
	
	//sacara el anio lectivo concatenado
	private String anioLectivo ;
	private String descripcion;

	public InsIncAnioLectivo() {
	}

	public InsIncAnioLectivo(long codigo, int anioInicio, int anioFin) {
		this.codigo = codigo;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
	}

	public InsIncAnioLectivo(long codigo, int anioInicio,
			int anioFin, String estado, List<InsRegAniLec> insRegAniLecs) {
		this.codigo = codigo;
		this.anioInicio = anioInicio;
		this.anioFin = anioFin;
		this.estado = estado;
		this.insRegAniLecs = insRegAniLecs;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@SequenceGenerator(name="INS_INC_ANIO_LECTIVO_CODIGO_GENERATOR", sequenceName="SEQ_INS_INC_ANIO_LECTIVO", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INS_INC_ANIO_LECTIVO_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "ANIO_INICIO", nullable = false, precision = 4, scale = 0)
	public int getAnioInicio() {
		return this.anioInicio;
	}

	public void setAnioInicio(int anioInicio) {
		this.anioInicio = anioInicio;
	}

	@Column(name = "ANIO_FIN", nullable = false, precision = 4, scale = 0)
	public int getAnioFin() {
		return this.anioFin;
	}

	public void setAnioFin(int anioFin) {
		this.anioFin = anioFin;
	}

	@Column(name = "ESTADO", length = 1)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insIncAnioLectivo")
	public List<InsRegAniLec> getInsRegAniLecs() {
		return this.insRegAniLecs;
	}

	public void setInsRegAniLecs(List<InsRegAniLec> insRegAniLecs) {
		this.insRegAniLecs = insRegAniLecs;
	}

	/**
	 * @return the anioLectivo
	 */
	@Transient
	public String getAnioLectivo() {
		return anioLectivo;
	}

	/**
	 * @param anioLectivo the anioLectivo to set
	 */
	public void setAnioLectivo(String anioLectivo) {
		this.anioLectivo = anioLectivo;
	}

	@Transient
	public String getDescripcion() {
		descripcion = anioInicio + " - " + anioFin;
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
