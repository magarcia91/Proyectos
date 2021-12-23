package ec.gob.educacion.teletrabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.enums.CatalogoEnum;
import ec.gob.educacion.teletrabajo.enums.EstadoEnum;
import ec.gob.educacion.teletrabajo.model.TelCabeceraRegistro;
import ec.gob.educacion.teletrabajo.model.TelDistrito;
import ec.gob.educacion.teletrabajo.model.TelDistritoRegistro;
import ec.gob.educacion.teletrabajo.model.TelInsEducativa;
import ec.gob.educacion.teletrabajo.model.TelItemCatalogo;
import ec.gob.educacion.teletrabajo.model.TelNivelRegistro;
import ec.gob.educacion.teletrabajo.model.TelProvincia;
import ec.gob.educacion.teletrabajo.model.TelUsuario;
import ec.gob.educacion.teletrabajo.model.TelZona;
import ec.gob.educacion.teletrabajo.service.CabeceraRegistroService;
import ec.gob.educacion.teletrabajo.service.DistritoRegistroService;
import ec.gob.educacion.teletrabajo.service.DistritoService;
import ec.gob.educacion.teletrabajo.service.InsEducativaService;
import ec.gob.educacion.teletrabajo.service.ItemCatalogoService;
import ec.gob.educacion.teletrabajo.service.NivelRegistroService;
import ec.gob.educacion.teletrabajo.service.ProvinciaService;
import ec.gob.educacion.teletrabajo.service.UsuarioService;
import ec.gob.educacion.teletrabajo.service.ZonaService;

