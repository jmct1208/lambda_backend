package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Alumno;

public interface AlumnoService {
	
	public abstract Alumno getAlumno(int id);
	public abstract Alumno getUsuarioAlumno(int id_usuario);
	public abstract List<Alumno> getAlumnos();
	public void createAlumno(Alumno alumno);
	public void updateAlumno(Alumno alumno);
	public void deleteAlumno(int id);

}
