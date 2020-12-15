package com.taekwondo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.taekwondo.model.Usuario;

public interface UsuarioService {
	public abstract Usuario getUsuario(String nombre);
	public abstract List<Usuario> getUsuarios();
	public void createUsuario(Usuario usuario);
	public void updateUsuario(Usuario usuario);
	public void deleteUsuario(int id);
	public abstract UserDetails loadUserByUsername(String username);
}
