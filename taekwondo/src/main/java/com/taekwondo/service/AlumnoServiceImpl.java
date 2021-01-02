package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;
import com.taekwondo.model.Usuario;
import com.taekwondo.repository.AlumnoRepository;
//import com.taekwondo.repository.UsuarioRepository;
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
		Usuario u = this.uRep.getOne(idUsuario);
		alumno.setUsuario(u);
		this.aRep.save(alumno);
	}                                                                          

	@Override
	public void updateAlumno(Alumno alumno, int id) {
		Alumno alumnoExistente = this.aRep.getOne(id);
		alumnoExistente.setActividadMarcial(alumno.getActividadMarcial());
		alumnoExistente.setApellidos(alumno.getApellidos());
		alumnoExistente.setCartaResponsiva(alumno.getCartaResponsiva());
		alumnoExistente.setCertificadoMedico(alumno.getCertificadoMedico());
		alumnoExistente.setFechaNacimiento(alumno.getFechaNacimiento());
		alumnoExistente.setFotografia(alumno.getFotografia());
		alumnoExistente.setGradoActividadMarcial(alumno.getGradoActividadMarcial());
		alumnoExistente.setNombre(alumno.getNombre());
		alumnoExistente.setSeguroMedico(alumno.getSeguroMedico());
	}

	@Override
	public void deleteAlumno(int id) {
		this.aRep.deleteById(id);
		
	}
	
	@Override
	public List<AlumnoDTO> getAlumnosExamen(int id) {
		return this.aRep.findByExamenId(id) ;
	}
	
	@Override
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
	public AlumnoDTO getAlumnoDto(int id) {
		return this.aRep.findByIdDto(id);
	}
	
	@Override
	public List<Usuario> alumnosSinUsuario(){
		return this.aRep.alumnosSinUsuario();
	}

	@Override
	public AlumnoDTO getAlumnoDtoUsuario(int id) {
		return this.aRep.findByUsuario(id);
	}
    
}
