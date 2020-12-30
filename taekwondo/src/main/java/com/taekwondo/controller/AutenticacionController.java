package com.taekwondo.controller;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.config.JwtTokenProvider;
import com.taekwondo.model.AutenticacionBody;
import com.taekwondo.model.Usuario;
import com.taekwondo.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioRepository uRep;
	
	@Autowired
	UsuarioController uCtrl;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(
			@RequestBody AutenticacionBody authBody) {
		try {
			String nombre = authBody.getNombre();
			Usuario usuario = this.uRep.findByNombre(nombre);
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							nombre, authBody.getPassword()));
			String token = 
					this
					.jwtTokenProvider
					.createToken(nombre, usuario.getTipoUsuario().getNombre_tipo_usuario());
			Map<Object, Object> modelo = new HashMap<Object, Object>();
			modelo.put("token", token);
			return ok(modelo);
		}catch(AuthenticationException e) {
			return ResponseEntity
					.status(HttpStatus.UNAUTHORIZED)
					.body("Credenciales inválidas. Verifica la información");
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/registro")
	public ResponseEntity register(@RequestBody Usuario usuario) {
		return this.uCtrl.createUsuario(usuario);
	}

}
