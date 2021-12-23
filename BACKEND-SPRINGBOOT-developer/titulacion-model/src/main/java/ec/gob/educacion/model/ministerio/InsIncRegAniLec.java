package ec.gob.educacion.model.ministerio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


import ec.gob.educacion.model.ministerio.InsRegAniLec;

/**
 * InsIncRegAniLec - desarrollo.
 */
@Entity
@Table(name = "INS_INC_REG_ANI_LEC")
@NamedQuery(name="InsIncRegAniLec.findAll", query="SELECT i FROM InsIncRegAniLec i")

public class InsIncRegAniLec implements Serializable {
	private static final long serialVersionUID = 1L;

	private long codigo;
	private InsRegAniLec insRegAniLec;
	private int estado;
	private Date fechaIni;
	private Date fechaFin;
	private String tipoInscripcion;
	private List<InsInscripcion> insInscripcions = new ArrayList<InsInscripcion>(0);
//	private List<InsItemParametro> insItemParametros = new ArrayList<InsItemParametro>(
//			0);
//	private List<InsActivacion> insActivacions = new ArrayList<InsActivacion>(0);
//	private List<InsConvenioActivo> insConvenioActivos = new ArrayList<InsConvenioActivo>(
//			0);
	
	private String temporalTipoInscripcion;

	public InsIncRegAniLec() {
	}

	public InsIncRegAniLec(long codigo, InsRegAniLec insRegAniLec,
			Date fechaIni, Date fechaFin, String tipoInscripcion) {
		this.codigo = codigo;
		this.insRegAniLec = insRegAniLec;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.tipoInscripcion = tipoInscripcion;
	}

	public InsIncRegAniLec(long codigo, InsRegAniLec insRegAniLec,
			int estado, Date fechaIni, Date fechaFin,
			String tipoInscripcion, List<InsInscripcion> insInscripcions
//			List<InsItemParametro> insItemParametros,
//			List<InsActivacion> insActivacions,
//			List<InsConvenioActivo> insConvenioActivos
			) {
		this.codigo = codigo;
		this.insRegAniLec = insRegAniLec;
		this.estado = estado;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.tipoInscripcion = tipoInscripcion;
		this.insInscripcions = insInscripcions;
//		this.insItemParametros = insItemParametros;
//		this.insActivacions = insActivacions;
//		this.insConvenioActivos = insConvenioActivos;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@SequenceGenerator(name="INS_INC_REG_ANI_LEC_CODIGO_GENERATOR", sequenceName="SEQ_INS_INC_REG_ANI_LEC", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INS_INC_REG_ANI_LEC_CODIGO_GENERATOR")
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_REG_ANI_LEC", nullable = false)
	public InsRegAniLec getInsRegAniLec() {
		return this.insRegAniLec;
	}

	public void setInsRegAniLec(InsRegAniLec insRegAniLec) {
		this.insRegAniLec = insRegAniLec;
	}

	@Column(name = "ESTADO", precision = 1, scale = 0)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_INI", nullable = false, length = 7)
	public Date getFechaIni() {
		return this.fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_FIN", nullable = false, length = 7)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "TIPO_INSCRIPCION", nullable = false, length = 2)
	public String getTipoInscripcion() {
		return this.tipoInscripcion;
	}

	public void setTipoInscripcion(String tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insIncRegAniLec", cascade=CascadeType.DETACH)
	public List<InsInscripcion> getInsInscripcions() {
		return this.insInscripcions;
	}

	public void setInsInscripcions(List<InsInscripcion> insInscripcions) {
		this.insInscripcions = insInscripcions;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insIncRegAniLec")
//	public List<InsItemParametro> getInsItemParametros() {
//		return this.insItemParametros;
//	}
//
//	public void setInsItemParametros(List<InsItemParametro> insItemParametros) {
//		this.insItemParametros = insItemParametros;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insIncRegAniLec")
//	public List<InsActivacion> getInsActivacions() {
//		return this.insActivacions;
//	}
//
//	public void setInsActivacions(List<InsActivacion> insActivacions) {
//		this.insActivacions = insActivacions;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insIncRegAniLec")
//	public List<InsConvenioActivo> getInsConvenioActivos() {
//		return this.insConvenioActivos;
//	}
//
//	public void setInsConvenioActivos(List<InsConvenioActivo> insConvenioActivos) {
//		this.insConvenioActivos = insConvenioActivos;
//	}

	
	@Transient
	public String getTemporalTipoInscripcion() {
		return this.temporalTipoInscripcion;
	}

	public void setTemporalTipoInscripcion(String temporalTipoInscripcion) {
		this.temporalTipoInscripcion = temporalTipoInscripcion;
	}

}
