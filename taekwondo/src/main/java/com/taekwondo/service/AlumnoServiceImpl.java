package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Alumno;
import com.taekwondo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository aRep;

	@Override
	public Alumno getAlumno(int id) {
		return this.aRep.findById(id);
	}

	@Override
	public Alumno getUsuarioAlumno(int id_usuario) {
		return this.aRep.getUsuarioAlumno(id_usuario);
	}

	@Override
	public List<Alumno> getAlumnos() {
		return aRep.findAll();
	}

	@Override
	public void createAlumno(Alumno alumno) {
		this.aRep.save(alumno);
		
	}

	@Override
	public void updateAlumno(Alumno alumno) {
		this.aRep.save(alumno);
		
	}

	@Override
	public void deleteAlumno(int id) {
		this.aRep.deleteById(id);
		
	}

}
