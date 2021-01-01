package com.taekwondo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.config.JwtTokenProvider;
import com.taekwondo.model.AutenticacionBody;
import com.taekwondo.model.Usuario;
import com.taekwondo.repository.UsuarioRepository;
import com.taekwondo.service.TipoUsuarioImpl;
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
	TipoUsuarioImpl tUSrv;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AutenticacionBody datos) {
		String nombre;
		try {
			nombre = datos.getNombre();
			UsernamePasswordAuthenticationToken authT = new UsernamePasswordAuthenticationToken(nombre, datos.getPassword());
			Authentication auth = authenticationManager.authenticate(authT);
			List<?> rolesL = (List) auth.getAuthorities();
			String tipo_usuario = ((GrantedAuthority) rolesL.get(0)).getAuthority();
			System.out.println(tipo_usuario);
			String token = jwtTokenProvider.createToken(auth.getName(), tipo_usuario);
			System.out.println("este es el tokeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeen::::"+token);
			Map<Object, Object> modelo = new HashMap<>();
            modelo.put("token", token);   
			return ok(modelo);
		}catch (AuthenticationException e) {
			System.out.println(e);
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas. Verifica la información");
		}		
	}
	
	@GetMapping("/tipos_usuario")
	public ResponseEntity<Object> getRoles() {
		return new ResponseEntity<Object>(this.tUSrv.getTiposUsuario(), 
				HttpStatus.OK);
	}
	
	
    @SuppressWarnings("rawtypes")
    @PostMapping("/registro/{id}")
    public ResponseEntity register(@Valid @RequestBody Usuario user, 
    		@PathVariable int id) {
    	System.out.println(user);
        return usuarios.createUsuario(user, id);
    }

}
