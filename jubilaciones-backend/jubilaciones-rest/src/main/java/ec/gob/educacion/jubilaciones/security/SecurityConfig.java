package ec.gob.educacion.jubilaciones.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST","PUT"));
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new CredentialFilter(), BasicAuthenticationFilter.class);
		http.cors().and().csrf().disable();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/jubilaciones/**")		
		.permitAll().antMatchers(HttpMethod.POST, "/jubilaciones/**")
		.permitAll().antMatchers(HttpMethod.GET, "/jubilaciones/**")
		.permitAll().antMatchers(HttpMethod.PUT, "/jubilaciones/**")
		.authenticated().antMatchers(HttpMethod.POST, "/private/**").authenticated();
		//.permitAll().antMatchers(HttpMethod.POST, "/public/**")
		//.authenticated().antMatchers(HttpMethod.POST, "/jubilaciones/**").authenticated();
		
		/*
		 * http.authorizeRequests().antMatchers(HttpMethod.GET, "/public/**")
		 * .permitAll().antMatchers(HttpMethod.POST,
		 * "/public/**").permitAll().antMatchers(HttpMethod.GET, "/private/**")
		 * .authenticated().antMatchers(HttpMethod.POST, "/private/**").authenticated();
		 */
		
}

}
