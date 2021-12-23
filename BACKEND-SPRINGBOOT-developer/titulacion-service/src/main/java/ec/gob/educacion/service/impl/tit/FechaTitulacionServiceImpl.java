package ec.gob.educacion.service.impl.tit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.gob.educacion.model.tit.TitFechaTitulacion;
import ec.gob.educacion.repository.tit.FechaTitulacionRepository;
import ec.gob.educacion.service.tit.FechaTitulacionService;


@Service
public class FechaTitulacionServiceImpl implements FechaTitulacionService{
	
	@Autowired
	private FechaTitulacionRepository fechaTitulacionRepository;

	@Override
	public TitFechaTitulacion registrar(TitFechaTitulacion titFechaTitulacion) {
		titFechaTitulacion.setFtiEstado(1);
		
		return fechaTitulacionRepository.save(titFechaTitulacion);
	}

	@Override
	public TitFechaTitulacion buscarCodigo(long ftiCodigo) {
		// TODO Auto-generated method stub
		return fechaTitulacionRepository.findByFtiCodigo(ftiCodigo);
	}

	@Override
	public List<TitFechaTitulacion> listar() {
		// TODO Auto-generated method stub
		return fechaTitulacionRepository.findAll();
	}

	@Override
	public List<TitFechaTitulacion> listarRegionTipo(Integer codRegAniLec, Integer codTipoEducacion) {
		// TODO Auto-generated method stub
		return fechaTitulacionRepository.findByCodRegAniLecAndCodTipoEducacion( codRegAniLec, codTipoEducacion);
	}

	




	
	

}
