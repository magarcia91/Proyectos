package ec.gob.educacion.teletrabajo.DTO;

public class RecuperarClaveDTO {

	private String identificacion;
	private String correoElectronico;
	private Integer anioNacimiento;
	private Integer anioExpedicionCedula;
	private boolean peticionConCorreoPersonal;
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public Integer getAnioNacimiento() {
		return anioNacimiento;
	}
	public void setAnioNacimiento(Integer anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}
	
	public boolean isPeticionConCorreoPersonal() {
		return peticionConCorreoPersonal;
	}
	public void setPeticionConCorreoPersonal(boolean peticionConCorreoPersonal) {
		this.peticionConCorreoPersonal = peticionConCorreoPersonal;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public Integer getAnioExpedicionCedula() {
		return anioExpedicionCedula;
	}
	public void setAnioExpedicionCedula(Integer anioExpedicionCedula) {
		this.anioExpedicionCedula = anioExpedicionCedula;
	}
	
	
}
