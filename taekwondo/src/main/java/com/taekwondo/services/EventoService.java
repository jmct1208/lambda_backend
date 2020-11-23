package com.taekwondo.services;

import java.util.List;
import com.taekwondo.model.*;
import org.springframework.http.ResponseEntity;

public interface EventoService {
	public abstract List<Evento> getEventos();
	public abstract ResponseEntity<Object> getEvento(int id);
	public abstract ResponseEntity<Object> createEvento(Evento evento);
	public abstract void updateEvento(int id, Evento evento);
	public abstract void deleteEvento(int id);
}
