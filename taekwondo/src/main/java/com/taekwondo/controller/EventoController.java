package com.taekwondo.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.*;
import com.taekwondo.service.EventoService;
import com.taekwondo.service.AlumnoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	@Autowired
	private EventoService eventoService;

	
	@Autowired
	private AlumnoService aSrv;
	
	@GetMapping("")
	public ResponseEntity<Object> getEventos(){
		return new ResponseEntity<Object>(this.eventoService.getEventos(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id_evento}/alumnos")
	public ResponseEntity<Object> getAlumnosEvento(@PathVariable("id_evento") 
			int idEvento) {
		return new ResponseEntity<Object>(aSrv.getAlumnosEvento(idEvento), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id_evento}/not_alumnos")
	public ResponseEntity<Object> getAlumnosNotEvento(@PathVariable("id_evento")
			int idEvento) {
		return new ResponseEntity<Object>(aSrv.getAlumnosNotEvento(idEvento),
				HttpStatus.OK);
	}
	
	@PostMapping("/tipo_evento/{id_tipo_evento}")
	public ResponseEntity<Object> createEvento(@Valid @RequestBody 
			Evento evento, @PathVariable("id_tipo_evento") int idTipoEvento) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eventoService.createEvento(evento, idTipoEvento);
		response.put("status", "success");
		response.put("message", "Evento creado correctamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id_evento}/tipo_evento/{id_tipo_evento}")
	public ResponseEntity<Object> updateEvento(@Valid @RequestBody 
			Evento evento, @PathVariable("id_evento") int idEvento,
			@PathVariable("id_tipo_evento") int idTipoEvento) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eventoService.updateEvento(evento, idEvento, idTipoEvento);
		response.put("status", "success");
		response.put("message", "Evento actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEvento(@PathVariable int id) {
		HashMap<String, String> response = new HashMap<String, String>();
		eventoService.deleteEvento(id);
		response.put("status", "success");
		response.put("message", "Evento eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{id_evento}/alumnos/{id_alumno}")
	public ResponseEntity<Object> addAlumno(@PathVariable("id_evento") 
			int idEvento, @PathVariable("id_alumno") int idAlumno) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eventoService.addAlumno(idEvento, idAlumno);
		response.put("status", "success");
		response.put("message", "Alumno agregado exitosamente al evento");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_evento}/alumnos/{id_alumno}")
	public ResponseEntity<Object> deleteAlumno(@PathVariable("id_evento") 
			int idEvento, @PathVariable("id_alumno") int idAlumno) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eventoService.deleteAlumno(idEvento, idAlumno);
		response.put("status", "success");
		response.put("message", "Alumno eliminado exitosamente del evento");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
