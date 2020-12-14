package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.TipoEvento;
import com.taekwondo.repository.TipoEventoRepository;

@Service
public class TipoEventoServiceImp implements TipoEventoService{
	@Autowired
	private TipoEventoRepository repoTipoEvento;

	@Override
	public List<TipoEvento> getTipoEventos() {
		return repoTipoEvento.findAll();
	}

	@Override
	public TipoEvento getTipoEvento(int id) {
		return this.repoTipoEvento.getOne(id);
	}

	@Override
	public void createTipoEvento(TipoEvento tipoEvento) {
		this.repoTipoEvento.save(tipoEvento);
	}

	@Override
	public void updateTipoEvento(TipoEvento tipoEvento) {
		repoTipoEvento.save(tipoEvento);
		
	}

	@Override
	public void deleteTipoEvento(int id) {
		repoTipoEvento.deleteById(id);
		
	}
}
