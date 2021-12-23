package ec.gob.educacion.model.asignaciones;

import java.io.Serializable;
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


/**
 * The persistent class for the INS_REGISTRO_ESTUDIANTE database table.
 * 
 */
@Entity
@Table(name="INS_REGISTRO_ESTUDIANTE")
@SequenceGenerator(name = "SEQ_INS_REGISTRO_ESTUDIANTE_GEN", sequenceName = "SEQ_INS_REGISTRO_ESTUDIANTE", allocationSize = 1)

public class InsRegistroEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQ_INS_REGISTRO_ESTUDIANTE_GEN", strategy = GenerationType.SEQUENCE)
	@Column(name="CODIGO", unique = true, nullable = false, precision = 10, scale = 0)
	private long codigo;

	@Column(name="AMIE_INSTITUCION")
	private String amieInstitucion;

	@Column(name="AMIE_INSTITUCION_HERMANO")
	private String amieInstitucionHermano;

	@Column(name="ANIOS_SIN_ESTUDIO")
	private String aniosSinEstudio;

	private String apellidos;

	@Column(name="CARNET_CONADIS")
	private String carnetConadis;

	@Column(name="CARNET_REFUGIADO")
	private String carnetRefugiado;

	private String cedula;

	private String circuito;

	@Column(name="COD_CASO_ESPECIAL")
	private Integer codCasoEspecial;

	@Column(name="COD_CIRCUITO")
	private String codCircuito;

	@Column(name="COD_DISTRITO")
	private String codDistrito;

	@Column(name="COD_NIVEL_ESTUDIO")
	private String insNivelEstudio;

	@Column(name="COD_SEXO")
	private String codSexo;

	@Column(name="COD_TIPO_INSCRIPCION_HERMANOS")
	private Integer codTipoInscripcionHermanos;

	@Column(name="COD_TIPO_PROCESO")
	private Integer codTipoProceso;

	@Column(name="DIRECCION_REFERENCIAL")
	private String direccionReferencial;

	private String distrito;

	@Column(name="DPA_PARROQUIA")
	private String dpaParroquia;

	private int edad;

	private String estado;

	@Column(name="ESTADO_INSCRIPCION")
	private String estadoInscripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;

	@Column(name="HUERFANO")
	private int huerfano;
	
	@Column(name="EXTRANJERO")
	private Integer extranjero;

	@Column(name="INSTITUCION_EDUCATIVA")
	private String institucionEducativa;

	private String nacionalidad;

	@Column(name="NECESIDAD_EDU_ESPEC")
	private String necesidadEducEspecial;

	private String nombres;

	private Double nota;

	private String observacion;

	@Column(name="PAIS_PROVIENE")
	private long paisProviene;

	@Column(name="PROCESO_ENVIADO")
	private String procesoEnviado;

	private String queja;

	@Column(name="REFUGIADO")
	private String refugiado;

	@Column(name="REGISTRA_MATRICULA")
	private String registraMatricula;

	@Column(name="SELECCION_CIRCUITO")
	private String seleccionCircuito;

	@Column(name="TIPO_INSTITUCION")
	private String tipoInstitucion;

	private String urbano;

	@Column(name="VALIDACION_INFORMACION")
	private String validacionInformacion;

	private String zona;
	
	private int asignacion;
	
	private int rezago;
	
	private String especialidad;
	
	@Column(name="COD_NOTA_DESCARGO")
	private Long codigoNotaDescargo;
	
	@Transient
	private Boolean seleccion;
	
	@Transient
	private Boolean institucionAsignada;
	
	@Transient
	private String tipoInscripcion;

	//bi-directional many-to-one association to InsEnfcatVulnerabilidad
	@OneToMany(fetch=FetchType.LAZY, mappedBy="insRegistroEstudiante")
	private List<InsEnfcatVulnerabilidad> insEnfcatVulnerabilidad;

	//bi-directional many-to-one association to InsInscripcion
	@ManyToOne()
	@JoinColumn(name="COD_INSCRIPCION")
	private InsInscripcion insInscripcion;
	
	@Transient
	private String tipoInscripcionGeneral;
	
	@Transient
	private String tipoInscripcionHermanos;
	
	@Transient
	private String sostenimiento;
	
	@Transient
	private String nombreTemporaltraslado;
	
	@Transient
	private String apellidoTemporalTraslado;
	
	@Transient
	private List<?> listaEnfermedadesCatastroficasSeleccionadas;
	
	@Transient
	private List<?> listaOtrasVulnerabilidadesSeleccionadas;

	public InsRegistroEstudiante() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getAmieInstitucion() {
		return this.amieInstitucion;
	}

	public void setAmieInstitucion(String amieInstitucion) {
		this.amieInstitucion = amieInstitucion;
	}

	public String getAmieInstitucionHermano() {
		return this.amieInstitucionHermano;
	}

	public void setAmieInstitucionHermano(String amieInstitucionHermano) {
		this.amieInstitucionHermano = amieInstitucionHermano;
	}

	public String getAniosSinEstudio() {
		return this.aniosSinEstudio;
	}

	public void setAniosSinEstudio(String aniosSinEstudio) {
		this.aniosSinEstudio = aniosSinEstudio;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCarnetConadis() {
		return this.carnetConadis;
	}

	public void setCarnetConadis(String carnetConadis) {
		this.carnetConadis = carnetConadis;
	}

	public String getCarnetRefugiado() {
		return this.carnetRefugiado;
	}

	public void setCarnetRefugiado(String carnetRefugiado) {
		this.carnetRefugiado = carnetRefugiado;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCircuito() {
		return this.circuito;
	}

	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	public Integer getCodCasoEspecial() {
		return this.codCasoEspecial;
	}

	public void setCodCasoEspecial(Integer codCasoEspecial) {
		this.codCasoEspecial = codCasoEspecial;
	}

	public String getCodCircuito() {
		return this.codCircuito;
	}

	public void setCodCircuito(String codCircuito) {
		this.codCircuito = codCircuito;
	}

	public String getCodDistrito() {
		return this.codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}

	/**
	 * @return the insNivelEstudio
	 */
	public String getInsNivelEstudio() {
		return insNivelEstudio;
	}

	/**
	 * @param insNivelEstudio the insNivelEstudio to set
	 */
	public void setInsNivelEstudio(String insNivelEstudio) {
		this.insNivelEstudio = insNivelEstudio;
	}

	public String getCodSexo() {
		return this.codSexo;
	}

	public void setCodSexo(String codSexo) {
		this.codSexo = codSexo;
	}

	public Integer getCodTipoInscripcionHermanos() {
		return this.codTipoInscripcionHermanos;
	}

	public void setCodTipoInscripcionHermanos(Integer codTipoInscripcionHermanos) {
		this.codTipoInscripcionHermanos = codTipoInscripcionHermanos;
	}

	public Integer getCodTipoProceso() {
		return this.codTipoProceso;
	}

	public void setCodTipoProceso(Integer codTipoProceso) {
		this.codTipoProceso = codTipoProceso;
	}

	public String getDireccionReferencial() {
		return this.direccionReferencial;
	}

	public void setDireccionReferencial(String direccionReferencial) {
		this.direccionReferencial = direccionReferencial;
	}

	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDpaParroquia() {
		return this.dpaParroquia;
	}

	public void setDpaParroquia(String dpaParroquia) {
		this.dpaParroquia = dpaParroquia;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getHuerfano() {
		return huerfano;
	}


	public void setHuerfano(int huerfano) {
		this.huerfano = huerfano;
	}

	public String getInstitucionEducativa() {
		return this.institucionEducativa;
	}

	public void setInstitucionEducativa(String institucionEducativa) {
		this.institucionEducativa = institucionEducativa;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNecesidadEducEspecial() {
		return necesidadEducEspecial;
	}


	public void setNecesidadEducEspecial(String necesidadEducEspecial) {
		this.necesidadEducEspecial = necesidadEducEspecial;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Double getNota() {
		return this.nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public long getPaisProviene() {
		return this.paisProviene;
	}

	public void setPaisProviene(long paisProviene) {
		this.paisProviene = paisProviene;
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

	public String getRefugiado() {
		return refugiado;
	}


	public void setRefugiado(String refugiado) {
		this.refugiado = refugiado;
	}

	public String getRegistraMatricula() {
		return this.registraMatricula;
	}

	public void setRegistraMatricula(String registraMatricula) {
		this.registraMatricula = registraMatricula;
	}

	public String getSeleccionCircuito() {
		return this.seleccionCircuito;
	}

	public void setSeleccionCircuito(String seleccionCircuito) {
		this.seleccionCircuito = seleccionCircuito;
	}

	public String getTipoInstitucion() {
		return this.tipoInstitucion;
	}

	public void setTipoInstitucion(String tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}

	public String getUrbano() {
		return this.urbano;
	}

	public void setUrbano(String urbano) {
		this.urbano = urbano;
	}

	public String getValidacionInformacion() {
		return this.validacionInformacion;
	}

	public void setValidacionInformacion(String validacionInformacion) {
		this.validacionInformacion = validacionInformacion;
	}

	public String getZona() {
		return this.zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public List<InsEnfcatVulnerabilidad> getInsEnfcatVulnerabilidad() {
		return this.insEnfcatVulnerabilidad;
	}

	public void setInsEnfcatVulnerabilidad(List<InsEnfcatVulnerabilidad> insEnfcatVulnerabilidad) {
		this.insEnfcatVulnerabilidad = insEnfcatVulnerabilidad;
	}

	public InsInscripcion getInsInscripcion() {
		return this.insInscripcion;
	}

	public void setInsInscripcion(InsInscripcion insInscripcion) {
		this.insInscripcion = insInscripcion;
	}

	public String getTipoInscripcionGeneral() {
		return tipoInscripcionGeneral;
	}

	public void setTipoInscripcionGeneral(String tipoInscripcionGeneral) {
		this.tipoInscripcionGeneral = tipoInscripcionGeneral;
	}

	public String getTipoInscripcionHermanos() {
		return tipoInscripcionHermanos;
	}

	public void setTipoInscripcionHermanos(String tipoInscripcionHermanos) {
		this.tipoInscripcionHermanos = tipoInscripcionHermanos;
	}

	public String getSostenimiento() {
		return sostenimiento;
	}

	public void setSostenimiento(String sostenimiento) {
		this.sostenimiento = sostenimiento;
	}

	public String getNombreTemporaltraslado() {
		return nombreTemporaltraslado;
	}

	public void setNombreTemporaltraslado(String nombreTemporaltraslado) {
		this.nombreTemporaltraslado = nombreTemporaltraslado;
	}

	public String getApellidoTemporalTraslado() {
		return apellidoTemporalTraslado;
	}

	public void setApellidoTemporalTraslado(String apellidoTemporalTraslado) {
		this.apellidoTemporalTraslado = apellidoTemporalTraslado;
	}

	public int getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(int asignacion) {
		this.asignacion = asignacion;
	}
	
	public Boolean getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

	public Boolean getInstitucionAsignada() {
		return institucionAsignada;
	}

	public void setInstitucionAsignada(Boolean institucionAsignada) {
		this.institucionAsignada = institucionAsignada;
	}

	public String getTipoInscripcion() {
		return tipoInscripcion;
	}

	public void setTipoInscripcion(String tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	public List<?> getListaEnfermedadesCatastroficasSeleccionadas() {
		return listaEnfermedadesCatastroficasSeleccionadas;
	}

	public void setListaEnfermedadesCatastroficasSeleccionadas(
			List<?> listaEnfermedadesCatastroficasSeleccionadas) {
		this.listaEnfermedadesCatastroficasSeleccionadas = listaEnfermedadesCatastroficasSeleccionadas;
	}

	public List<?> getListaOtrasVulnerabilidadesSeleccionadas() {
		return listaOtrasVulnerabilidadesSeleccionadas;
	}

	public void setListaOtrasVulnerabilidadesSeleccionadas(
			List<?> listaOtrasVulnerabilidadesSeleccionadas) {
		this.listaOtrasVulnerabilidadesSeleccionadas = listaOtrasVulnerabilidadesSeleccionadas;
	}

	public int getRezago() {
		return rezago;
	}

	public void setRezago(int rezago) {
		this.rezago = rezago;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Long getCodigoNotaDescargo() {
		return codigoNotaDescargo;
	}

	public void setCodigoNotaDescargo(Long codigoNotaDescargo) {
		this.codigoNotaDescargo = codigoNotaDescargo;
	}

	public Integer getExtranjero() {
		return extranjero;
	}

	public void setExtranjero(Integer extranjero) {
		this.extranjero = extranjero;
	}
}