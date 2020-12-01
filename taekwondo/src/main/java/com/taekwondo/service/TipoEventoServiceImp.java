package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> getTipoEvento(int id) {
		return new ResponseEntity<>(repoTipoEvento.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createTipoEvento(TipoEvento tipoEvento) {
		return new ResponseEntity<>(repoTipoEvento.save(tipoEvento), HttpStatus.OK);
	}

	@Override
	public void updateTipoEvento(int id, TipoEvento tipoEvento) {
		repoTipoEvento.save(tipoEvento);
		
	}

	@Override
	public void deleteTipoEvento(int id) {
		repoTipoEvento.deleteById(id);
		
	}
}
