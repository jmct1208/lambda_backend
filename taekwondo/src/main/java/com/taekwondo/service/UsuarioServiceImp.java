package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Usuario;
import com.taekwondo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository uRep;
	
	@Override
	public Usuario getUsuario(int id) {
		return this.uRep.getOne(id);
	}

	@Override
	public List<Usuario> getUsuarios() {
		return uRep.findAll();
	}

	@Override
	public void createUsuario(Usuario usuario) {
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

}
