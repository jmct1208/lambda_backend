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

import com.taekwondo.model.Examen;
import com.taekwondo.model.ExamenDTO;
import com.taekwondo.service.AlumnoService;
import com.taekwondo.service.ExamenService;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

	@Autowired
	private ExamenService eSrv;
	
	@Autowired
	private AlumnoService aSrv;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getExamen(@PathVariable int id) {
		ExamenDTO examen = this.eSrv.getExamenDto(id);
		return new ResponseEntity<Object>(examen, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getExamenes() {
		return new ResponseEntity<Object>(this.eSrv.getExamenes(), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id_examen}/alumnos")
	public ResponseEntity<Object> getAlumnosExamen(@PathVariable("id_examen") 
			int idExamen) {
		return new ResponseEntity<Object>(aSrv.getAlumnosExamen(idExamen), 
				HttpStatus.OK);
	}
	
	@GetMapping("/{id_examen}/not_alumnos")
	public ResponseEntity<Object> getAlumnosNotExamen(@PathVariable("id_examen")
			int idExamen) {
		return new ResponseEntity<Object>(aSrv.getAlumnosNotExamen(idExamen),
				HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createExamen(@Valid @RequestBody 
			Examen examen) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.createExamen(examen);
		response.put("status", "success");
		response.put("message", "Examen creado correctamente");
		return new ResponseEntity<Object>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateExamen(@Valid @RequestBody 
			Examen examen, @PathVariable int id) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.updateExamen(examen);
		response.put("status", "success");
		response.put("message", "Examen actualizado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{id_examen}/alumnos/{id_alumno}")
	public ResponseEntity<Object> addAlumno(@PathVariable("id_examen") 
			int idExamen, @PathVariable("id_alumno") int idAlumno) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.addAlumno(idExamen, idAlumno);
		response.put("status", "success");
		response.put("message", "Alumno añadido al examen exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_examen}/alumnos/{id_alumno}")
	public ResponseEntity<Object> deleteAlumno(@PathVariable("id_examen") 
			int idExamen, @PathVariable("id_alumno") int idAlumno) {
		HashMap<String, String> response = new HashMap<String, String>();
		this.eSrv.deleteAlumno(idExamen, idAlumno);
		response.put("status", "success");
		response.put("message", "Alumno eliminado exitosamente del examen");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_examen}")
	public ResponseEntity<Object> deleteExamen(@PathVariable("id_examen") 
			int id) {
		this.eSrv.deleteExamen(id);
		HashMap<String, String> response = new HashMap<String, String>();
		response.put("status", "success");
		response.put("message", "Examen eliminado exitosamente");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
}
