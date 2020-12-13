package com.taekwondo.service;

import java.util.List;

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
	public void updateEvento(Evento evento) {
		repoEvento.save(evento);
		
	}

	@Override
	public void deleteEvento(int id) {
		repoEvento.deleteById(id);
		
	}

	@Override
	public EventoDto getEventoDto(int id) {
		return this.repoEvento.findById(id);
	}

	@Override
	public List<EventoDto> getEventosAlumno(int id) {
		return this.repoEvento.findByEventoId(id);
	}

	@Override
	public void createEvento(Evento evento) {
		this.repoEvento.save(evento);
	}

	@Override
	@Transactional
	public void deleteAlumno(int idEvento, int idAlumno) {
		Evento evento = this.repoEvento.getOne(idEvento);
		Alumno alumno = this.aRep.getOne(idAlumno);
		evento.getAlumnosParticipantesEvento().remove(alumno);
		alumno.getEventosParticipados().remove(evento);
		this.repoEvento.save(evento);
		this.aRep.save(alumno);
	}

	@Override
	public void addAlumno(int idEvento, int idAlumno) {
		Evento evento = this.repoEvento.getOne(idEvento);
		Alumno alumno = this.aRep.getOne(idAlumno);
		evento.getAlumnosParticipantesEvento().add(alumno);
		alumno.getEventosParticipados().add(evento);
		this.repoEvento.save(evento);
		this.aRep.save(alumno);
	}

	@Override
	public TipoEvento getTipoEvento(int id) {
		Evento evento = this.repoEvento.getOne(id);
		return evento.getTipoEvento();
	}

	@Override
	@Transactional
	public void addTipoEvento(int idEvento, int idTipoEvento) {
		Evento evento = this.repoEvento.getOne(idEvento);
		TipoEvento tipoEvento = this.tERep.getOne(idTipoEvento);
		evento.setTipoEvento(tipoEvento);
	}

	@Override
	public void deleteTipoEvento(int idEvento) {
		Evento evento = this.repoEvento.getOne(idEvento);
		evento.setTipoEvento(null);
	}

}
