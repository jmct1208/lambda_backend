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

import com.taekwondo.model.Examen;
import com.taekwondo.model.ExamenDTO;
import com.taekwondo.service.AlumnoService;
import com.taekwondo.service.ExamenService;

@RestController
public class ExamenController {

	@Autowired
	private ExamenService eSrv;
	
	@Autowired
	private AlumnoService aSrv;
	
	@GetMapping("/examenes/{id}")
	public ResponseEntity<Object> getExamen(@PathVariable int id) {
		ExamenDTO examen = this.eSrv.getExamenDto(id);
		System.out.println(examen);
		return new ResponseEntity<Object>(examen, HttpStatus.OK);
	}
	
	@GetMapping("/examenes")
	public ResponseEntity<Object> getExamenes() {
		return new ResponseEntity<Object>(this.eSrv.getExamenes(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/examenes/{id_examen}/alumnos")
	public ResponseEntity<Object> getAlumnosExamen(@PathVariable("id_examen") 
			int idExamen) {
		return new ResponseEntity<Object>(aSrv.getAlumnosExamen(idExamen), 
				HttpStatus.OK);
	}
	
	@GetMapping("examenes/{id_examen}/not_alumnos")
	public ResponseEntity<Object> getAlumnosNotExamen(@PathVariable("id_examen")
			int idExamen) {
		return new ResponseEntity<Object>(aSrv.getAlumnosNotExamen(idExamen),
				HttpStatus.OK);
	}
	
	@PostMapping("/examenes")
	public ResponseEntity<Object> createExamen(@Valid @RequestBody 
			Examen examen) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.createExamen(examen);
		response.put("status", "success");
		response.put("message", "Examen creado correctamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/examenes/{id_examen}")
	public ResponseEntity<Object> updateExamen(@Valid @RequestBody 
			Examen examen, @PathVariable("id_examen") int idExamen) {
		HashMap<String, String> response = new HashMap<String, String>();
		if(examen.getId() != idExamen) {
			response.put("status", "failure");
			response.put("message", "Los identificadores no coinciden");
			return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
		}
		this.eSrv.updateExamen(examen);
		response.put("status", "success");
		response.put("message", "Examen actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PutMapping("/examenes/{id_examen}/alumnos/{id_alumno}")
	public ResponseEntity<Object> addAlumno(@PathVariable("id_examen") 
			int idExamen, @PathVariable("id_alumno") int idAlumno) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.addAlumno(idExamen, idAlumno);
		response.put("status", "success");
		response.put("message", "Alumno añadido al examen exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/examenes/{id_examen}/alumnos/{id_alumno}")
	public ResponseEntity<Object> deleteAlumno(@PathVariable("id_examen") 
			int idExamen, @PathVariable("id_alumno") int idAlumno) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.deleteAlumno(idExamen, idAlumno);
		response.put("status", "success");
		response.put("message", "Alumno eliminado exitosamente del examen");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/examenes/{id_examen}")
	public ResponseEntity<Object> deleteExamen(@PathVariable("id_examen") 
			int id) {
		this.eSrv.deleteExamen(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Examen eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
}
