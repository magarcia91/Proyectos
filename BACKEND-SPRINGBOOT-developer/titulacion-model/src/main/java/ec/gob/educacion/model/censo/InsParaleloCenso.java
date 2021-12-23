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

import ec.gob.educacion.model.ministerio.InsParalelo;

/**
 * InsParaleloCenso - desarrollo.
 */
@Entity
@Table(name = "INS_PARALELO_CENSO", schema = "ASIGNACIONES")
@SequenceGenerator(name = "SEQ_INS_PARALELO_CENSO_GEN", sequenceName = "SEQ_INS_PARALELO_CENSO", allocationSize = 1)

public class InsParaleloCenso implements Serializable {

	private static final long serialVersionUID = -2627595537696003858L;
	
	private long codigo;
	private InsParalelo insParalelo;
	private InsCursoCenso insCursoCenso;
	private long aforo;
	private long numeroBancasActual;
	private long numeroEstudiantes;
	private long disponibilidadProAsiPar;
	private long alumnosEncadenados;
	private long disponibilidadEncadenamiento;
	private String tipoCreacion;
	private Date fechaCreacion;
	private int estado;
	private Boolean seleccion;
	private List<InsAsignacionCenso> insAsignacionCensos = new ArrayList<InsAsignacionCenso>(
			0);
	
	private long aforoActual;
	private long numeroAlumnosEncadenar;

	public InsParaleloCenso() {
	}

	public InsParaleloCenso(long codigo, InsParalelo insParalelo,
			InsCursoCenso insCursoCenso, long aforo, long numeroBancasActual,
			String tipoCreacion, Date fechaCreacion, int estado) {
		this.codigo = codigo;
		this.insParalelo = insParalelo;
		this.insCursoCenso = insCursoCenso;
		this.aforo = aforo;
		this.numeroBancasActual = numeroBancasActual;
		this.tipoCreacion = tipoCreacion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
	}

	public InsParaleloCenso(long codigo, InsParalelo insParalelo,
			InsCursoCenso insCursoCenso, long aforo, long numeroBancasActual,
			long numeroEstudiantes, long disponibilidadProAsiPar,
			long alumnosEncadenados, long disponibilidadEncadenamiento,
			String tipoCreacion, Date fechaCreacion, int estado,
			List<InsAsignacionCenso> insAsignacionCensos) {
		this.codigo = codigo;
		this.insParalelo = insParalelo;
		this.insCursoCenso = insCursoCenso;
		this.aforo = aforo;
		this.numeroBancasActual = numeroBancasActual;
		this.numeroEstudiantes = numeroEstudiantes;
		this.disponibilidadProAsiPar = disponibilidadProAsiPar;
		this.alumnosEncadenados = alumnosEncadenados;
		this.disponibilidadEncadenamiento = disponibilidadEncadenamiento;
		this.tipoCreacion = tipoCreacion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insAsignacionCensos = insAsignacionCensos;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_PARALELO_CENSO_GEN", strategy = GenerationType.SEQUENCE)
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_PARALELO", nullable = false)
	public InsParalelo getInsParalelo() {
		return this.insParalelo;
	}

	public void setInsParalelo(InsParalelo insParalelo) {
		this.insParalelo = insParalelo;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_CUR_CEN", nullable = false)
	public InsCursoCenso getInsCursoCenso() {
		return this.insCursoCenso;
	}

	public void setInsCursoCenso(InsCursoCenso insCursoCenso) {
		this.insCursoCenso = insCursoCenso;
	}

	@Column(name = "AFORO", nullable = false, precision = 10, scale = 0)
	public long getAforo() {
		return this.aforo;
	}

	public void setAforo(long aforo) {
		this.aforo = aforo;
	}

	@Column(name = "NUMERO_BANCAS_ACTUAL", nullable = false, precision = 10, scale = 0)
	public long getNumeroBancasActual() {
		return this.numeroBancasActual;
	}

	public void setNumeroBancasActual(long numeroBancasActual) {
		this.numeroBancasActual = numeroBancasActual;
	}

	@Column(name = "NUMERO_ESTUDIANTES", precision = 10, scale = 0)
	public long getNumeroEstudiantes() {
		return this.numeroEstudiantes;
	}

	public void setNumeroEstudiantes(long numeroEstudiantes) {
		this.numeroEstudiantes = numeroEstudiantes;
	}

	@Column(name = "DISPONIBILIDAD_PRO_ASI_PAR", precision = 10, scale = 0)
	public long getDisponibilidadProAsiPar() {
		return this.disponibilidadProAsiPar;
	}

	public void setDisponibilidadProAsiPar(long disponibilidadProAsiPar) {
		this.disponibilidadProAsiPar = disponibilidadProAsiPar;
	}

	@Column(name = "ALUMNOS_ENCADENADOS", precision = 10, scale = 0)
	public long getAlumnosEncadenados() {
		return this.alumnosEncadenados;
	}

	public void setAlumnosEncadenados(long alumnosEncadenados) {
		this.alumnosEncadenados = alumnosEncadenados;
	}

	@Column(name = "DISPONIBILIDAD_ENCADENAMIENTO", precision = 10, scale = 0)
	public long getDisponibilidadEncadenamiento() {
		return this.disponibilidadEncadenamiento;
	}

	public void setDisponibilidadEncadenamiento(
			long disponibilidadEncadenamiento) {
		this.disponibilidadEncadenamiento = disponibilidadEncadenamiento;
	}

	@Column(name = "TIPO_CREACION", nullable = false, length = 1)
	public String getTipoCreacion() {
		return this.tipoCreacion;
	}

	public void setTipoCreacion(String tipoCreacion) {
		this.tipoCreacion = tipoCreacion;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insParaleloCenso")
	public List<InsAsignacionCenso> getInsAsignacionCensos() {
		return this.insAsignacionCensos;
	}

	public void setInsAsignacionCensos(
			List<InsAsignacionCenso> insAsignacionCensos) {
		this.insAsignacionCensos = insAsignacionCensos;
	}

	@Transient
	public long getAforoActual() {
		return aforoActual;
	}

	public void setAforoActual(long aforoActual) {
		this.aforoActual = aforoActual;
	}

	@Transient
	public Boolean getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

	@Transient
	public long getNumeroAlumnosEncadenar() {
		return numeroAlumnosEncadenar;
	}

	public void setNumeroAlumnosEncadenar(long numeroAlumnosEncadenar) {
		this.numeroAlumnosEncadenar = numeroAlumnosEncadenar;
	}

}
