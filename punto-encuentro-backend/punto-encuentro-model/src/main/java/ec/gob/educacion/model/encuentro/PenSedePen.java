package ec.gob.educacion.model.encuentro;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the PEN_SEDE_PEN database table.
 * 
 */
@Entity
@Table(name="PEN_SEDE_PEN")
@NamedQuery(name="PenSedePen.findAll", query="SELECT p FROM PenSedePen p")
public class PenSedePen implements Serializable {
	private static final long serialVersionUID = 1L;
	private long sedCodigo;
	private String sedCoorx;
	private String sedCoory;
	private String sedDireccion;
	private Integer sedEstado;
	private String sedNombre;
	private List<PenEstudiante> penEstudiantes;

	public PenSedePen() {
	}


	@Id
	@SequenceGenerator(name="PEN_SEDE_PEN_SEDCODIGO_GENERATOR", sequenceName="SEQ_PEN_SEDE_PEN",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PEN_SEDE_PEN_SEDCODIGO_GENERATOR")
	@Column(name="SED_CODIGO")
	public long getSedCodigo() {
		return this.sedCodigo;
	}

	public void setSedCodigo(long sedCodigo) {
		this.sedCodigo = sedCodigo;
	}


	@Column(name="SED_COORX")
	public String getSedCoorx() {
		return this.sedCoorx;
	}

	public void setSedCoorx(String sedCoorx) {
		this.sedCoorx = sedCoorx;
	}


	@Column(name="SED_COORY")
	public String getSedCoory() {
		return this.sedCoory;
	}

	public void setSedCoory(String sedCoory) {
		this.sedCoory = sedCoory;
	}


	@Column(name="SED_DIRECCION")
	public String getSedDireccion() {
		return this.sedDireccion;
	}

	public void setSedDireccion(String sedDireccion) {
		this.sedDireccion = sedDireccion;
	}


	@Column(name="SED_ESTADO")
	public Integer getSedEstado() {
		return this.sedEstado;
	}

	public void setSedEstado(Integer sedEstado) {
		this.sedEstado = sedEstado;
	}


	@Column(name="SED_NOMBRE")
	public String getSedNombre() {
		return this.sedNombre;
	}

	public void setSedNombre(String sedNombre) {
		this.sedNombre = sedNombre;
	}


	//bi-directional many-to-one association to PenEstudiante
	@JsonIgnore
	@OneToMany(mappedBy="penSedePen")
	public List<PenEstudiante> getPenEstudiantes() {
		return this.penEstudiantes;
	}

	public void setPenEstudiantes(List<PenEstudiante> penEstudiantes) {
		this.penEstudiantes = penEstudiantes;
	}

	public PenEstudiante addPenEstudiante(PenEstudiante penEstudiante) {
		getPenEstudiantes().add(penEstudiante);
		penEstudiante.setPenSedePen(this);

		return penEstudiante;
	}

	public PenEstudiante removePenEstudiante(PenEstudiante penEstudiante) {
		getPenEstudiantes().remove(penEstudiante);
		penEstudiante.setPenSedePen(null);

		return penEstudiante;
	}

}