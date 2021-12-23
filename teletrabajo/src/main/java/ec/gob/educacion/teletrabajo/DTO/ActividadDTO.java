package ec.gob.educacion.teletrabajo.DTO;

import java.io.Serializable;

import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;

public class ActividadDTO implements Serializable {

	private static final long serialVersionUID = 5683680792819824936L;

	private Long codigo;
	private String nombre;
	private String nemonico;

	public ActividadDTO() {
	}

	public ActividadDTO(TelItemCatalogo item) {
		this.codigo = item.getCodItemCatalogo();
		this.nombre = item.getNombre();
	}

	public ActividadDTO(Long codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public ActividadDTO(Long codigo, String nombre, String nemonico) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nemonico = nemonico;
	}

	public TelItemCatalogo fromDTO(TelItemCatalogo item) {
		item.setCodItemCatalogo(this.codigo);
		item.setNombre(this.nombre);
		return item;
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
