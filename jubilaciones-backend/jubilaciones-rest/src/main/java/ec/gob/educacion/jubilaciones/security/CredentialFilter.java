package ec.gob.educacion.jubilaciones.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import ec.gob.educacion.jubilaciones.util.TokenUtil;
import io.jsonwebtoken.Claims;

public class CredentialFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		SessionManager sessionManager = new SessionManager();
		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("Authorization");
		if (token != null) {
			try {
				Claims claims = TokenUtil.decodeJWT(token);
				sessionManager.setData(claims.get("identificacion").toString(),
						Long.parseLong(claims.get("codigo").toString()));

				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("enc",
						"enc", Collections.emptyList());

				SecurityContextHolder.getContext().setAuthentication(auth);
			} catch (Exception e) {
				e.printStackTrace();
				SecurityContextHolder.getContext().setAuthentication(null);
			}

		}
		if(req.getRequestURI().contains(".html") || req.getRequestURI().contains(".js") || req.getRequestURI().contains(".png") || req.getRequestURI().equals("/enc/")) {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("enc",
					"enc", Collections.emptyList());

			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		chain.doFilter(request, response);

	}

}
