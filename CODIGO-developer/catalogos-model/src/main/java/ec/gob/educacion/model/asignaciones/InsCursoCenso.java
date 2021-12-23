package ec.gob.educacion.model.asignaciones;



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

/**
 * InsCursoCenso - desarrollo.
 */
@Entity
@Table(name = "INS_CURSO_CENSO")
@SequenceGenerator(name = "SEQ_INS_CURSO_CENSO_GEN", sequenceName = "SEQ_INS_CURSO_CENSO", allocationSize = 1)

public class InsCursoCenso implements Serializable {

	private static final long serialVersionUID = 3317276263431768915L;
	
	private Integer codigo;
	private InsGrado insGrado;
	private InsJornada insJornada;
	private InsEspecialidad insEspecialidad;
	private InsModalidad insModalidad;
	private InsInstitucion insInstitucion;
//	private InsTipoEducacion insTipoEducacion;
	private Long aforo;
	private String tipoCreacion;
	private Date fechaCreacion;
	private int estado;
	private Long cuposDisponibles;
	private Boolean seleccion;
	private List<InsAsignacionCenso> insAsignacionCensos = new ArrayList<InsAsignacionCenso>(
			0);
	private List<InsParaleloCenso> insParaleloCensos = new ArrayList<InsParaleloCenso>(
			0);
	//Variables para el encadenamiento
	private long numeroAlumnosEncadenar;
	private long codigoParaleloCensoOrigen;

	public InsCursoCenso() {
	}

	public InsCursoCenso(Integer codigo, 
			InsGrado insGrado,
			InsJornada insJornada, InsModalidad insModalidad,
			InsInstitucion insInstitucion, String tipoCreacion, Date fechaCreacion, int estado
//			,InsTipoEducacion insTipoEducacion
			) {
		this.codigo = codigo;
//		this.insGrado = insGrado;
		this.insJornada = insJornada;
		this.insModalidad = insModalidad;
		this.insInstitucion = insInstitucion;
		this.tipoCreacion = tipoCreacion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
//		this.insTipoEducacion=insTipoEducacion;
	}

	public InsCursoCenso(Integer codigo, 
			InsGrado insGrado,
			InsJornada insJornada, InsEspecialidad insEspecialidad,
			InsModalidad insModalidad, InsInstitucion insInstitucion,
			Long aforo, String tipoCreacion, Date fechaCreacion, int estado,
			List<InsAsignacionCenso> insAsignacionCensos,
			List<InsParaleloCenso> insParaleloCensos, Long cuposDisponibles
//			,InsTipoEducacion insTipoEducacion
			) {
		this.codigo = codigo;
		this.insGrado = insGrado;
		this.insJornada = insJornada;
		this.insEspecialidad = insEspecialidad;
		this.insModalidad = insModalidad;
		this.insInstitucion = insInstitucion;
		this.aforo = aforo;
		this.tipoCreacion = tipoCreacion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.insAsignacionCensos = insAsignacionCensos;
		this.insParaleloCensos = insParaleloCensos;
		this.cuposDisponibles = cuposDisponibles;
//		this.insTipoEducacion=insTipoEducacion;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_CURSO_CENSO_GEN", strategy = GenerationType.SEQUENCE)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_GRADO", nullable = false)
	public InsGrado getInsGrado() {
		return this.insGrado;
	}

	public void setInsGrado(InsGrado insGrado) {
		this.insGrado = insGrado;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_JORNADA", nullable = false)
	public InsJornada getInsJornada() {
		return this.insJornada;
	}

	public void setInsJornada(InsJornada insJornada) {
		this.insJornada = insJornada;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_ESPECIALIDAD")
	public InsEspecialidad getInsEspecialidad() {
		return this.insEspecialidad;
	}

	public void setInsEspecialidad(InsEspecialidad insEspecialidad) {
		this.insEspecialidad = insEspecialidad;
	}

	@ManyToOne()
	@JoinColumn(name = "COD_MODALIDAD", nullable = false)
	public InsModalidad getInsModalidad() {
		return this.insModalidad;
	}

	public void setInsModalidad(InsModalidad insModalidad) {
		this.insModalidad = insModalidad;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_INSTITUCION")
	public InsInstitucion getInsInstitucion() {
		return this.insInstitucion;
	}

	public void setInsInstitucion(InsInstitucion insInstitucion) {
		this.insInstitucion = insInstitucion;
	}

	@Column(name = "AFORO", precision = 10, scale = 0)
	public Long getAforo() {
		return this.aforo;
	}

	public void setAforo(Long aforo) {
		this.aforo = aforo;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insCursoCenso")
	public List<InsAsignacionCenso> getInsAsignacionCensos() {
		return this.insAsignacionCensos;
	}

	public void setInsAsignacionCensos(
			List<InsAsignacionCenso> insAsignacionCensos) {
		this.insAsignacionCensos = insAsignacionCensos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insCursoCenso")
	public List<InsParaleloCenso> getInsParaleloCensos() {
		return this.insParaleloCensos;
	}

	public void setInsParaleloCensos(List<InsParaleloCenso> insParaleloCensos) {
		this.insParaleloCensos = insParaleloCensos;
	}

	@Column(name = "CUPOS_DISPONIBLES", precision = 10, scale = 0)
	public Long getCuposDisponibles() {
		return cuposDisponibles;
	}

	public void setCuposDisponibles(Long cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}

	@Transient
	public Boolean getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

//	@ManyToOne()
//	@JoinColumn(name = "COD_TIPO_EDUCACION", nullable = false)
//	public InsTipoEducacion getInsTipoEducacion() {
//		return insTipoEducacion;
//	}
//
//	public void setInsTipoEducacion(InsTipoEducacion insTipoEducacion) {
//		this.insTipoEducacion = insTipoEducacion;
//	}

	@Transient
	public long getNumeroAlumnosEncadenar() {
		return numeroAlumnosEncadenar;
	}

	public void setNumeroAlumnosEncadenar(long numeroAlumnosEncadenar) {
		this.numeroAlumnosEncadenar = numeroAlumnosEncadenar;
	}

	@Transient
	public long getCodigoParaleloCensoOrigen() {
		return codigoParaleloCensoOrigen;
	}

	public void setCodigoParaleloCensoOrigen(long codigoParaleloCensoOrigen) {
		this.codigoParaleloCensoOrigen = codigoParaleloCensoOrigen;
	}

}
