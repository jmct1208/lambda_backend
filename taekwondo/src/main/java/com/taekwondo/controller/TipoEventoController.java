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
import com.taekwondo.service.TipoEventoService;

@RestController
@RequestMapping("/tipos_evento")
public class TipoEventoController {
	
	@Autowired
	private TipoEventoService tipoEventoService;
	
	@Autowired
	private EventoService eSrv;
	
	@GetMapping("")
	public ResponseEntity<Object> getTipoEventos(){
		return new ResponseEntity<Object>(this.tipoEventoService.
				getTipoEventos(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getTipoEvento(@PathVariable int id){
		return new ResponseEntity<Object>(this.tipoEventoService.
				getTipoEvento(id), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createTipoEvento(@Valid @RequestBody 
			TipoEvento tipoEvento){
		HashMap<String, String> response = new HashMap<String, String>();
		this.tipoEventoService.createTipoEvento(tipoEvento);
		response.put("status", "success");
		response.put("message", "Tipo de evento creado exitosamente.");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}/eventos")
	public ResponseEntity<Object> createEvento(@Valid @RequestBody 
			Evento evento, @PathVariable int id) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.createEvento(evento, id);
		response.put("status", "success");
		response.put("message", "Evento creado correctamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTipoEvento(@Valid @RequestBody
			TipoEvento tipoEvento, @PathVariable int id) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.tipoEventoService.updateTipoEvento(tipoEvento, id);
		response.put("status", "success");
		response.put("message", "Tipo de evento actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteTipoEvento(@PathVariable int id) {
		this.tipoEventoService.deleteTipoEvento(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Tipo de evento eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
