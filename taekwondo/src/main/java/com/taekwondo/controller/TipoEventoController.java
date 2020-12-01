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
import com.taekwondo.service.TipoEventoService;

@RestController
public class TipoEventoController {
	
	@Autowired
	private TipoEventoService tipoEventoService;
	
	@GetMapping("/tipoEvento")
	public List<TipoEvento> getTipoEventos(){
		return tipoEventoService.getTipoEventos();
	}
	
	@GetMapping("/tipoEvento/{id}")
	public ResponseEntity<Object> getTipoEvento(@PathVariable int id){
		return tipoEventoService.getTipoEvento(id);
	}
	
	@PostMapping("/tipoEvento")
	public ResponseEntity<Object> createTipoEvento(@Valid @RequestBody TipoEvento tipoEvento){
		return new ResponseEntity<Object>(tipoEventoService.createTipoEvento(tipoEvento), HttpStatus.CREATED);
	}
	
	@PutMapping("/tipoEvento/{id}")
	public void updateTipoEvento(@Valid @RequestBody TipoEvento tipoEvento, @PathVariable int id) {
		tipoEventoService.updateTipoEvento(id, tipoEvento);
	}
	
	@DeleteMapping("/tipoEvento/{id}")
	public void deleteTipoEvento(@PathVariable int id) {
		tipoEventoService.deleteTipoEvento(id);
	}
}
