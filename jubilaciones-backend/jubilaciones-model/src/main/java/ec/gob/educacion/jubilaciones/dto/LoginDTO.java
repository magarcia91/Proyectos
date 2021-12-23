package ec.gob.educacion.jubilaciones.dto;

public class LoginDTO {

	private String identificacion;
	private String clave;
	
	public LoginDTO() {
		
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
