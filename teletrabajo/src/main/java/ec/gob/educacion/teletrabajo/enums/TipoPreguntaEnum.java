package ec.gob.educacion.teletrabajo.enums;

public enum TipoPreguntaEnum {

	PREGUNTA_ENTERO("INT", "Pregunta que acepta respuesta en enteros"), 
	PREGUNTA_OPCION("OPC", "Pregunta que presenta seleccion de opciones"),
	PREGUNTA_OPCION_MULTIPLE("MULT", "Pregunta que presenta seleccion de opciones multiples"),
	PREGUNTA_TEXTO("TXT", "Pregunta que acepta respuesta de texto"),
	PREGUNTA_DECIMAL("DEC", "Pregunta que acepta respuesta en decimal");

	private String nemonico;
	private String descripcion;

	private TipoPreguntaEnum(String nemonico, String descripcion) {
		this.nemonico = nemonico;
		this.descripcion = descripcion;
	}

	public String getNemonico() {
		return nemonico;
	}

	public void setNemonico(String nemonico) {
		this.nemonico = nemonico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
