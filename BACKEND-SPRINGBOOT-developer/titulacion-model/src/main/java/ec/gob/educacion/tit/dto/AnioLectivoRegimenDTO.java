package ec.gob.educacion.tit.dto;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class AnioLectivoRegimenDTO {
	
	private Integer codigo;	
	private String descripcion;	
	private Integer anioInicio;
	private Integer anioFin;
	

	
	public AnioLectivoRegimenDTO() {
		
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public Integer getAnioInicio() {
		return anioInicio;
	}


	public void setAnioInicio(Integer anioInicio) {
		this.anioInicio = anioInicio;
	}


	public Integer getAnioFin() {
		return anioFin;
	}


	public void setAnioFin(Integer anioFin) {
		this.anioFin = anioFin;
	}

	

		

}
