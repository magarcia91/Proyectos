package ec.gob.educacion.teletrabajo.DTO;

public class ResponseLoginDTO extends DefaultDTO {

	private String role;
	private String nombre;
	private String token;
	private String identificacion;
	private Integer zona;
	private String distrito;
	private Boolean cambioObligatorioClave;
	private Long userCode;
	private Long passCode;
	private Boolean habilitadaEncuesta;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Integer getZona() {
		return zona;
	}

	public void setZona(Integer zona) {
		this.zona = zona;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Boolean getCambioObligatorioClave() {
		return cambioObligatorioClave;
	}

	public void setCambioObligatorioClave(Boolean cambioObligatorioClave) {
		this.cambioObligatorioClave = cambioObligatorioClave;
	}

	public Long getUserCode() {
		return userCode;
	}

	public void setUserCode(Long userCode) {
		this.userCode = userCode;
	}

	public Long getPassCode() {
		return passCode;
	}

	public void setPassCode(Long passCode) {
		this.passCode = passCode;
	}

	public Boolean getHabilitadaEncuesta() {
		return habilitadaEncuesta;
	}

	public void setHabilitadaEncuesta(Boolean habilitadaEncuesta) {
		this.habilitadaEncuesta = habilitadaEncuesta;
	}

}
