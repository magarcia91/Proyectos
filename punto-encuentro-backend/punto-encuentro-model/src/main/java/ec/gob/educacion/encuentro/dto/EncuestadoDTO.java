package ec.gob.educacion.encuentro.dto;

public class EncuestadoDTO {

	private long estCodigo;
	private String estNombre;
	private long codigo;
	private String descripcion;

	
	public EncuestadoDTO() {
	}
	
	public EncuestadoDTO(long estCodigo, String estNombre, long codigo, String descripcion) {
		super();
		this.estCodigo = estCodigo;
		this.estNombre = estNombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public long getEstCodigo() {
		return estCodigo;
	}
	public String getEstNombre() {
		return estNombre;
	}
	public long getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setEstCodigo(long estCodigo) {
		this.estCodigo = estCodigo;
	}
	public void setEstNombre(String estNombre) {
		this.estNombre = estNombre;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}
