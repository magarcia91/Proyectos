package ec.gob.educacion.teletrabajo.service;

import java.util.List;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.model.TelDistritoRegistro;

public interface DistritoRegistroService {

	public List<TelDistritoRegistro> obtenerDistritosRegistradosPorCabecera(Long codCabeceraRegistro, String estado);
	
	public DefaultDTO guardarDistritoRegistro(String token, List<TelDistritoRegistro> distritos);

}
