package com.taekwondo.service;


import com.taekwondo.model.*;
import java.util.List;

public interface TipoEventoService {
	
	public abstract List<TipoEvento> getTipoEventos();
	public abstract TipoEvento getTipoEvento(int id);
	public abstract void createTipoEvento(TipoEvento tipoEvento);
	public abstract void updateTipoEvento(TipoEvento tipoEvento);
	public abstract void deleteTipoEvento(int id);

}
