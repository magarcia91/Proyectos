package ec.gob.educacion.model.encuentro;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PEN_ESTUDIANTE database table.
 * 
 */
@Entity
@Table(name="PEN_ESTUDIANTE")
@NamedQuery(name="PenEstudiante.findAll", query="SELECT p FROM PenEstudiante p")
public class PenEstudiante implements Serializable {
	private static final long serialVersionUID = 1L;
	private long estCodigo;
	private String estCedula;
	private Integer estComidas;
	private Integer estDiscapacidad;
	private Integer estEstado;
	private Date estFechaCreacion;
	private Date estFechaNacimiento;
	private String estIdentidad;
	private Integer estMatriculado;
	private String estMovil;
	private String estNombre;
	private BigDecimal estPeso;
	private BigDecimal estTalla;
	private Integer estVisitasMedicas;
	private Long graCodigo;
	private Long paiCodigo;
	private Long usuCodigo;
	private List<PenEncuesta> penEncuestas;
	private PenSedePen penSedePen;
	private String estGenero;
	
	private String estMovilidadHumana;
	private Integer nacPais;
	private String estDireccion;
	private String estConectividad;
	private String estCambioVivenda;
	private String estIeCerca;
	

	public PenEstudiante() {
	}


	@Id
	@SequenceGenerator(name="PEN_ESTUDIANTE_ESTCODIGO_GENERATOR", sequenceName="SEQ_PEN_ESTUDIANTE",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEN_ESTUDIANTE_ESTCODIGO_GENERATOR")
	@Column(name="EST_CODIGO")
	public long getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(long estCodigo) {
		this.estCodigo = estCodigo;
	}


	@Column(name="EST_CEDULA")
	public String getEstCedula() {
		return this.estCedula;
	}

	public void setEstCedula(String estCedula) {
		this.estCedula = estCedula;
	}


	@Column(name="EST_COMIDAS")
	public Integer getEstComidas() {
		return this.estComidas;
	}

	public void setEstComidas(Integer estComidas) {
		this.estComidas = estComidas;
	}


	@Column(name="EST_DISCAPACIDAD")
	public Integer getEstDiscapacidad() {
		return this.estDiscapacidad;
	}

	public void setEstDiscapacidad(Integer estDiscapacidad) {
		this.estDiscapacidad = estDiscapacidad;
	}


	@Column(name="EST_ESTADO")
	public Integer getEstEstado() {
		return this.estEstado;
	}

	public void setEstEstado(Integer estEstado) {
		this.estEstado = estEstado;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="EST_FECHA_CREACION")
	public Date getEstFechaCreacion() {
		return this.estFechaCreacion;
	}

	public void setEstFechaCreacion(Date estFechaCreacion) {
		this.estFechaCreacion = estFechaCreacion;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="EST_FECHA_NACIMIENTO")
	public Date getEstFechaNacimiento() {
		return this.estFechaNacimiento;
	}

	public void setEstFechaNacimiento(Date estFechaNacimiento) {
		this.estFechaNacimiento = estFechaNacimiento;
	}


	@Column(name="EST_IDENTIDAD")
	public String getEstIdentidad() {
		return this.estIdentidad;
	}

	public void setEstIdentidad(String estIdentidad) {
		this.estIdentidad = estIdentidad;
	}


	@Column(name="EST_MATRICULADO")
	public Integer getEstMatriculado() {
		return this.estMatriculado;
	}

	public void setEstMatriculado(Integer estMatriculado) {
		this.estMatriculado = estMatriculado;
	}


	@Column(name="EST_MOVIL")
	public String getEstMovil() {
		return this.estMovil;
	}

	public void setEstMovil(String estMovil) {
		this.estMovil = estMovil;
	}


	@Column(name="EST_NOMBRE")
	public String getEstNombre() {
		return this.estNombre;
	}

	public void setEstNombre(String estNombre) {
		this.estNombre = estNombre;
	}


	@Column(name="EST_PESO")
	public BigDecimal getEstPeso() {
		return this.estPeso;
	}

	public void setEstPeso(BigDecimal estPeso) {
		this.estPeso = estPeso;
	}


	@Column(name="EST_TALLA")
	public BigDecimal getEstTalla() {
		return this.estTalla;
	}

	public void setEstTalla(BigDecimal estTalla) {
		this.estTalla = estTalla;
	}


	@Column(name="EST_VISITAS_MEDICAS")
	public Integer getEstVisitasMedicas() {
		return this.estVisitasMedicas;
	}

	public void setEstVisitasMedicas(Integer estVisitasMedicas) {
		this.estVisitasMedicas = estVisitasMedicas;
	}


	@Column(name="GRA_CODIGO")
	public Long getGraCodigo() {
		return this.graCodigo;
	}

	public void setGraCodigo(Long graCodigo) {
		this.graCodigo = graCodigo;
	}


	@Column(name="PAI_CODIGO")
	public Long getPaiCodigo() {
		return this.paiCodigo;
	}

	public void setPaiCodigo(Long paiCodigo) {
		this.paiCodigo = paiCodigo;
	}


	@Column(name="USU_CODIGO")
	public Long getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Long usuCodigo) {
		this.usuCodigo = usuCodigo;
	}


