package ec.gob.educacion.jubilaciones.enumeracion;

public enum EstadoEnum {

	ACTIVO(1,"ACTIVO"),
	INACTIVO(0,"INACTIVO");
	
	private int codigo;
	private String descripcion;
	
	private EstadoEnum(int codigo, String descripcion){
		this.codigo=codigo;
		this.descripcion=descripcion;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	
}
