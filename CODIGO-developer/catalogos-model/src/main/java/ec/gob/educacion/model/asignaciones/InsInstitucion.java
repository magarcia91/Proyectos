package ec.gob.educacion.model.asignaciones;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * InsInstitucion - desarrollo.
 */
@Entity
@Table(name = "INS_INSTITUCION")
@SequenceGenerator(name = "SEQ_INS_INSTITUCION_GEN", sequenceName = "SEQ_INS_INSTITUCION", allocationSize = 1)

public class InsInstitucion implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String amie;
	private String descripcion;
	private String dpaParroquia;
	private Date fechaCreacion;
	private int estado;
	private String estadoPres;
	private String codigoPostal;
	private Long regimen;
	private Integer urbano;
	private List<InsRegAniLecIns> insRegAniLecInses = new ArrayList<InsRegAniLecIns>(0);
	private List<InsCursoCenso> insCursoCensos = new ArrayList<InsCursoCenso>(0);
	private Boolean seleccion;

	public InsInstitucion() {
	}

	/*public InsInstitucion(Integer codigo, String amie, String descripcion,
			Date fechaCreacion, int estado, String codigoPostal) {
		this.codigo = codigo;
		this.amie = amie;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
	}

	public InsInstitucion(Integer codigo, 
			String amie,
			String descripcion, String dpaParroquia, Date fechaCreacion,
			int estado, String estadoPres, String codigoPostal,
			List<InsRegAniLecIns> insRegAniLecInses) {
		this.codigo = codigo;
		this.amie = amie;
		this.descripcion = descripcion;
		this.dpaParroquia = dpaParroquia;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.estadoPres = estadoPres;
		this.insRegAniLecInses = insRegAniLecInses;
		this.codigoPostal = codigoPostal;
	}*/

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, scale = 0)
	@GeneratedValue(generator = "SEQ_INS_INSTITUCION_GEN", strategy = GenerationType.SEQUENCE)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(name = "AMIE", nullable = false, length = 8)
	public String getAmie() {
		return this.amie;
	}

	public void setAmie(String amie) {
		this.amie = amie;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 200)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "DPA_PARROQUIA")
	public String getDpaParroquia() {
		return this.dpaParroquia;
	}

	public void setDpaParroquia(String dpaParroquia) {
		this.dpaParroquia = dpaParroquia;
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

	@Column(name = "ESTADO_PRES", length = 1)
	public String getEstadoPres() {
		return this.estadoPres;
	}

	public void setEstadoPres(String estadoPres) {
		this.estadoPres = estadoPres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insInstitucion")
	@JsonIgnore
	public List<InsRegAniLecIns> getInsRegAniLecInses() {
		return this.insRegAniLecInses;
	}

	public void setInsRegAniLecInses(List<InsRegAniLecIns> insRegAniLecInses) {
		this.insRegAniLecInses = insRegAniLecInses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "insInstitucion")
	@JsonIgnore
	public List<InsCursoCenso> getInsCursoCensos() {
		return this.insCursoCensos;
	}

	public void setInsCursoCensos(List<InsCursoCenso> insCursoCensos) {
		this.insCursoCensos = insCursoCensos;
	}

	@Column(name = "CODIGO_POSTAL")
	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Column(name = "COD_REGIMEN")
	public Long getRegimen() {
		return regimen;
	}

	public void setRegimen(Long regimen) {
		this.regimen = regimen;
	}

	@Column(name = "URBANO")
	public Integer getUrbano() {
		return urbano;
	}

	public void setUrbano(Integer urbano) {
		this.urbano = urbano;
	}

	@Transient
	public Boolean getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}
}
