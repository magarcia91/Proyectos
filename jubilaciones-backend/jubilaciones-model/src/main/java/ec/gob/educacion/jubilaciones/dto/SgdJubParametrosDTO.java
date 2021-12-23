package ec.gob.educacion.jubilaciones.dto;

import java.math.BigDecimal;

public class SgdJubParametrosDTO {
	
	private Long parcod;
	private BigDecimal paredad;
	private BigDecimal parminaportaciones;
	private BigDecimal partiemposervicio;
	private String partipodiscapacidad;
	private String partipojubilacion;
	private String nombreTipoJubilacion;
	private String nombreTipoDiscapacidad;
		
	public SgdJubParametrosDTO() {
		
	}
	
	public Long getParcod() {
		return parcod;
	}
	public void setParcod(Long parcod) {
		this.parcod = parcod;
	}
	public BigDecimal getParedad() {
		return paredad;
	}
	public void setParedad(BigDecimal paredad) {
		this.paredad = paredad;
	}
	public BigDecimal getParminaportaciones() {
		return parminaportaciones;
	}
	public void setParminaportaciones(BigDecimal parminaportaciones) {
		this.parminaportaciones = parminaportaciones;
	}
	public BigDecimal getPartiemposervicio() {
		return partiemposervicio;
	}
	public void setPartiemposervicio(BigDecimal partiemposervicio) {
		this.partiemposervicio = partiemposervicio;
	}
	public String getPartipodiscapacidad() {
		return partipodiscapacidad;
	}
	public void setPartipodiscapacidad(String partipodiscapacidad) {
		this.partipodiscapacidad = partipodiscapacidad;
	}
	public String getPartipojubilacion() {
		return partipojubilacion;
	}
	public void setPartipojubilacion(String partipojubilacion) {
		this.partipojubilacion = partipojubilacion;
	}

	public String getNombreTipoJubilacion() {
		return nombreTipoJubilacion;
	}

	public void setNombreTipoJubilacion(String nombreTipoJubilacion) {
		this.nombreTipoJubilacion = nombreTipoJubilacion;
	}

	public String getNombreTipoDiscapacidad() {
		return nombreTipoDiscapacidad;
	}

	public void setNombreTipoDiscapacidad(String nombreTipoDiscapacidad) {
		this.nombreTipoDiscapacidad = nombreTipoDiscapacidad;
	}
	
	
}
