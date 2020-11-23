package com.taekwondo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.*;
import com.taekwondo.services.EventoService;
import com.taekwondo.services.AlumnoService;

@RestController
public class EventoController {
	@Autowired
	private EventoService eventoService;
	

	@Autowired
	private AlumnoService aSrv;
	
	@GetMapping("/eventos")
	public List<Evento> getEventos(){
		return eventoService.getEventos();
	}
	
	@GetMapping("/eventos/{id}")
	public ResponseEntity<Object> getEvento(@PathVariable int id){
		return eventoService.getEvento(id);
	}
	
	
	@GetMapping("/eventos/{id_examen}/alumnos")
	public ResponseEntity<Object> getAlumnosExamen(@PathVariable("id_examen") int idExamen) {
		return new ResponseEntity<Object>(aSrv.getAlumnosExamen(idExamen), HttpStatus.OK);
	}
	
	@PostMapping("/eventos")
	public ResponseEntity<Object> createEvento(@Valid @RequestBody Evento evento){
		return new ResponseEntity<Object>(eventoService.createEvento(evento), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/evento/{id}")
	public void updateEvento(@Valid @RequestBody Evento evento, @PathVariable int id) {
		eventoService.updateEvento(id, evento);
	}
	
	@DeleteMapping("/evento/{id}")
	public void deleteEvento(@PathVariable int id) {
		eventoService.deleteEvento(id);
	}
	
}
