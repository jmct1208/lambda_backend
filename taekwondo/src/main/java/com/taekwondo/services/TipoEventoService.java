package com.taekwondo.services;


import com.taekwondo.model.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface TipoEventoService {
	
	public abstract List<TipoEvento> getTipoEventos();
	public abstract ResponseEntity<Object> getTipoEvento(int id);
	public abstract ResponseEntity<Object> createTipoEvento(TipoEvento tipoEvento);
	public abstract void updateTipoEvento(int id, TipoEvento tipoEvento);
	public abstract void deleteTipoEvento(int id);

}
