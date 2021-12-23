package ec.gob.educacion.jubilaciones.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ec.gob.educacion.jubilaciones.entity.SgdJubParametros;
import ec.gob.educacion.jubilaciones.entity.SgdJubTipoDiscapacidad;
import ec.gob.educacion.jubilaciones.entity.SgdJubTipoJubilacion;
import ec.gob.educacion.jubilaciones.repository.SgdJubParametrosRepository;
import ec.gob.educacion.jubilaciones.service.SgdJubParametrosService;
import ec.gob.educacion.jubilaciones.service.SgdJubTipoDiscapacidadService;
import ec.gob.educacion.jubilaciones.service.SgdJubTipoJubilacionService;
import ec.gob.educacion.jubilaciones.service.exception.ModeloNotFoundException;
import ec.gob.educacion.jubilaciones.util.Constantes;

@RestController
@RequestMapping("/jubilaciones")
public class SgdJubParametrosRest {
	
	@Autowired
	private SgdJubParametrosService sgdJubParametrosService;
	
	@Autowired
	private SgdJubParametrosRepository sgdJubParametrosRepository;
	
	/*
	 * @Autowired private SgdJubTipoJubilacionRepository
	 * sgdJubTipoJubilacionRepository;
	 * 
	 * @Autowired private SgdJubTipoDiscapacidadRepository
	 * sgdJubTipoDiscapacidadRepository;
	 */

	@Autowired
	private SgdJubTipoJubilacionService sgdJubTipoJubilacionService;
	
	@Autowired
	private SgdJubTipoDiscapacidadService sgdJubTipoDiscapacidadService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<SgdJubParametros>> listar(){
		List<SgdJubParametros> obj = sgdJubParametrosService.findByParestado(Constantes.PARESTADO_ACTIVO);			
		return new ResponseEntity<List<SgdJubParametros>>(obj, HttpStatus.OK);
	}

	@GetMapping("/listar/{parJubCod}")
	public ResponseEntity<SgdJubParametros> listarPorId(@PathVariable("parJubCod") Integer parJubCod) {
		SgdJubParametros obj = sgdJubParametrosService.listarPorId(parJubCod);
		if(obj.getParcod() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + parJubCod);
		}
		return new ResponseEntity<SgdJubParametros>(obj, HttpStatus.OK);
	}
	
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Object> registrar(@RequestBody SgdJubParametros par) {
		SgdJubParametros pac = sgdJubParametrosService.registrar(par);
		//localhost:8080/SgdJubParametros/5
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{parJubCod}").buildAndExpand(pac.getParcod()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/registro")
	public ResponseEntity<String> registrarPrueba(@RequestBody String mensaje) {
		mensaje="ESTOY AQUI!!!!!!";
		System.out.println("mensaje:"+mensaje);
		return ResponseEntity.ok(mensaje);
	}
	
	
	@GetMapping("/listarTipoJubilacion")
	public ResponseEntity<List<SgdJubTipoJubilacion>> listarPorEstadoJub() {
		List<SgdJubTipoJubilacion> obj = sgdJubTipoJubilacionService.findByTipjubEstado(Constantes.TIPJUB_ACTIVO);
		return new ResponseEntity<List<SgdJubTipoJubilacion>>(obj, HttpStatus.OK);
	}

	@GetMapping("/listarTipoDiscapacidad")
	public ResponseEntity<List<SgdJubTipoDiscapacidad>> listarPorEstadoDis() {
		List<SgdJubTipoDiscapacidad> obj = sgdJubTipoDiscapacidadService.findBytipdisEstado(Constantes.TIPDIS_ACTIVO);		
		return new ResponseEntity<List<SgdJubTipoDiscapacidad>>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/listarTipoDiscapacidadporTipoJubilacion/{tipjubCod}")
	public ResponseEntity<List<SgdJubTipoDiscapacidad>> listarPorTipJubAndTipDisEstado(@PathVariable("tipjubCod") Integer tipjubCod) {
		List<SgdJubTipoDiscapacidad> obj = sgdJubTipoDiscapacidadService.listarDiscapacidadPorJubilacion(tipjubCod);
		return new ResponseEntity<List<SgdJubTipoDiscapacidad>>(obj, HttpStatus.OK);
	}
		
	
	@PutMapping("/modificar/{parJubCod}")
	public ResponseEntity<SgdJubParametros> modificar(@PathVariable("parJubCod") Integer parJubCod, @RequestBody SgdJubParametros par) {
		
		Optional<SgdJubParametros> parJub = sgdJubParametrosRepository.findById(parJubCod);
		
		if (parJub.isPresent()) {
			SgdJubParametros parJubilacion = parJub.get();
			
			parJubilacion.setPartipojubilacion(par.getPartipojubilacion());
			parJubilacion.setPartipodiscapacidad(par.getPartipodiscapacidad());
			parJubilacion.setParedad(par.getParedad());
			parJubilacion.setPartiemposervicio(par.getPartiemposervicio());
			parJubilacion.setParminaportaciones(par.getParminaportaciones());
			
			return new ResponseEntity<>(sgdJubParametrosRepository.save(parJubilacion), HttpStatus.OK);
		} else {
			return new ResponseEntity<SgdJubParametros>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/eliminar/{parJubCod}")
	public ResponseEntity<Object> eliminar(@PathVariable("parJubCod") Integer parJubCod) {
		sgdJubParametrosService.eliminar(parJubCod);		
		return new ResponseEntity<Object>("Dato eliminado exitosamente!!!",HttpStatus.OK);
	}

	
	

}
