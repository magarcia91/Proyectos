package ec.gob.educacion.teletrabajo.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ec.gob.educacion.teletrabajo.DTO.CaptchaDTO;
import ec.gob.educacion.teletrabajo.DTO.DefaultDTO;
import ec.gob.educacion.teletrabajo.DTO.RecuperarClaveDTO;
import ec.gob.educacion.teletrabajo.DTO.ResponseLoginDTO;
import ec.gob.educacion.teletrabajo.service.ClaveUsuarioService;
import ec.gob.educacion.teletrabajo.service.UsuarioService;
import ec.gob.educacion.teletrabajo.util.Util;

@Controller
@RequestMapping("public/login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ClaveUsuarioService claveUsuarioService;


	@GetMapping
	@ResponseBody
	@CrossOrigin(origins = "*")
	public ResponseLoginDTO login(@RequestParam("identificacion") String identificacion,
			@RequestParam("password") String password) {
		return usuarioService.login(identificacion, password);
	}
	
	@GetMapping(value = "/valorCaptcha")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public CaptchaDTO valorCaptcha(){
		CaptchaDTO valor = new CaptchaDTO();
		Random r = new Random();
        String token = Long.toString(Math.abs(r.nextLong()), 36);
        String ch = token.substring(0, 6);
		valor.setValorGenerado(ch);
		return valor;
	}
	
	@GetMapping(value = "/imagenCaptcha")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public void imagenCaptcha(HttpServletResponse response, @RequestParam("code") String codigo)throws IOException {
		 //Expire response
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Max-Age", 0);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
 
        BufferedImage image = new BufferedImage(120, 30, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();        
        Color c = new Color(0.6662f, 0.4569f, 0.3232f);
        GradientPaint gp = new GradientPaint(30, 30, c, 15, 25, Color.white, true);
        graphics2D.setPaint(gp);
        Font font = new Font("Verdana", Font.CENTER_BASELINE, 26);
        Rectangle rectangulo = new Rectangle(image.getWidth(), image.getHeight());
        Util.drawCenteredString(graphics2D, codigo, rectangulo, font);
        graphics2D.dispose();
 
        OutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        outputStream.close();
	}
	
	@PostMapping(value = "/validarCaptcha")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public String postActionCaptcha(@RequestBody CaptchaDTO captcha){		
	    // execute the captcha validation
	    boolean esCorrecto = captcha.getValorGenerado().equals(captcha.getValorIngresado());
	    if (esCorrecto == false) {
	      return "{\"success\":false}";
	    } else {
	    	return "{\"success\":true}";
	    }
	}
	
	@PostMapping(value = "/enviarSolicitud")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO enviarSolicitud(@RequestBody RecuperarClaveDTO recuperar){			    
	   return claveUsuarioService.recuperarClave(recuperar);
	}
	
	@PostMapping(value = "/enviarSolicitudRecuperarCorreo")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public DefaultDTO enviarSolicitudRecuperarCorreo(@RequestBody RecuperarClaveDTO recuperar){			    
	   return claveUsuarioService.recuperarCorreo(recuperar);
	}
}
