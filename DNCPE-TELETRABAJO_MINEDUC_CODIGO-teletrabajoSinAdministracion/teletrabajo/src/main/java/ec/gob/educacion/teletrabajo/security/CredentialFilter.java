package ec.gob.educacion.teletrabajo.security;

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

import ec.gob.educacion.teletrabajo.util.TokenUtil;

public class CredentialFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String token = req.getHeader("Authorization");
		if (token != null) {
			try {
				TokenUtil.decodeJWT(token);

				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("teletrabajo",
						"educaEcuador", Collections.emptyList());

				SecurityContextHolder.getContext().setAuthentication(auth);
			} catch (Exception e) {
				e.printStackTrace();
				SecurityContextHolder.getContext().setAuthentication(null);
			}

		}
		if(req.getRequestURI().contains(".html") || req.getRequestURI().contains(".js") || req.getRequestURI().contains(".png") || req.getRequestURI().equals("/teletrabajo/")) {
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("teletrabajo",
					"teletrabajo", Collections.emptyList());

			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		chain.doFilter(request, response);

	}

}
