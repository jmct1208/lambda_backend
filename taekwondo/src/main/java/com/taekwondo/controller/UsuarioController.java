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
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.Usuario;
import com.taekwondo.service.AlumnoService;
import com.taekwondo.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService uSrv;

	@Autowired
	private AlumnoService aSrv;
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Object> getUsuario(@PathVariable int id) {
		return new ResponseEntity<Object>(this.uSrv.getUsuario(id), HttpStatus.OK);
	}
	
	@GetMapping("/usuarios")
	public ResponseEntity<Object> getUsuarios(){
		return new ResponseEntity<Object>(this.uSrv.getUsuarios(), HttpStatus.OK);
	}
	
	@GetMapping("usuarios/{id}/alumno")
	public ResponseEntity<Object> getAlumnoUsuario(@PathVariable int id) {
		return new ResponseEntity<Object>(this.aSrv.getAlumnoDto(id), HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Object> createUsuario(@Valid @RequestBody Usuario usuario) { 
		
		return this.uSrv.createUsuario(usuario);
	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Object> updateUsuario(@Valid @RequestBody Usuario usuario) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.uSrv.updateUsuario(usuario);
		response.put("status", "success");
		response.put("message", "Usuario actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/{id}")
	public ResponseEntity<Object> deleteUsuario(int id) {
		this.uSrv.deleteUsuario(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Usuario eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@GetMapping("/usuario/pornombre/{nombre}")
	public ResponseEntity<Object> obtenerPorNombre(@PathVariable("nombre")String nombre) {
		return new ResponseEntity<Object>(this.uSrv.obtenerPorNombre(nombre), HttpStatus.OK);
		
	}

	
	
}
