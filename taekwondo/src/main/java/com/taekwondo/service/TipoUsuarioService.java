package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.TipoUsuario;

public interface TipoUsuarioService {
	public abstract TipoUsuario getTipoUsuario(int id);
	public abstract List<TipoUsuario> getTiposUsuario();
}
