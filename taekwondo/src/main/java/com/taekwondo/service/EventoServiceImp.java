package com.taekwondo.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Evento;
import com.taekwondo.model.EventoDto;
import com.taekwondo.model.TipoEvento;
import com.taekwondo.repository.AlumnoRepository;
import com.taekwondo.repository.EventoRepository;
import com.taekwondo.repository.TipoEventoRepository;

@Service
public class EventoServiceImp implements EventoService{
	
	@Autowired
	private EventoRepository repoEvento;
	
	@Autowired
	private AlumnoRepository aRep;
	
	@Autowired 
	private TipoEventoRepository tERep;

	@Override
	public List<EventoDto> getEventos() {
		return this.repoEvento.findAllDto();
	}

	@Override
	@Transactional
	public void updateEvento(Evento evento, int idEvento, int idTipoEvento) {
		Evento eventoExistente = this.repoEvento.getOne(idEvento);
		eventoExistente.setCosto(evento.getCosto());
		eventoExistente.setDescripcion(evento.getDescripcion());
		eventoExistente.setEnlaceFacebook(evento.getEnlaceFacebook());
		eventoExistente.setFechaFin(evento.getFechaFin());
		eventoExistente.setFechaInicio(evento.getFechaInicio());
		eventoExistente.setNombre(evento.getNombre());
		eventoExistente.setTipoEvento(tERep.getOne(idTipoEvento));
	}

	@Override
	public void deleteEvento(int id) {
		repoEvento.deleteById(id);
		
	}

	@Override
	public List<EventoDto> getEventosAlumno(int id) {
		return this.repoEvento.findByEventoId(id);
	}

	@Override
	@Transactional
	public void createEvento(Evento evento, int idTipoEvento) {
		evento.setTipoEvento(tERep.getOne(idTipoEvento));
		this.repoEvento.save(evento);
	}

	@Override
	@Transactional
	public void deleteAlumno(int idEvento, int idAlumno) {
		Evento evento = this.repoEvento.findByIdWithAlumnos(idEvento);
		Alumno alumno = this.aRep.findByIdWithEventos(idAlumno);
		evento.getAlumnosParticipantesEvento().remove(alumno);
		alumno.getEventosParticipados().remove(evento);
	}

	@Override
	@Transactional
	public void addAlumno(int idEvento, int idAlumno) {
		Evento evento = this.repoEvento.findByIdWithAlumnos(idEvento);
		Alumno alumno = this.aRep.findByIdWithEventos(idAlumno);
		evento.getAlumnosParticipantesEvento().add(alumno);
		alumno.getEventosParticipados().add(evento);
	}
}
