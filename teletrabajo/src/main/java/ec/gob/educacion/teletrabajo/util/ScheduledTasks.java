package ec.gob.educacion.teletrabajo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TlSemana;
import ec.gob.educacion.teletrabajo.service.SemanaService;

@Component
public class ScheduledTasks {

	@Autowired
	private SemanaService semanaService;

	@Scheduled(cron = "0 0 0 * * sun")
	//@Scheduled(cron = "0 08 13 * * mon")
	public void scheduleTask() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar start = Calendar.getInstance();
		start.add(Calendar.DAY_OF_MONTH, -6);
		//Timestamp startTimeInMillis = new Timestamp(1000 * (start.getTimeInMillis()/1000));
		Date startDate =new Date(start.getTimeInMillis());

		Calendar end = Calendar.getInstance();
		end.setTime(start.getTime());
		end.add(Calendar.DAY_OF_MONTH, +4);
		//Timestamp endTimeInMillis = new Timestamp(1000 * (end.getTimeInMillis()/1000));
		Date endDate = new Date(end.getTimeInMillis());

		List<TlSemana> semana = semanaService.findSemanaFechaTruncada(sdf.parse(sdf.format(startDate)),sdf.parse(sdf.format(endDate)));

		if (semana.size() == 0) {
			long codigoSemana = semanaService.contarTotalRegistros()+1;
			TlSemana newSemana = new TlSemana();
			newSemana.setFechaInicio(startDate);
			newSemana.setFechaFin(endDate);
			newSemana.setStsEstado(EstadoEnum.ACTIVO.getValor());
			newSemana.setNombre("Semana "+codigoSemana);
			semanaService.save(newSemana);
		}else {
			TlSemana primerRegistro = semana.get(0);	
			semana.stream().forEach(x->{
				if(x.getCodSemana().equals(primerRegistro.getCodSemana())) {
					x.setStsEstado(EstadoEnum.ACTIVO.getValor());
				}else {
					x.setStsEstado(EstadoEnum.INACTIVO.getValor());
				}
				semanaService.save(x);
			});
					
				
			
			
		}

	}

}
