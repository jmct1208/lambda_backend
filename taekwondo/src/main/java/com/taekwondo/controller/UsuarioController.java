package com.taekwondo.controller;

import java.util.HashMap;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Usuario;
import com.taekwondo.service.AlumnoService;
import com.taekwondo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService uSrv;

	@Autowired
	private AlumnoService aSrv;
	
	@GetMapping("")
	public ResponseEntity<Object> getUsuarios(
			@RequestParam Optional<String> nombre){
		if (nombre.isPresent()) {
			return new ResponseEntity<Object>(
					this.uSrv.obtenerPorLlave(null, nombre.get()), 
					HttpStatus.OK);
		} 
		else {
			return new ResponseEntity<Object>(this.uSrv.getUsuarios(), 
					HttpStatus.OK);
		}
	}
	
	@GetMapping("/sin_alumno")
	public ResponseEntity<Object> getUsuariosSinAlumno() {
		return new ResponseEntity<Object>(this.uSrv.getUsuariosSinAlumno(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUsuario(@PathVariable int id) {
		return new ResponseEntity<Object>(this.uSrv.obtenerPorLlave(id, null), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id}/alumno")
	public ResponseEntity<Object> getAlumnoDtoByUsuarioId(
			@PathVariable int id) {
		return new ResponseEntity<Object>(
				this.aSrv.getAlumnoDtoByUsuario(id), HttpStatus.OK);
	}
		
	@PostMapping("/{id}/alumno")
	public ResponseEntity<Object> createAlumno(@Valid @RequestBody 
			Alumno alumno, @PathVariable int id) {
		HashMap<String, String> response = new HashMap<String, String>();
		System.out.println(alumno);
		System.out.println(id);
		this.aSrv.createAlumno(alumno, id);
		response.put("status", "success");
		response.put("message", "Alumno creado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(
			@Valid @RequestBody Usuario usuario,
			@PathVariable int id) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.uSrv.updateUsuario(usuario, id);
		response.put("status", "success");
		response.put("message", "Usuario actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/tipo_usuario")
	public ResponseEntity<Object> updateTipoUsuario(
			@RequestBody Integer idTipo,
			@PathVariable("id") int idUsuario) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.uSrv.updateTipoUsuario(idUsuario, idTipo);
		response.put("status", "success");
		response.put("message", "Usuario actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(int id) {
		this.uSrv.deleteUsuario(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Usuario eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
