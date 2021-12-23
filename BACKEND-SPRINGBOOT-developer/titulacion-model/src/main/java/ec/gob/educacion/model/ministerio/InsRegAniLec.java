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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.gob.educacion.model.censo.InsAsignacionCenso;

/**
 * InsRegAniLec - desarrollo.
 */
@Entity
@Table(name = "INS_REG_ANI_LEC")
@SequenceGenerator(name = "SEQ_INS_REG_ANI_LEC_GEN", sequenceName = "SEQ_INS_REG_ANI_LEC", allocationSize = 1)

public class InsRegAniLec implements Serializable {

	private static final long serialVersionUID = 830903760195623642L;

	private long codigo;
	private InsIncRegimen insIncRegimen;
	private InsIncAnioLectivo insIncAnioLectivo;
	private int estado;
	private String tipo;
	private List<InsIncRegAniLec> insIncRegAniLecs = new ArrayList<InsIncRegAniLec>(0);
	private List<InsRegAniLecIns> insRegAniLecInses = new ArrayList<InsRegAniLecIns>(0);
	private List<InsAsignacionCenso> insAsignacionCensos = new ArrayList<InsAsignacionCenso>(0);
//	private List<InsItemParametro> insItemParametros = new ArrayList<InsItemParametro>(0);


	public InsRegAniLec() {
	}

	public InsRegAniLec(long codigo, InsIncRegimen insIncRegimen,
			InsIncAnioLectivo insIncAnioLectivo, int estado, String tipo) {
		this.codigo = codigo;
		this.insIncRegimen = insIncRegimen;
		this.insIncAnioLectivo = insIncAnioLectivo;
		this.estado = estado;
		this.tipo = tipo;
	}

	public InsRegAniLec(long codigo, InsIncRegimen insIncRegimen,
			InsIncAnioLectivo insIncAnioLectivo, int estado, String tipo,
			List<InsIncRegAniLec> insIncRegAniLecs,
			List<InsRegAniLecIns> insRegAniLecInses,
			List<InsAsignacionCenso> insAsignacionCensos) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.insIncRegimen = insIncRegimen;
		this.insIncAnioLectivo = insIncAnioLectivo;
		this.estado = estado;
		this.tipo = tipo;
		this.insIncRegAniLecs = insIncRegAniLecs;
		this.insRegAniLecInses = insRegAniLecInses;
		this.insAsignacionCensos = insAsignacionCensos;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_REG_ANI_LEC_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_INC_REGIMEN", nullable = false)
	public InsIncRegimen getInsIncRegimen() {
		return this.insIncRegimen;
	}

	public void setInsIncRegimen(InsIncRegimen insIncRegimen) {
		this.insIncRegimen = insIncRegimen;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_INC_ANIO_LECTIVO", nullable = false)
	public InsIncAnioLectivo getInsIncAnioLectivo() {
		return this.insIncAnioLectivo;
	}

	public void setInsIncAnioLectivo(InsIncAnioLectivo insIncAnioLectivo) {
		this.insIncAnioLectivo = insIncAnioLectivo;
	}

	@Column(name = "ESTADO", nullable = false, precision = 1, scale = 0)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "TIPO", nullable = false, precision = 1, scale = 0)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insRegAniLec")
	public List<InsIncRegAniLec> getInsIncRegAniLecs() {
		return this.insIncRegAniLecs;
	}

	public void setInsIncRegAniLecs(List<InsIncRegAniLec> insIncRegAniLecs) {
		this.insIncRegAniLecs = insIncRegAniLecs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insRegAniLec")
	public List<InsRegAniLecIns> getInsRegAniLecInses() {
		return this.insRegAniLecInses;
	}

	public void setInsRegAniLecInses(List<InsRegAniLecIns> insRegAniLecInses) {
		this.insRegAniLecInses = insRegAniLecInses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insRegAniLec")
	public List<InsAsignacionCenso> getInsAsignacionCensos() {
		return this.insAsignacionCensos;
	}

	public void setInsAsignacionCensos(
			List<InsAsignacionCenso> insAsignacionCensos) {
		this.insAsignacionCensos = insAsignacionCensos;
	}
}
