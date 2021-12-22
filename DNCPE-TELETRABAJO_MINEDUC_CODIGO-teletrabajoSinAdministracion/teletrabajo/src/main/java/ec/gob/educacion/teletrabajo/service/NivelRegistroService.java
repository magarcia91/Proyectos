package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.model.TelNivelRegistro;

public interface NivelRegistroService {

	public List<TelNivelRegistro> obtenerNivelesRegistradosPorCabecera(Long codCabeceraRegistro, String estado);
	
	public DefaultDTO guardarNivelRegistro(String token, List<TelNivelRegistro> niveles);

}
