package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the INS_INSCRIPCION database table.
 * 
 */
@Entity
@Table(name="INS_INSCRIPCION")
@SequenceGenerator(name = "SEQ_INS_INSCRIPCION_GEN", sequenceName = "SEQ_INS_INSCRIPCION", allocationSize = 1)

public class InsInscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(generator = "SEQ_INS_INSCRIPCION_GEN", strategy = GenerationType.SEQUENCE)
	@Column(name="CODIGO", unique = true, nullable = false, precision = 10, scale = 0)
	private long codigo;

	@Column(name="ANIO_NO_REGISTRO")
	private int anioNoRegistro;

	@Column(name="COD_TIPO_INGRESO")
	private BigDecimal codTipoIngreso;

	@Column(name="COD_TIPO_INSCRIPCION_HERMANOS")
	private BigDecimal codTipoInscripcionHermanos;

	@Column(name="COD_TIPO_PROCESO")
	private Integer codTipoProceso;

	@Column(name="CODIGO_SEDE")
	private String codigoSede;

	@Column(name="DIRECCION_NO_REGISTRO")
	private String direccionNoRegistro;

	@Column(name="DIRECCION_REFERENCIAL")
	private String direccionReferencial;

	private String estado;

	@Column(name="ESTADO_INSCRIPCION")
	private String estadoInscripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA")
	private Date fecha;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_EDICION")
	private Date fechaEdicion;
	
	@Column(name="REGISTRO_ENVIADO")
	private int registroEnviado;

	private String geoval;

	@Column(name="INSTITUCION_EDUCATIVA")
	private BigDecimal institucionEducativa;

	@Column(name="PROCESO_ENVIADO")
	private String procesoEnviado;

	private String queja;

	@Column(name="REGISTRA_MATRICULA")
	private String registraMatricula;


	@Column(name="SECUENCIAL_SEDE", nullable = true, precision = 10, scale = 0)
	private long secuencialSede;

	@Column(name="TIPO_INGRESO")
	private BigDecimal tipoIngreso;

	private String validacion;

	@Column(name="USUARIO")
	private String usuario;

	//bi-directional many-to-one association to InsIncRegAniLec
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="COD_INC_REG_ANI_LEC")
	private InsIncRegAniLec insIncRegAniLec;

	//bi-directional many-to-one association to InsInstitucionSelec
//	@OneToMany(mappedBy="insInscripcions")
//	private List<InsInstitucionSeleccionada> insInstitucionSeleccionadas;

	//bi-directional many-to-one association to InsRegistroEstudiante
	@OneToMany(mappedBy="insInscripcion", fetch=FetchType.LAZY)
	private List<InsRegistroEstudiante> insRegistroEstudiantes;

	//bi-directional many-to-one association to InsRepresentante
//	@OneToMany(mappedBy="insInscripcion")
//	private List<InsRepresentante> insRepresentantes;

	//bi-directional many-to-one association to InsUbicacion
//	@OneToMany(mappedBy="insInscripcion")
//	private List<InsUbicacion> insUbicacions;

	public InsInscripcion() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getAnioNoRegistro() {
		return this.anioNoRegistro;
	}

	public void setAnioNoRegistro(int anioNoRegistro) {
		this.anioNoRegistro = anioNoRegistro;
	}

	public BigDecimal getCodTipoIngreso() {
		return this.codTipoIngreso;
	}

	public void setCodTipoIngreso(BigDecimal codTipoIngreso) {
		this.codTipoIngreso = codTipoIngreso;
	}

	public BigDecimal getCodTipoInscripcionHermanos() {
		return this.codTipoInscripcionHermanos;
	}

	public void setCodTipoInscripcionHermanos(BigDecimal codTipoInscripcionHermanos) {
		this.codTipoInscripcionHermanos = codTipoInscripcionHermanos;
	}

	public Integer getCodTipoProceso() {
		return this.codTipoProceso;
	}

	public void setCodTipoProceso(Integer codTipoProceso) {
		this.codTipoProceso = codTipoProceso;
	}

	public String getCodigoSede() {
		return this.codigoSede;
	}

	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}

	public String getDireccionNoRegistro() {
		return this.direccionNoRegistro;
	}

	public void setDireccionNoRegistro(String direccionNoRegistro) {
		this.direccionNoRegistro = direccionNoRegistro;
	}

	public String getDireccionReferencial() {
		return this.direccionReferencial;
	}

	public void setDireccionReferencial(String direccionReferencial) {
		this.direccionReferencial = direccionReferencial;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoInscripcion() {
		return this.estadoInscripcion;
	}

	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaEdicion() {
		return this.fechaEdicion;
	}

	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public String getGeoval() {
		return this.geoval;
	}

	public void setGeoval(String geoval) {
		this.geoval = geoval;
	}

	public BigDecimal getInstitucionEducativa() {
		return this.institucionEducativa;
	}

	public void setInstitucionEducativa(BigDecimal institucionEducativa) {
		this.institucionEducativa = institucionEducativa;
	}

	public String getProcesoEnviado() {
		return this.procesoEnviado;
	}

	public void setProcesoEnviado(String procesoEnviado) {
		this.procesoEnviado = procesoEnviado;
	}

	public String getQueja() {
		return this.queja;
	}

	public void setQueja(String queja) {
		this.queja = queja;
	}

	public String getRegistraMatricula() {
		return this.registraMatricula;
	}

	public void setRegistraMatricula(String registraMatricula) {
		this.registraMatricula = registraMatricula;
	}

	public int getRegistroEnviado() {
		return this.registroEnviado;
	}

	public void setRegistroEnviado(int registroEnviado) {
		this.registroEnviado = registroEnviado;
	}

	public long getSecuencialSede() {
		return this.secuencialSede;
	}

	public void setSecuencialSede(long secuencialSede) {
		this.secuencialSede = secuencialSede;
	}

	public BigDecimal getTipoIngreso() {
		return this.tipoIngreso;
	}

	public void setTipoIngreso(BigDecimal tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public InsIncRegAniLec getInsIncRegAniLec() {
		return this.insIncRegAniLec;
	}

	public void setInsIncRegAniLec(InsIncRegAniLec insIncRegAniLec) {
		this.insIncRegAniLec = insIncRegAniLec;
	}

//	public List<InsInstitucionSeleccionada> getInsInstitucionSeleccionadas() {
//		return this.insInstitucionSeleccionadas;
//	}
//
//	public void setInsInstitucionSeleccionadas(List<InsInstitucionSeleccionada> insInstitucionSelec) {
//		this.insInstitucionSeleccionadas = insInstitucionSelec;
//	}

	public List<InsRegistroEstudiante> getInsRegistroEstudiantes() {
		return this.insRegistroEstudiantes;
	}

	public void setInsRegistroEstudiantes(List<InsRegistroEstudiante> insRegistroEstudiantes) {
		this.insRegistroEstudiantes = insRegistroEstudiantes;
	}

//	public List<InsRepresentante> getInsRepresentantes() {
//		return this.insRepresentantes;
//	}
//
//	public void setInsRepresentantes(List<InsRepresentante> insRepresentantes) {
//		this.insRepresentantes = insRepresentantes;
//	}
//
//	public List<InsUbicacion> getInsUbicacions() {
//		return this.insUbicacions;
//	}
//
//	public void setInsUbicacions(List<InsUbicacion> insUbicacions) {
//		this.insUbicacions = insUbicacions;
//	}
}