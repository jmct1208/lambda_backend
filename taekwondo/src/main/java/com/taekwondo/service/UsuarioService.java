package com.taekwondo.service;

import java.util.List;


import com.taekwondo.model.Usuario;

public interface UsuarioService {
	public abstract Usuario getUsuario(int id);
	public abstract List<Usuario> getUsuarios();
	public void createUsuario(Usuario usuario);
	public void updateUsuario(Usuario usuario);
	public void deleteUsuario(int id);
}
