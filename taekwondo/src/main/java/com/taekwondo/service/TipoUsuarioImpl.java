package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.TipoUsuario;
import com.taekwondo.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioImpl implements TipoUsuarioService {
	@Autowired
	private TipoUsuarioRepository tRep;
	public TipoUsuario getTipoUsuario(int id) {
		return this.tRep.findByid(id);
	}
	
	public List<TipoUsuario> getTiposUsuario() {
		return this.tRep.findAll();
	}

}
