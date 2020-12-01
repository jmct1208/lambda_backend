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

import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;
import com.taekwondo.service.AlumnoService;
import com.taekwondo.service.ExamenService;

@RestController
public class AlumnoController {
	
	@Autowired
	private AlumnoService aSrv;
	
	@Autowired
	private ExamenService eSrv;
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<Object> getAlumno(@PathVariable int id) {
		AlumnoDTO alumno = this.aSrv.getAlumnoDto(id);
		return new ResponseEntity<Object>(alumno, HttpStatus.OK);
	}
	
	@GetMapping("/alumno")
	public ResponseEntity<Object> getAlumnos() {
		return new ResponseEntity<Object>(this.aSrv.getAlumnos(), HttpStatus.OK);
	}
	
	@GetMapping("/alumno/{id_alumno}/examenes")
	public ResponseEntity<Object> getExamenesAlumno(@PathVariable("id_alumno") int idAlumno) {
		return new ResponseEntity<Object>(eSrv.getExamenesAlumno(idAlumno), HttpStatus.OK);
	}
	
	@PostMapping("/alumno")
	public ResponseEntity<Object> createAlumno(@Valid @RequestBody Alumno alumno, @PathVariable("id_usuario") int idUsuario) {
		HashMap<String, String> response = new HashMap<String, String>();
		
		if(alumno.getIdUsuario() != idUsuario) {
			response.put("status", "failure");
			response.put("message", "Los identificadores del usuario no coinciden");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
		
		this.aSrv.createAlumno(alumno);
		response.put("status", "success");
		response.put("message", "Alumno creado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}

	@PutMapping("/alumno/{id}")
	public ResponseEntity<Object> updateAlumno(@Valid @RequestBody Alumno alumno, @PathVariable int id) {
		HashMap<String, String> response = new HashMap<String, String>();
		if(alumno.getId() != id) {
			response.put("status", "failure");
			response.put("message", "Los identificadores no coinciden");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
		this.aSrv.updateAlumno(alumno);
		response.put("status", "success");
		response.put("message", "Alumno actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/alumno/{id}")
	public ResponseEntity<Object> deleteAlumno(@PathVariable int id){
		this.aSrv.deleteAlumno(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Alumno eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
