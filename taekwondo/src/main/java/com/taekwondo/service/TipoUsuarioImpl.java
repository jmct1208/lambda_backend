package com.taekwondo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.taekwondo.model.TipoUsuario;
import com.taekwondo.repository.TipoUsuarioRepository;

public class TipoUsuarioImpl implements TipoUsuarioService {
	@Autowired
	private TipoUsuarioRepository tRep;
	public TipoUsuario getTipoUsuario(int id) {
		return this.tRep.findByid(id);
	}

}
