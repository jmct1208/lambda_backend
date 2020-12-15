package com.taekwondo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Usuario;
import com.taekwondo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository uRep;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Usuario getUsuario(String nombre) {
		return this.uRep.findByNombre(nombre);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return uRep.findAll();
	}

	@Override
	public void createUsuario(Usuario usuario) {
		usuario.setPassword(this.bCryptPasswordEncoder.encode(
				usuario.getPassword()));
		this.uRep.save(usuario);
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
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		Usuario usuario = this.uRep.findByNombre(username);
		if(usuario != null) {
			List<GrantedAuthority> authorities = 
					this.getUserAuthority(usuario.getTipoUsuarioString());
			return this.buildUserForAuthentication(usuario, authorities);
		} else {
			throw new UsernameNotFoundException(
					"Nombre de usuario no encontrado");
		}
	}
	
	private List<GrantedAuthority> getUserAuthority(String tipoUsuario) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(tipoUsuario));
		List<GrantedAuthority> grantedAuthorities = 
				new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(Usuario usuario, 
			List<GrantedAuthority> authorities) {
		return new User(usuario.getNombre(), usuario.getPassword(), 
				authorities);
	}
}
