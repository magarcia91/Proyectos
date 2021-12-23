package ec.gob.educacion.tit.dto;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class MenuDTO {

	private String descripcion;
	private Integer codigoRecursoPadre;
	private Integer codigo;
	private String nombre;
	private Integer nivel;
	private String url;
	
	@JsonIgnore
	private Map<Integer, MenuDTO> recursosHijosMapa;
	@JsonIgnore
	private MenuDTO menuPadre;
	private Set<MenuDTO> recursosHijos;
	
	public MenuDTO() {
		
	}
	
	public MenuDTO(JSONObject jsonObject, MenuDTO menuPadre) {
		
		this.setMenuPadre(menuPadre);
		this.setDescripcion(jsonObject.getString("descripcion"));
		this.setCodigo(jsonObject.getInt("codigo"));
		
		if(!jsonObject.isNull("codigoRecursoPadre")) {
			this.setCodigoRecursoPadre(jsonObject.getInt("codigoRecursoPadre"));
		}
		
		this.setNombre(jsonObject.getString("nombre"));
		
		if(!jsonObject.isNull("nivel")) {
			this.setNivel(jsonObject.getInt("nivel"));
		}
		
		this.setUrl(jsonObject.getString("url"));
		this.recursosHijosMapa = new ConcurrentHashMap<Integer, MenuDTO>();
	
		
		if(!jsonObject.isNull("recursosHijos")) {
			JSONArray arrayHijos = jsonObject.getJSONArray("recursosHijos");
			for(int n = 0; n < arrayHijos.length(); n++) {
				recursosHijosMapa.put(arrayHijos.getJSONObject(n).getInt("codigo"), new MenuDTO(arrayHijos.getJSONObject(n), this));
			}
		}
		llenaSet();
	}
	
	public void llenaSet() {
		this.recursosHijos = new HashSet<>(recursosHijosMapa.values());
		for (MenuDTO menuDTOHijo : recursosHijos) {
			menuDTOHijo.llenaSet();
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCodigoRecursoPadre() {
		return codigoRecursoPadre;
	}

	public void setCodigoRecursoPadre(Integer codigoRecursoPadre) {
		this.codigoRecursoPadre = codigoRecursoPadre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<Integer, MenuDTO> getRecursosHijosMapa() {
		return recursosHijosMapa;
	}

	public void setRecursosHijosMapa(Map<Integer, MenuDTO> recursosHijosMapa) {
		this.recursosHijosMapa = recursosHijosMapa;
	}

	public MenuDTO getMenuPadre() {
		return menuPadre;
	}

	public void setMenuPadre(MenuDTO menuPadre) {
		this.menuPadre = menuPadre;
	}

	public Set<MenuDTO> getRecursosHijos() {
		return recursosHijos;
	}

	public void setRecursosHijos(Set<MenuDTO> recursosHijos) {
		this.recursosHijos = recursosHijos;
	}

		

}
