package ec.gob.educacion.teletrabajo.DTO;

import java.io.Serializable;

public class CabeceraRegistroDTO implements Serializable {

	private static final long serialVersionUID = 5917892848120438638L;
	private String oferta;
	private String cargo;
	private String institucion;
	private String regimen;
	private Boolean mostrarEncuesta;
	private Long codigoCabeceraRegistro;

	public CabeceraRegistroDTO() {
	}

	public CabeceraRegistroDTO(String oferta, String cargo, String institucion, String regimen, Boolean mostrarEncuesta, Long codigoCabeceraRegistro) {
		this.oferta = oferta;
		this.cargo = cargo;
		this.institucion = institucion;
		this.regimen = regimen;
		this.mostrarEncuesta = mostrarEncuesta;
		this.codigoCabeceraRegistro = codigoCabeceraRegistro;
	}

	public String getOferta() {
		return oferta;
	}

	public String getCargo() {
		return cargo;
	}

	public String getInstitucion() {
		return institucion;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setOferta(String oferta) {
		this.oferta = oferta;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public Boolean getMostrarEncuesta() {
		return mostrarEncuesta;
	}

	public void setMostrarEncuesta(Boolean mostrarEncuesta) {
		this.mostrarEncuesta = mostrarEncuesta;
	}

	public Long getCodigoCabeceraRegistro() {
		return codigoCabeceraRegistro;
	}

	public void setCodigoCabeceraRegistro(Long codigoCabeceraRegistro) {
		this.codigoCabeceraRegistro = codigoCabeceraRegistro;
	}

}
