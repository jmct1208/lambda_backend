package com.taekwondo.service;

import java.util.List;
import com.taekwondo.model.*;

public interface EventoService {
	public abstract EventoDto getEventoDto(int id);
	public abstract List<EventoDto> getEventos();
	public abstract List<EventoDto> getEventosAlumno(int id);
	public abstract TipoEvento getTipoEvento(int id);
	public abstract void createEvento(Evento evento);
	public abstract void updateEvento(Evento evento);
	public abstract void deleteEvento(int id);
	public abstract void deleteAlumno(int idEvento, int idAlumno);
	public abstract void addAlumno(int idEvento, int idAlumno);
	public abstract void addTipoEvento(int idEvento, int idTipoEvento);
	public abstract void deleteTipoEvento(int idEvento);
}
