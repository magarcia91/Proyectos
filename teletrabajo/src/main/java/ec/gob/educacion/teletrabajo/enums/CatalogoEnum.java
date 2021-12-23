package ec.gob.educacion.teletrabajo.enums;

public enum CatalogoEnum {

	
	OFERTAS("Oferta educativa","OFERT"),
	FUNCIONES_CARGOS("Función o cargo dentro de la institución educativa","CARGO"),
	REGIMEN("Régimen","REGIM"),
	NIVELES_SUBNIVELES("Niveles y subniveles de educación","NIVEL"),
	GRADOS("Grados de educación","GRADO"),
	AREAS_ASIGNATURAS("Áreas y Asignaturas","ASIGN"),
	ACTIVIDADES("Actividades Docentes","ACTDO"),
	ENCUESTAS("Preguntas encuesta teletrabajo","ENCUE");

	private String nombre;
	private String nemonico;
	

	private CatalogoEnum(String nombre, String nemonico) {
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
