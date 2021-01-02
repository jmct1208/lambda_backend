package com.taekwondo.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.http.ResponseEntity;

import com.taekwondo.model.Usuario;

public interface UsuarioService {
	public abstract Usuario getUsuario(int id);
	public abstract List<Usuario> getUsuarios();
	public ResponseEntity<Object> createUsuario(Usuario usuario, int idRol);
	public void updateUsuario(Usuario usuario, int idUsuario, int idRol);
	public void deleteUsuario(int id);
	public abstract UserDetails loadUserByUsername(String email);
	public abstract Usuario obtenerPorNombre(String nombre);


}