@Controller
@RequestMapping("docente")
public class DocenteController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ItemCatalogoService itemCatalogoService;
	@Autowired
	private CabeceraRegistroService cabeceraRegistroService;
	@Autowired
	private DistritoService distritoService;
	@Autowired
	private InsEducativaService insEducativaService;
	@Autowired
	private ProvinciaService provinciaService;
	@Autowired
	private ZonaService zonaService;
	@Autowired
	private NivelRegistroService nivelRegistroService;
	@Autowired
	private DistritoRegistroService distritoRegistroService;

	
	@GetMapping(value = "/findByIdentificacion")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(DocenteView.class)
	public TelUsuario buscarPorIdentificacion(@Param("identificacion") String identificacion) {
		return usuarioService.obtenerPorIdentificacion(identificacion);
	}
	
	@GetMapping(value = "/listarOfertaEducativa")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(ItemCatalogoView.class)
	public List<TelItemCatalogo> listarOfertaEducativa() {
		return itemCatalogoService.listarPorNemonicoCatalogo(CatalogoEnum.OFERTAS.getNemonico(), EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarRegimenes")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(ItemCatalogoView.class)
	public List<TelItemCatalogo> listarRegimenes() {
		return itemCatalogoService.listarPorNemonicoCatalogo(CatalogoEnum.REGIMEN.getNemonico(), EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarFuncionesCargos")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(ItemCatalogoView.class)
	public List<TelItemCatalogo> listarItemCatalogoPorNemonico(@Param("codigoPadre") Long codigoPadre) {
		List<TelItemCatalogo> funciones = itemCatalogoService.listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(CatalogoEnum.FUNCIONES_CARGOS.getNemonico(), codigoPadre, EstadoEnum.ACTIVO.getValor());
		funciones.sort((a,b)->a.getNombre().compareTo(b.getNombre()));
		return funciones;
	}
	
	@GetMapping(value = "/listarNivelesSubniveles")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(ItemCatalogoView.class)
	public List<TelItemCatalogo> listarItemCatalogoPorCodigoPadre(@Param("codigoPadre") Long codigoPadre) {
		return itemCatalogoService.listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(CatalogoEnum.NIVELES_SUBNIVELES.getNemonico(), codigoPadre, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarGrados")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(ItemCatalogoView.class)
	public List<TelItemCatalogo> listarGrados(@Param("codigoPadre") Long codigoPadre) {
		return itemCatalogoService.listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(CatalogoEnum.GRADOS.getNemonico(), codigoPadre, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarAreasAsignaturas")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(ItemCatalogoView.class)
	public List<TelItemCatalogo> listarAreasAsignaturas(@Param("codigoPadre") Long codigoPadre) {
		return itemCatalogoService.listarPorCodigoItemCatalogoPadreYNemonicoCatalogo(CatalogoEnum.AREAS_ASIGNATURAS.getNemonico(), codigoPadre, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/obtenerCabeceraRegistro")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public TelCabeceraRegistro obtenerCabeceraRegistroUsuario(@Param("identificacion") String identificacion) {
		return cabeceraRegistroService.obtenerCabeceraRegistroUsuario(identificacion, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/obtenerDistritoDpa")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public TelDistrito obtenerDistritoPorDpa(@Param("dpaDistrito") String dpaDistrito) {
		return distritoService.obtenerDistritoPorDpa(dpaDistrito, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarDistritos")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelDistrito> listarDistritosPorCodigoProvincia(@Param("codProvincia") Long codProvincia) {
		return distritoService.listarDistritosPorCodProvincia(codProvincia, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarDistritosZona")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelDistrito> listarDistritosPorCodigoZona(@Param("codZona") Long codZona) {
		return distritoService.obtenerDistritosPorZona(codZona, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarZonas")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelZona> listarZonas() {
		return zonaService.listarZonas(EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarProvincias")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelProvincia> listarProvincias(@Param("codZona") Long codZona) {
		return provinciaService.listarProvinciasPorZona(codZona,EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarInstitucionesEducativasPorDistrito")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelInsEducativa> listarInstitucionesEducativasPorDistrito(@Param("codDistrito") Long codDistrito) {
		return insEducativaService.listarInstitucionesEducativasPorDistrito(codDistrito, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarInstitucionesEducativasPorDistritoYOferta")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelInsEducativa> listarInstitucionesEducativasPorDistritoYOferta(@Param("codDistrito") Long codDistrito, @Param("nemonicoOferta") String nemonicoOferta) {
		return insEducativaService.listarInstitucionesEducativasPorDistritoYOferta(nemonicoOferta, codDistrito, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarInstitucionesEducativasPorOferta")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelInsEducativa> listarInstitucionesEducativasPorOferta(@Param("nemonicoOferta") String nemonicoOferta) {
		return insEducativaService.listarInstitucionesEducativasPorOfertaEducativa(nemonicoOferta, EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarNivelesGuardados")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelNivelRegistro> listarNivelesRegistrosGuardados(@Param("codigoCabeceraRegistro") Long codigoCabeceraRegistro) {
		return nivelRegistroService.obtenerNivelesRegistradosPorCabecera(codigoCabeceraRegistro,EstadoEnum.ACTIVO.getValor());
	}
	
	@GetMapping(value = "/listarDistritosGuardados")
	@ResponseBody
	@CrossOrigin(origins = "*")
	@JsonView(CabeceraRegistroView.class)
	public List<TelDistritoRegistro> obtenerDistritosRegistradosPorCabecera(@Param("codigoCabeceraRegistro") Long codigoCabeceraRegistro) {
		return distritoRegistroService.obtenerDistritosRegistradosPorCabecera(codigoCabeceraRegistro, EstadoEnum.ACTIVO.getValor());
	}
	
	@PostMapping
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO guardarCabecera(@RequestBody TelCabeceraRegistro cabecera, @RequestHeader("Authorization") String token) {
		return cabeceraRegistroService.guardarCabeceraRegistro(token, cabecera);
	}
	
	@PostMapping(value = "/saveNiveles")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO guardarNivelesRegistro(@RequestBody List<TelNivelRegistro> nivelesRegistro, @RequestHeader("Authorization") String token) {
		return nivelRegistroService.guardarNivelRegistro(token, nivelesRegistro);
	}
	
	@PostMapping(value = "/saveDistritos")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO guardarDistritosRegistro(@RequestBody List<TelDistritoRegistro> distritosRegistro, @RequestHeader("Authorization") String token) {
		return distritoRegistroService.guardarDistritoRegistro(token, distritosRegistro);
	}

	public interface DocenteView {}
	public interface ItemCatalogoView {}
	public interface CabeceraRegistroView {}
}
