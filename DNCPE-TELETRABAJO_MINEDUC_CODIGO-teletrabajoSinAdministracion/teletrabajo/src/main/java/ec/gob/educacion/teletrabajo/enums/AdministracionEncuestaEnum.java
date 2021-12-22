package ec.gob.educacion.teletrabajo.enums;

public enum AdministracionEncuestaEnum {

	
	NOMBRE_ENCUESTA_ACTUAL("Nombre de la encuesta activa en teletrabajo","NOENC"),
	HABILITACION_ENCUESTA("Estado para activar una encuesta en teletrabajo","FLENC");

	private String nombre;
	private String nemonico;
	

	private AdministracionEncuestaEnum(String nombre, String nemonico) {
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
