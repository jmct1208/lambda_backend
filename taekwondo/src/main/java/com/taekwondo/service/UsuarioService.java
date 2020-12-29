package com.taekwondo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.taekwondo.model.Usuario;

public interface UsuarioService extends UserDetailsService {
	public abstract Usuario getUsuario(String nombre);
	public abstract List<Usuario> getUsuarios();
	public abstract List<Usuario> getUsuariosSinAlumno();
	public void createUsuario(Usuario usuario);
	public void updateUsuario(Usuario usuario);
	public void deleteUsuario(int id);
}
