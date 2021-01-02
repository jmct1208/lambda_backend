package com.taekwondo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Evento;
import com.taekwondo.model.Examen;
import com.taekwondo.model.ExamenDTO;
import com.taekwondo.repository.AlumnoRepository;
import com.taekwondo.repository.ExamenRepository;

@Service
public class ExamenServiceImpl implements ExamenService{
	
	@Autowired
	private ExamenRepository eRep;
	
	@Autowired 
	private AlumnoRepository aRep;
	
	@Override
	public List<ExamenDTO> getExamenes() {
		return this.eRep.findAllDto();
	}

	@Override
	public void createExamen(Examen examen) {
		this.eRep.save(examen);
	}

	@Override
	public void updateExamen(Examen examen, int id) {
		Examen examenExistente = this.eRep.getOne(id);
		examenExistente.setCosto(examen.getCosto());
		examenExistente.setEnlaceFacebook(examen.getEnlaceFacebook());
		examenExistente.setFechaHora(examen.getFechaHora());
		examenExistente.setNombre(examen.getNombre());
		examenExistente.setSolicitudExamen(examen.getSolicitudExamen());
		examenExistente.setTipo(examen.getTipo());
	}

	@Override
	@Transactional
	public void addAlumno(int idExamen, int idAlumno) {
		Examen examen = this.eRep.findByIdWithAlumnos(idExamen);
		Alumno alumno = this.aRep.findByIdWithExamenes(idAlumno);
		System.out.println(examen);
		System.out.println(examen.getAlumnosParticipantes());
		examen.getAlumnosParticipantes().add(alumno);
		alumno.getExamenesParticipados().add(examen);
	}

	@Override
	@Transactional
	public void deleteAlumno(int idExamen, int idAlumno) {
		Examen examen = this.eRep.findByIdWithAlumnos(idExamen);
		Alumno alumno = this.aRep.findByIdWithEventos(idAlumno);
		examen.getAlumnosParticipantes().remove(alumno);
		alumno.getExamenesParticipados().remove(examen);
	}

	@Override
	public void deleteExamen(int id) {
		this.eRep.deleteById(id);
	}

	@Override
	public List<ExamenDTO> getExamenesAlumno(int id) {
		return this.eRep.findByAlumnoId(id);
	}

	@Override
	public ExamenDTO getExamenDto(int id) {
		return this.eRep.findByIdDto(id);
	}

}
