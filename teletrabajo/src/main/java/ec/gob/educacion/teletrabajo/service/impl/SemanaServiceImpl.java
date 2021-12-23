package ec.gob.educacion.teletrabajo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.teletrabajo.DTO.SemanaResumenDTO;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TlSemana;
import ec.gob.educacion.teletrabajo.repository.SemanaRepository;
import ec.gob.educacion.teletrabajo.service.SemanaService;

@Service
public class SemanaServiceImpl implements SemanaService {

	@Autowired
	private SemanaRepository semanaRepository;

	@Override
	public List<SemanaResumenDTO> findAll() {
		List<SemanaResumenDTO> result = new ArrayList<SemanaResumenDTO>();
		List<TlSemana> semanas = semanaRepository.findAll(EstadoEnum.ACTIVO.getValor());
		semanas.stream().forEach(s -> {
			SemanaResumenDTO dto = new SemanaResumenDTO(s);
			result.add(dto);
		});
		return result;
	}

	@Override
	public List<TlSemana> findSemanaFechaTruncada(Date fechaInicio, Date fechaFin) {
		return semanaRepository.findSemanaFechaTruncada(fechaInicio, fechaFin);
	}
	
	public long contarTotalRegistros() {
		return semanaRepository.count();
	}

	@Override
	public void save(TlSemana semana) {
		semanaRepository.save(semana);
	}

}
