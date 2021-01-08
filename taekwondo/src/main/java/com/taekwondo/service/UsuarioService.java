package com.taekwondo.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.http.ResponseEntity;

import com.taekwondo.model.Usuario;

public interface UsuarioService {
	public abstract Usuario obtenerPorLlave(Integer id, String nombre);
	public abstract List<Usuario> getUsuarios();
	public abstract List<Usuario> getUsuariosSinAlumno();
	public ResponseEntity<Object> createUsuario(Usuario usuario, int idTipo);
	public void updateUsuario(Usuario usuario, int id);
	public void updateTipoUsuario(int idUsuario, int idTipo);
	public void deleteUsuario(int id);
	public abstract UserDetails loadUserByUsername(String email);


}
