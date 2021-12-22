package ec.gob.educacion.teletrabajo.DTO;

public class TokenDTO {

	private Long userId;
	private String identificacion;
	private String rol;

	public Long getUserId() {
		return userId;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getRol() {
		return rol;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
