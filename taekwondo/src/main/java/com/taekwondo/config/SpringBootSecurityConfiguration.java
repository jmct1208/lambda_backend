package com.taekwondo.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.taekwondo.config.JwtConfigurer;
import com.taekwondo.service.UsuarioServiceImp;

@Configuration
@EnableWebSecurity()
public class SpringBootSecurityConfiguration extends 
	WebSecurityConfigurerAdapter {
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder autenticacion) 
			throws Exception {
		UserDetailsService userDetailsService = this.detallesUsuario();
		autenticacion.userDetailsService(userDetailsService)
		.passwordEncoder(this.bCrypPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable().csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests() 
			.antMatchers("/api/autenticacion/**")
				.permitAll()
			.antMatchers(HttpMethod.GET, "/eventos", "/examenes").permitAll()
			.regexMatchers(HttpMethod.GET, "/usuarios\\?nombre=.+", 
					"/usuarios/(\\d)+/alumno",
					"/alumnos/(\\d)+",
					"/alumnos/(\\d)+/eventos", 
					"/alumnos/(\\d)+/examenes").authenticated()
			.antMatchers("/usuarios", "/usuarios/**", "/eventos", "/eventos/**",
					"/examenes", "/examenes/**", "/tipos_evento",
					"/tipos_evento/**", "/alumnos", "/alumnos/**")
				.hasAuthority("ADMINISTRADOR")
			.anyRequest().authenticated()
			.and().csrf()
			.disable().exceptionHandling()
			.authenticationEntryPoint(unauthorizedEntryPoint()).and()
			.apply(new JwtConfigurer(jwtTokenProvider));
		
		http.cors();
	}
	
	@Override 
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/resources/**", "/css/**", "/assets/**", "/js/**");
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {
		return (request, response, authException) -> 
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"No autorizado");
	}
	
	@Bean
	public PasswordEncoder bCrypPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService detallesUsuario() {
		return new UsuarioServiceImp();
	}
}
