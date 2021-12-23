package ec.gob.educacion.model.censo;



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
import javax.persistence.Transient;

/**
 * InsEstudianteCenso - desarrollo.
 */
@Entity
@Table(name = "INS_ESTUDIANTE_CENSO" , schema = "ASIGNACIONES")
@SequenceGenerator(name = "SEQ_INS_ESTUDIANTE_CENSO_GEN", sequenceName = "SEQ_INS_ESTUDIANTE_CENSO", allocationSize = 1)

public class InsEstudianteCenso implements Serializable {

	private static final long serialVersionUID = 6911275309977668870L;
	
	private long codigo;
	private String cedula;
	private String nombres;
	private Date fechaNacimiento;
	private String dpaProvincia;
	private String dpaCanton;
	private String dpaParroquia;
	private String direccion;
	private String cedulaRepresentante;
	private String nombreRepresentate;
	private String celularRepresentante;
	private String convencionalRepresentante;
	private String parentesco;
	private String tipoOrigen;
	private int autorepresentado;
	private int estado;
	private long codParentesco;
	private Long codigoInscripcion;
	private Long codigoRegistroEstudiante;
	private String sexo;
	private String sexoRepresentante;
	private String tipoIdentificacion;
	private String tipoIdentificacionRpt;
	private List<InsAsignacionCenso> insAsignacionCensos = new ArrayList<InsAsignacionCenso>(
			0);
	
	private String observacion;
	private boolean deshabilitarOpciones;
	private boolean seleccion;

	public InsEstudianteCenso() {
	}