	//bi-directional many-to-one association to PenEncuesta
	@JsonIgnore
	@OneToMany(mappedBy="penEstudiante")
	public List<PenEncuesta> getPenEncuestas() {
		return this.penEncuestas;
	}

	public void setPenEncuestas(List<PenEncuesta> penEncuestas) {
		this.penEncuestas = penEncuestas;
	}

	public PenEncuesta addPenEncuesta(PenEncuesta penEncuesta) {
		getPenEncuestas().add(penEncuesta);
		penEncuesta.setPenEstudiante(this);

		return penEncuesta;
	}

	public PenEncuesta removePenEncuesta(PenEncuesta penEncuesta) {
		getPenEncuestas().remove(penEncuesta);
		penEncuesta.setPenEstudiante(null);

		return penEncuesta;
	}


	//bi-directional many-to-one association to PenSedePen
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="SED_CODIGO")
	public PenSedePen getPenSedePen() {
		return this.penSedePen;
	}

	public void setPenSedePen(PenSedePen penSedePen) {
		this.penSedePen = penSedePen;
	}

	@Column(name="EST_GENERO")
	public String getEstGenero() {
		return estGenero;
	}

	public void setEstGenero(String estGenero) {
		this.estGenero = estGenero;
	}

	@Column(name="EST_MOVILIDAD_HUMANA")
	public String getEstMovilidadHumana() {
		return estMovilidadHumana;
	}


	public void setEstMovilidadHumana(String estMovilidadHumana) {
		this.estMovilidadHumana = estMovilidadHumana;
	}

	@Column(name="NAC_PAIS")
	public Integer getNacPais() {
		return nacPais;
	}


	public void setNacPais(Integer nacPais) {
		this.nacPais = nacPais;
	}

	@Column(name="EST_DIRECCION")
	public String getEstDireccion() {
		return estDireccion;
	}


	public void setEstDireccion(String estDireccion) {
		this.estDireccion = estDireccion;
	}

	@Column(name="EST_CONECTIVIDAD")
	public String getEstConectividad() {
		return estConectividad;
	}


	public void setEstConectividad(String estConectividad) {
		this.estConectividad = estConectividad;
	}

	@Column(name="EST_CAMBIO_VIVIENDA")
	public String getEstCambioVivenda() {
		return estCambioVivenda;
	}


	public void setEstCambioVivenda(String estCambioVivenda) {
		this.estCambioVivenda = estCambioVivenda;
	}

	@Column(name="EST_IE_CERCA")
	public String getEstIeCerca() {
		return estIeCerca;
	}


	public void setEstIeCerca(String estIeCerca) {
		this.estIeCerca = estIeCerca;
	}

}