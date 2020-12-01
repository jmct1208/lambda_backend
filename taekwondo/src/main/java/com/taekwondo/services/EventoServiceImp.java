package com.taekwondo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Evento;
import com.taekwondo.repository.EventoRepository;

@Service
public class EventoServiceImp implements EventoService{
	
	@Autowired
	private EventoRepository repoEvento;

	@Override
	public List<Evento> getEventos() {
		return repoEvento.findAll();
	}

	@Override
	public ResponseEntity<Object> getEvento(int id) {
		return new ResponseEntity<>(repoEvento.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createEvento(Evento evento) {
		return new ResponseEntity<>(repoEvento.save(evento), HttpStatus.OK);
	}

	@Override
	public void updateEvento(int id, Evento evento) {
		repoEvento.save(evento);
		
	}

	@Override
	public void deleteEvento(int id) {
		repoEvento.deleteById(id);
		
	}

}
