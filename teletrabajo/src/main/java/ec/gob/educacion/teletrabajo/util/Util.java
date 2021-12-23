package ec.gob.educacion.teletrabajo.util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.lang3.RandomStringUtils;

import ec.gob.educacion.teletrabajo.DTO.TokenDTO;
import io.jsonwebtoken.Claims;

public class Util {
	
	private final static short PASSWORD_LENGTH = 8;

	public static String encodeMD5(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String md5 = DatatypeConverter.printHexBinary(digest).toUpperCase();		
		return md5.toLowerCase();
	}

	public static TokenDTO getInfoToken(String token) throws Exception {
		TokenDTO response = new TokenDTO();

		Claims claims = TokenUtil.decodeJWT(token);
		response.setUserId(Long.parseLong(claims.get(Constantes.TOKEN_CODE).toString()));
		response.setRol(claims.get(Constantes.TOKEN_ROL).toString());
		response.setIdentificacion(claims.get(Constantes.TOKEN_IDENTIFICACION).toString());

		if (token != null && !token.isEmpty() && response != null)
			return response;
		else
			throw new Exception("Token is empty");
	}
	
	/**
	 * Draw a String centered in the middle of a Rectangle.
	 *
	 * @param g The Graphics instance.
	 * @param text The String to draw.
	 * @param rect The Rectangle to center the text in.
	 */
	public static void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
	    // Get the FontMetrics
	    FontMetrics metrics = g.getFontMetrics(font);
	    // Determine the X coordinate for the text
	    int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
	    // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
	    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(font);
	    // Draw the String
	    g.drawString(text, x, y);
	}
		

	public static String getPassword() {
		return RandomStringUtils.randomAlphanumeric(PASSWORD_LENGTH);
	}
	
	public static boolean encuestaConfirmada(Date fechaConfirmacion, int cantidadDiasValidosConfirmacion) {
		boolean confirmada = false;
		if(fechaConfirmacion != null) {
			Date fechaActual = new Date();
			Date fechaSumada = sumarDiasAFecha(fechaConfirmacion, cantidadDiasValidosConfirmacion);
			confirmada = fechaActual.before(fechaSumada);
		}
		return confirmada;
	}
	
	public static Date sumarDiasAFecha(Date fecha, int dias){
	      if (dias==0) return fecha;
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(fecha); 
	      calendar.add(Calendar.DAY_OF_YEAR, dias);  
	      return calendar.getTime(); 
	}

}
