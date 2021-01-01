package com.taekwondo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.taekwondo.model.TipoUsuario;
import com.taekwondo.model.Usuario;
import com.taekwondo.repository.TipoUsuarioRepository;
import com.taekwondo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository uRep;
	
	@Autowired
	private TipoUsuarioRepository tRep;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Usuario getUsuario(int id) {
		return this.uRep.getOne(id);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return uRep.findAll();
	}
	@Override
	public ResponseEntity<Object> createUsuario(Usuario usuario, int idRol) {
		
	
        Usuario usuario_existe = uRep.findByNombre(usuario.getNombre());
		
		if(usuario_existe != null) {
			HashMap<String, Object> response = new HashMap<>(); 
			response.put("status", HttpStatus.PRECONDITION_FAILED);
			response.put("mensaje", "usuario ya existe");
			return new ResponseEntity<Object>(response, HttpStatus.PRECONDITION_FAILED);
		}
		TipoUsuario tipo=tRep.getOne(idRol);
		usuario.setTipoUsuario(tipo);
		String encodedPassword = bCryptPasswordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encodedPassword);
		uRep.save(usuario);		
		HashMap<String, Object> response = new HashMap<>(); 
		response.put("status", HttpStatus.OK);
		response.put("mensaje", "Usuario Creado");
		return new ResponseEntity<Object>(response, HttpStatus.OK);

	}

	@Override
	public void updateUsuario(Usuario usuario) {
		this.uRep.save(usuario);

	}

	@Override
	public void deleteUsuario(int id) {
		this.uRep.deleteById(id);
	}
	
	@Override
	public Usuario obtenerPorNombre(String nombre) {
		return this.uRep.findByNombre(nombre);
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = uRep.findByNombre(email);

		// Si existe el usuario
		if(usuario != null) {
			List<GrantedAuthority> authorities = getUserAuthority(usuario.getTipoUsuario().getNombre());
			return buildUserForAuthentication(usuario, authorities);
		}else {
			throw new UsernameNotFoundException("Nombre de usuariuo no encontrado");
		}
	}

	

	private List<GrantedAuthority> getUserAuthority(String nombre_tipo_usuario) {
		Set<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(nombre_tipo_usuario));
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		
		return grantedAuthorities;
				
	}


	private UserDetails buildUserForAuthentication(Usuario usuario, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(usuario.getNombre(), usuario.getPassword(), authorities);
	}


}
