package ec.gob.educacion.rest.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.educacion.encuentro.dto.LoginDTO;
import ec.gob.educacion.encuentro.dto.MenuDTO;
import ec.gob.educacion.encuentro.dto.ResponseLoginDTO;
import ec.gob.educacion.rest.util.ClientRest;
import ec.gob.educacion.rest.util.Constantes;
import ec.gob.educacion.rest.util.TokenUtil;

@RestController
@RequestMapping("public/")
public class LoginRest {

	public static final String RESPONSE_HTTP_CODE = "RESPONSE_HTTP_CODE";
	public static final String RESPONSE_JSON = "RESPONSE_JSON";

	@PostMapping(path = "login")
	public ResponseLoginDTO login(@RequestBody LoginDTO loguin) {

		ResponseLoginDTO result = new ResponseLoginDTO();

		result.setRoles(new HashMap<Integer, String>());
		result.setMenu(new ArrayList<>());
		
		try {
			Map<String, String> responseClient = ClientRest.doPostRequest(Constantes.URL_REST_SEGURIDAD,
					usuarioJson(loguin.getIdentificacion(), loguin.getClave()));

			JSONObject json = new JSONObject(responseClient.get(RESPONSE_JSON));
			JSONArray geodataCabacera = json.getJSONArray("listaRolesAplicacion");
			Integer codigo = (Integer) json.get("id");
			String identifiacion = json.getString("identificacion");
			String nombre = json.getString("nombre");

			List<MenuDTO> menusPadre = new ArrayList<>();
			Map<Integer, MenuDTO> menusFiltrado = new ConcurrentHashMap<>();

			int n = geodataCabacera.length();
			for (int i = 0; i < n; ++i) {
				JSONObject cabecera = geodataCabacera.getJSONObject(i);
				result.getRoles().put(cabecera.getInt("codigo"), cabecera.getString("nombre"));
				String id = Integer.toString(cabecera.getInt("codigo"));
				Map<String, String> responseRoles = ClientRest.doPostRequest(Constantes.URL_REST_ROLES, id);

				JSONArray arrayCompletoMenus = new JSONArray(responseRoles.get(RESPONSE_JSON));
				int elementosNivelUno = arrayCompletoMenus.length();
				
				for (int n1 = 0; n1 < elementosNivelUno; n1++) {
					MenuDTO menuNivel1 = new MenuDTO(arrayCompletoMenus.getJSONObject(n1), null);
					menusPadre.add(menuNivel1);
					
				}
				menusFiltrado = new ConcurrentHashMap<>();
				
				if (menusPadre.size() > 0) {
					// agrego de entrada el primer menu padre a la lista definitiva
					menusFiltrado.put(menusPadre.get(0).getCodigo(), menusPadre.get(0));
					
					// si hay mas de un menu padre
					if (menusPadre.size() > 1) {
						// me barro el resto de menu padre
						for (int indiceMenuPadre = 1; indiceMenuPadre < menusPadre.size(); indiceMenuPadre++) {
							MenuDTO menuPadreEvaluar = menusPadre.get(indiceMenuPadre);
							// a nivel 1
							MenuDTO menuPadreEnMapa = menusFiltrado.get(menuPadreEvaluar.getCodigo());
							if (Objects.nonNull(menuPadreEnMapa)) {
								// a nivel 2
								for (MenuDTO menuNivel2Evaluar : menuPadreEvaluar.getRecursosHijos()) {
									MenuDTO menuNivel2Mapa = menuPadreEnMapa.getRecursosHijosMapa().get(menuNivel2Evaluar.getCodigo());
									if (Objects.nonNull(menuNivel2Mapa)) {
										// a nivel 3
										for (MenuDTO menuNivel3Evaluar : menuNivel2Evaluar.getRecursosHijos()) {
											MenuDTO menuNivel3Mapa = menuNivel2Mapa.getRecursosHijosMapa().get(menuNivel3Evaluar.getCodigo());
											if (Objects.isNull(menuNivel3Mapa)) {
												menuNivel2Mapa.getRecursosHijosMapa().put(menuNivel3Evaluar.getCodigo(), menuNivel3Evaluar);
												menusFiltrado.entrySet().stream().forEach(e -> e.getValue().llenaSet());
											}
										}
									} else {
										// si no hubo el menu nivel 2 en el iterado filtrado agrego directo
										menuPadreEnMapa.getRecursosHijosMapa().put(menuNivel2Evaluar.getCodigo(), menuNivel2Evaluar);
										menusFiltrado.entrySet().stream().forEach(e -> e.getValue().llenaSet());
									}
								}
							} else {
								// si no encontro el menu en el filtrado lo ingresa de una al list definitivo
								menusFiltrado.put(menuPadreEvaluar.getCodigo(), menuPadreEvaluar);
								menusFiltrado.entrySet().stream().forEach(e -> e.getValue().llenaSet());
							}
						}
					}
				}
							
				menusFiltrado.entrySet().stream().forEach(e -> e.getValue().llenaSet());
				result.setMenu(new ArrayList<>(menusFiltrado.values()));

			}
			if (json.getBoolean("accesoConcedido")) {
				Map<String, Object> claims = new HashMap<String, Object>();
				claims.put("codigo", codigo);
				claims.put("identificacion", identifiacion);
				claims.put("jti", UUID.randomUUID());
				String token = TokenUtil.createJWTWithCustomClaims("" + codigo, "enc", "enc", 3000000 , claims);

				result.setIdentificacion(loguin.getIdentificacion());
				result.setCodigo(codigo);
				result.setToken(token);
				result.setCodigoError(0);
				result.setMensaje(nombre);
			} else {
				throw new Exception("Credenciales incorrectas");
			}

		} catch (Exception e) {
			result.setCodigoError(1);
			result.setMensaje(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	private static String usuarioJson(String identificacion, String clave) {
		return "{" + "\"resu\":\"" + identificacion + "\"," + "\"ssap\":\"" + clave + "\", \"prefijoApp\": \"ENC\"}";

	}

}