	public InsEstudianteCenso(long codigo, String nombres,
			Date fechaNacimiento, String dpaProvincia, String dpaCanton,
			String direccion, String celularRepresentante, int estado) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.dpaProvincia = dpaProvincia;
		this.dpaCanton = dpaCanton;
		this.direccion = direccion;
		this.celularRepresentante = celularRepresentante;
		this.estado = estado;
	}

	public InsEstudianteCenso(long codigo, String cedula, String nombres,
			Date fechaNacimiento, String dpaProvincia, String dpaCanton,
			String dpaParroquia, String direccion, String cedulaRepresentante,
			String nombreRepresentate, String celularRepresentante,
			String convencionalRepresentante, String parentesco,
			int autorepresentado, int estado, long codParentesco,
			List<InsAsignacionCenso> insAsignacionCensos) {
		this.codigo = codigo;
		this.cedula = cedula;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.dpaProvincia = dpaProvincia;
		this.dpaCanton = dpaCanton;
		this.dpaParroquia = dpaParroquia;
		this.direccion = direccion;
		this.cedulaRepresentante = cedulaRepresentante;
		this.nombreRepresentate = nombreRepresentate;
		this.celularRepresentante = celularRepresentante;
		this.convencionalRepresentante = convencionalRepresentante;
		this.parentesco = parentesco;
		this.autorepresentado = autorepresentado;
		this.estado = estado;
		this.codParentesco = codParentesco;
		this.insAsignacionCensos = insAsignacionCensos;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_ESTUDIANTE_CENSO_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(name = "CEDULA", length = 10)
	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Column(name = "NOMBRES", nullable = false, length = 150)
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_NACIMIENTO", nullable = false, length = 7)
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "DPA_PROVINCIA", nullable = false)
	public String getDpaProvincia() {
		return this.dpaProvincia;
	}

	public void setDpaProvincia(String dpaProvincia) {
		this.dpaProvincia = dpaProvincia;
	}

	@Column(name = "DPA_CANTON", nullable = false)
	public String getDpaCanton() {
		return this.dpaCanton;
	}

	public void setDpaCanton(String dpaCanton) {
		this.dpaCanton = dpaCanton;
	}

	@Column(name = "DPA_PARROQUIA")
	public String getDpaParroquia() {
		return this.dpaParroquia;
	}

	public void setDpaParroquia(String dpaParroquia) {
		this.dpaParroquia = dpaParroquia;
	}

	@Column(name = "DIRECCION", nullable = false, length = 150)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "CEDULA_REPRESENTANTE", length = 10)
	public String getCedulaRepresentante() {
		return this.cedulaRepresentante;
	}

	public void setCedulaRepresentante(String cedulaRepresentante) {
		this.cedulaRepresentante = cedulaRepresentante;
	}

	@Column(name = "NOMBRE_REPRESENTATE", length = 400)
	public String getNombreRepresentate() {
		return this.nombreRepresentate;
	}

	public void setNombreRepresentate(String nombreRepresentate) {
		this.nombreRepresentate = nombreRepresentate;
	}

	@Column(name = "CELULAR_REPRESENTANTE", nullable = false, length = 10)
	public String getCelularRepresentante() {
		return this.celularRepresentante;
	}

	public void setCelularRepresentante(String celularRepresentante) {
		this.celularRepresentante = celularRepresentante;
	}

	@Column(name = "CONVENCIONAL_REPRESENTANTE", length = 10)
	public String getConvencionalRepresentante() {
		return this.convencionalRepresentante;
	}

	public void setConvencionalRepresentante(String convencionalRepresentante) {
		this.convencionalRepresentante = convencionalRepresentante;
	}

	@Column(name = "PARENTESCO", length = 25)
	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	@Column(name = "AUTOREPRESENTADO", precision = 1, scale = 0)
	public int getAutorepresentado() {
		return this.autorepresentado;
	}

	public void setAutorepresentado(int autorepresentado) {
		this.autorepresentado = autorepresentado;
	}

	@Column(name = "ESTADO", nullable = false, precision = 1, scale = 0)
	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Column(name = "COD_PARENTESCO", scale = 0)
	public long getCodParentesco() {
		return this.codParentesco;
	}

	public void setCodParentesco(long codParentesco) {
		this.codParentesco = codParentesco;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insEstudianteCenso")
	public List<InsAsignacionCenso> getInsAsignacionCensos() {
		return this.insAsignacionCensos;
	}

	public void setInsAsignacionCensos(
			List<InsAsignacionCenso> insAsignacionCensos) {
		this.insAsignacionCensos = insAsignacionCensos;
	}

	@Column(name = "TIPO_ORIGEN", length = 1)
	public String getTipoOrigen() {
		return tipoOrigen;
	}

	public void setTipoOrigen(String tipoOrigen) {
		this.tipoOrigen = tipoOrigen;
	}

	@Column(name = "COD_INSCRIPCION")
	public Long getCodigoInscripcion() {
		return codigoInscripcion;
	}

	public void setCodigoInscripcion(Long codigoInscripcion) {
		this.codigoInscripcion = codigoInscripcion;
	}

	@Column(name = "COD_REGISTRO_ESTUDIANTE")
	public Long getCodigoRegistroEstudiante() {
		return codigoRegistroEstudiante;
	}

	public void setCodigoRegistroEstudiante(Long codigoRegistroEstudiante) {
		this.codigoRegistroEstudiante = codigoRegistroEstudiante;
	}

	@Column(name = "SEXO")
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "SEXO_REPRESENTANTE")
	public String getSexoRepresentante() {
		return sexoRepresentante;
	}

	public void setSexoRepresentante(String sexoRepresentante) {
		this.sexoRepresentante = sexoRepresentante;
	}

	@Column(name = "TIPO_IDENTIFICACION")
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	@Column(name = "TIPO_IDENTIFICACION_RPT")
	public String getTipoIdentificacionRpt() {
		return tipoIdentificacionRpt;
	}

	public void setTipoIdentificacionRpt(String tipoIdentificacionRpt) {
		this.tipoIdentificacionRpt = tipoIdentificacionRpt;
	}

	@Transient
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Transient
	public boolean isDeshabilitarOpciones() {
		return deshabilitarOpciones;
	}

	public void setDeshabilitarOpciones(boolean deshabilitarOpciones) {
		this.deshabilitarOpciones = deshabilitarOpciones;
	}

	@Transient
	public boolean isSeleccion() {
		return seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

}
