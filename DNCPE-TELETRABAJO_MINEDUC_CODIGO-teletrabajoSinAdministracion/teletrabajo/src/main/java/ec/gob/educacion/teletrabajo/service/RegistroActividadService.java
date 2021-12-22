package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.DTO.ActividadDTO;
import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.SemanaResumenDTO;

public interface RegistroActividadService {

	List<ActividadDTO> findActivities(Long usuario, Long semana);

	DefaultDTO save(String token, SemanaResumenDTO datos);
	
	public DefaultDTO inactivarActividadesRegistradas(String token, SemanaResumenDTO datos);
	
}
