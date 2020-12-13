package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;
import com.taekwondo.repository.AlumnoRepository;
import com.taekwondo.repository.UsuarioRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository aRep;
	
	@Autowired
	private UsuarioRepository uRep;

	@Override
	public List<AlumnoDTO> getAlumnos() {
		return aRep.findAllDto();
	}

	@Override
	public void createAlumno(Alumno alumno, int idUsuario) {
		alumno.setUsuario(this.uRep.getOne(idUsuario));
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
	
	@Override
	public List<AlumnoDTO> getAlumnosExamen(int id) {
		return this.aRep.findByExamenId(id) ;
	}
	
	public List<AlumnoDTO> getAlumnosNotExamen(int id) {
		return this.aRep.findByExamenNotId(id);
	}

	@Override
	public List<AlumnoDTO> getAlumnosEvento(int id) {
		return this.aRep.findByEventoId(id);
	}
	
	@Override
	public List<AlumnoDTO> getAlumnosNotEvento(int id) {
		return this.aRep.findByEventoNotId(id);
	}
	
	@Override
	public Alumno getAlumno(int id) {
		return this.aRep.getOne(id);
	}

	@Override
	public AlumnoDTO getAlumnoDto(int id) {
		return this.aRep.findById(id);
	}

}