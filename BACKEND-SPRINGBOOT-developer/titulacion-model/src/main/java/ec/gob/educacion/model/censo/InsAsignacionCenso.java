package ec.gob.educacion.model.censo;

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
import javax.persistence.Transient;


import ec.gob.educacion.model.ministerio.InsRegAniLec;
import ec.gob.educacion.model.tit.TitRefrendacion;

/**
 * InsAsignacionCenso - desarrollo.
 */
@Entity
@Table(name = "INS_ASIGNACION_CENSO", schema = "ASIGNACIONES")
@SequenceGenerator(name = "SEQ_INS_ASIGNACION_CENSO_GEN", sequenceName = "SEQ_INS_ASIGNACION_CENSO", allocationSize = 1)

public class InsAsignacionCenso implements Serializable {

	private static final long serialVersionUID = 3559434138995151286L;
	
	private Integer codigo;
	private InsEstudianteCenso insEstudianteCenso;
	private InsRegAniLec insRegAniLec;
	private InsParaleloCenso insParaleloCenso;
	private InsCursoCenso insCursoCenso;
	private Date fechaCreacion;
	private int estado;
	private int tipoProceso;
	private Date fechaProceso;	
	private Long codParaleloEncadenamientoOrigen;
	private String tipoInscripcion;
	private int codigoCasoEspecial;
	private int rezago;
	private int educacionEspecial;
	private int vulnerable;
	private String codigoPostal;
	private int usuarioAtendido;
	private int separadoHermano;
	private int separadoGrupal;
	private int areaRural;
	private Boolean seleccion;

	private List<TitRefrendacion> titRefrendaciones = new ArrayList<TitRefrendacion>(
			0);

	public InsAsignacionCenso() {
	}

	/*public InsAsignacionCenso(Integer codigo,
			InsEstudianteCenso insEstudianteCenso, InsRegAniLec insRegAniLec,
			InsCursoCenso insCursoCenso, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.insEstudianteCenso = insEstudianteCenso;
		this.insRegAniLec = insRegAniLec;
		this.insCursoCenso = insCursoCenso;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsAsignacionCenso(Integer codigo,
			InsEstudianteCenso insEstudianteCenso, InsRegAniLec insRegAniLec,
			InsParaleloCenso insParaleloCenso, InsCursoCenso insCursoCenso,
			Date fechaCreacion, int estado, int tipoProceso,
			Date fechaProceso) {
		this.codigo = codigo;
		this.insEstudianteCenso = insEstudianteCenso;
		this.insRegAniLec = insRegAniLec;
		this.insParaleloCenso = insParaleloCenso;
		this.insCursoCenso = insCursoCenso;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.tipoProceso = tipoProceso;
		this.fechaProceso = fechaProceso;
	}*/

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_ASIGNACION_CENSO_GEN", strategy = GenerationType.SEQUENCE)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_ESTUDIANTE_CENSO", nullable = false)
	public InsEstudianteCenso getInsEstudianteCenso() {
		return this.insEstudianteCenso;
	}

	public void setInsEstudianteCenso(InsEstudianteCenso insEstudianteCenso) {
		this.insEstudianteCenso = insEstudianteCenso;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_REG_ANI_LEC", nullable = false)
	public InsRegAniLec getInsRegAniLec() {
		return this.insRegAniLec;
	}

	public void setInsRegAniLec(InsRegAniLec insRegAniLec) {
		this.insRegAniLec = insRegAniLec;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_PAR_CEN")
	public InsParaleloCenso getInsParaleloCenso() {
		return this.insParaleloCenso;
	}

	public void setInsParaleloCenso(InsParaleloCenso insParaleloCenso) {
		this.insParaleloCenso = insParaleloCenso;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_CURSO_CENSO", nullable = false)
	public InsCursoCenso getInsCursoCenso() {
		return this.insCursoCenso;
	}

	public void setInsCursoCenso(InsCursoCenso insCursoCenso) {
		this.insCursoCenso = insCursoCenso;
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

	@Column(name = "TIPO_PROCESO", precision = 1, scale = 0)
	public int getTipoProceso() {
		return this.tipoProceso;
	}

	public void setTipoProceso(int tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_PROCESO", length = 7)
	public Date getFechaProceso() {
		return this.fechaProceso;
	}

	public void setFechaProceso(Date fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	@Column(name = "COD_PAR_ENCA")
	public Long getCodParaleloEncadenamientoOrigen() {
		return codParaleloEncadenamientoOrigen;
	}

	public void setCodParaleloEncadenamientoOrigen(
			Long codParaleloEncadenamientoOrigen) {
		this.codParaleloEncadenamientoOrigen = codParaleloEncadenamientoOrigen;
	}

	@Transient
	public String getTipoInscripcion() {
		return tipoInscripcion;
	}

	public void setTipoInscripcion(String tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	@Transient
	public int getCodigoCasoEspecial() {
		return codigoCasoEspecial;
	}

	public void setCodigoCasoEspecial(int codigoCasoEspecial) {
		this.codigoCasoEspecial = codigoCasoEspecial;
	}

	@Transient
	public int getRezago() {
		return rezago;
	}

	public void setRezago(int rezago) {
		this.rezago = rezago;
	}

	@Transient
	public int getEducacionEspecial() {
		return educacionEspecial;
	}

	public void setEducacionEspecial(int educacionEspecial) {
		this.educacionEspecial = educacionEspecial;
	}

	@Transient
	public int getVulnerable() {
		return vulnerable;
	}

	public void setVulnerable(int vulnerable) {
		this.vulnerable = vulnerable;
	}

	@Transient
	public Boolean getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

	@Transient
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Transient
	public int getUsuarioAtendido() {
		return usuarioAtendido;
	}

	public void setUsuarioAtendido(int usuarioAtendido) {
		this.usuarioAtendido = usuarioAtendido;
	}

	@Transient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insAsignacionCenso")
	public List<TitRefrendacion> getTitRefrendaciones() {
		return titRefrendaciones;
	}

	public void setTitRefrendaciones(List<TitRefrendacion> titRefrendaciones) {
		this.titRefrendaciones = titRefrendaciones;
	}

	@Transient
	public int getSeparadoHermano() {
		return separadoHermano;
	}

	public void setSeparadoHermano(int separadoHermano) {
		this.separadoHermano = separadoHermano;
	}

	@Transient
	public int getSeparadoGrupal() {
		return separadoGrupal;
	}

	public void setSeparadoGrupal(int separadoGrupal) {
		this.separadoGrupal = separadoGrupal;
	}

	@Transient
	public int getAreaRural() {
		return areaRural;
	}

	public void setAreaRural(int areaRural) {
		this.areaRural = areaRural;
	}
}