package com.taekwondo.service;

import java.util.List;
import com.taekwondo.model.*;

public interface EventoService {
	public abstract List<EventoDto> getEventos();
	public abstract EventoDto getEvento(int id);
	public abstract List<EventoDto> getEventosAlumno(int id);
	public abstract void createEvento(Evento evento, int idTipoEvento);
	public abstract void updateEvento(Evento evento, int idEvento);
	public abstract void updateTipoEvento(int idEvento, int idTipoEvento);
	public abstract void deleteEvento(int id);
	public abstract void deleteAlumno(int idEvento, int idAlumno);
	public abstract void addAlumno(int idEvento, int idAlumno);
}
