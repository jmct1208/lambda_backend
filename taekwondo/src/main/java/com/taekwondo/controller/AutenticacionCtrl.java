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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.config.JwtTokenProvider;
import com.taekwondo.model.AutenticacionBody;
import com.taekwondo.model.Usuario;
import com.taekwondo.repository.UsuarioRepository;
import com.taekwondo.service.UsuarioServiceImp;

@RestController
@RequestMapping("/api/autenticacion")
public class AutenticacionCtrl {
	
	@Autowired
	AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UsuarioRepository users;
	
	@Autowired
	UsuarioServiceImp usuarios;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AutenticacionBody datos) {
		System.out.println(datos.getNombre());
		System.out.println(""+bCryptPasswordEncoder.encode(datos.getPassword()));
		String nombre;
		Usuario usuario;
		try {
			nombre = datos.getNombre();
			usuario = this.users.findByNombre(nombre);
			System.out.println(usuario.getNombre());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(nombre, datos.getPassword()));
			String token = jwtTokenProvider.createToken(nombre, usuario.getTipoUsuario().getNombre_tipo_usuario());
			System.out.println("este es el tokeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeen::::"+token);
			Map<Object, Object> modelo = new HashMap<>();
            modelo.put("token", token);   
			return ok(modelo);
		}catch (AuthenticationException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas. Verifica la información");
		}		
	}
	
    @SuppressWarnings("rawtypes")
    @PostMapping("/registro")
    public ResponseEntity register(@RequestBody Usuario user) {
    	System.out.println(""+user);
        return usuarios.createUsuario(user);
    }

}
