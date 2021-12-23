package ec.gob.educacion.teletrabajo.enums;

public enum EstadoClaveEnum {

	
	HABILITADA("Clave habilitada para acceder","H"),
	RESETEO("Clave reseteada, actualizacion obligatoria","R");
	
	private String nombre;
	private String nemonico;
	

	private EstadoClaveEnum(String nombre, String nemonico) {
		this.nombre = nombre;
		this.nemonico = nemonico;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNemonico() {
		return nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}

}
