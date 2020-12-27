package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;
import com.taekwondo.model.Usuario;

public interface AlumnoService {
	
	public abstract Alumno getAlumno(int id);
	public abstract AlumnoDTO getAlumnoDto(int id);
	public abstract List<AlumnoDTO> getAlumnos();
	public abstract List<AlumnoDTO> getAlumnosExamen(int id);
	public abstract List<AlumnoDTO> getAlumnosNotExamen(int id);
	public abstract List<AlumnoDTO> getAlumnosEvento(int id);
	public abstract List<AlumnoDTO> getAlumnosNotEvento(int id);
	public abstract List<Usuario> alumnosSinUsuario();
	public void createAlumno(Alumno alumno, int idUsuario);
	public void updateAlumno(Alumno alumno);
	public void deleteAlumno(int id);
}
