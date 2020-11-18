package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;

public interface AlumnoService {
	
	public abstract Alumno getAlumno(int id);
	public abstract AlumnoDTO getAlumnoDto(int id);
	public abstract List<AlumnoDTO> getAlumnos();
	public abstract List<AlumnoDTO> getAlumnosExamen(int id);
	public void createAlumno(Alumno alumno);
	public void updateAlumno(Alumno alumno);
	public void deleteAlumno(int id);

}
