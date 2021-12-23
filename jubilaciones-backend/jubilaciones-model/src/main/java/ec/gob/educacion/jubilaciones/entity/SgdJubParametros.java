package ec.gob.educacion.jubilaciones.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SGD_JUB_PARAMETROS")
@NamedQuery(name = "SgdJubParametros.findAll", query = "SELECT s FROM SgdJubParametros s")
public class SgdJubParametros implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SGD_JUB_PARAMETROS_PARCOD_GENERATOR", sequenceName = "SEQ_SGD_JUB_PARAMETROS", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SGD_JUB_PARAMETROS_PARCOD_GENERATOR")
	@Column(name="PARCOD")
	private Integer parcod;
	@Column(name="PAREDAD")
	private Integer paredad;
	@Column(name="PARMINAPORTACIONES")
	private Integer parminaportaciones;
	@Column(name="PARTIEMPOSERVICIO")
	private Integer partiemposervicio;
	@Column(name="PARTIPODISCAPACIDAD")
	private Integer partipodiscapacidad;
	@Column(name="PARTIPOJUBILACION")
	private Integer partipojubilacion;
	@Column(name="PARESTADO")
	private Integer parestado;
		
	public SgdJubParametros() {
		
	}
	
	public Integer getParcod() {
		return parcod;
	}
	public void setParcod(Integer parcod) {
		this.parcod = parcod;
	}
	public Integer getParedad() {
		return paredad;
	}
	public void setParedad(Integer paredad) {
		this.paredad = paredad;
	}
	public Integer getParminaportaciones() {
		return parminaportaciones;
	}
	public void setParminaportaciones(Integer parminaportaciones) {
		this.parminaportaciones = parminaportaciones;
	}
	public Integer getPartiemposervicio() {
		return partiemposervicio;
	}
	public void setPartiemposervicio(Integer partiemposervicio) {
		this.partiemposervicio = partiemposervicio;
	}
	public Integer getPartipodiscapacidad() {
		return partipodiscapacidad;
	}
	public void setPartipodiscapacidad(Integer partipodiscapacidad) {
		this.partipodiscapacidad = partipodiscapacidad;
	}
	public Integer getPartipojubilacion() {
		return partipojubilacion;
	}
	public void setPartipojubilacion(Integer partipojubilacion) {
		this.partipojubilacion = partipojubilacion;
	}
	public Integer getParestado() {
		return parestado;
	}
	public void setParestado(Integer parestado) {
		this.parestado = parestado;
	}
	
	
}
