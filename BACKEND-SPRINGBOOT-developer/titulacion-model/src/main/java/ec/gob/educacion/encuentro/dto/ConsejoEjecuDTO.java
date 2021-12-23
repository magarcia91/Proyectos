package ec.gob.educacion.encuentro.dto;

public class ConsejoEjecuDTO {

	private Integer autCodigo;
    private String autCedula;
    private String autNombre;
    private Integer codigoTitCargo;
    private Long codInstitucion;
    private Long codAnioLectivo;
	private String carNombreTransient;
	
	
	public Integer getAutCodigo() {
		return autCodigo;
	}
	public void setAutCodigo(Integer autCodigo) {
		this.autCodigo = autCodigo;
	}
	public String getAutCedula() {
		return autCedula;
	}
	public void setAutCedula(String autCedula) {
		this.autCedula = autCedula;
	}
	public String getAutNombre() {
		return autNombre;
	}
	public void setAutNombre(String autNombre) {
		this.autNombre = autNombre;
	}
	public Integer getCodigoTitCargo() {
		return codigoTitCargo;
	}
	public void setCodigoTitCargo(Integer codigoTitCargo) {
		this.codigoTitCargo = codigoTitCargo;
	}
	public Long getCodInstitucion() {
		return codInstitucion;
	}
	public void setCodInstitucion(Long codInstitucion) {
		this.codInstitucion = codInstitucion;
	}
	public Long getCodAnioLectivo() {
		return codAnioLectivo;
	}
	public void setCodAnioLectivo(Long codAnioLectivo) {
		this.codAnioLectivo = codAnioLectivo;
	}
	public String getCarNombreTransient() {
		return carNombreTransient;
	}
	public void setCarNombreTransient(String carNombreTransient) {
		this.carNombreTransient = carNombreTransient;
	}

}
