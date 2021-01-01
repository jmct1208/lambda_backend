package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.*;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{
	
	@Query("SELECT new com.taekwondo.model.EventoDto(e.id, e.nombre, "
			+ "e.descripcion, e.fechaInicio, e.fechaFin, e.costo, "
			+ "e.enlaceFacebook) FROM Evento e")
	List<EventoDto> findAllDto();
	
	@Query("SELECT new com.taekwondo.model.EventoDto(e.id, e.nombre, e.descripcion, e.fechaInicio, e.fechaFin, e.costo, e.enlaceFacebook) FROM Evento e WHERE e.id=?1")
	EventoDto findById(int id);

	@Query("SELECT new com.taekwondo.model.EventoDto(e.id, e.nombre, e.descripcion, e.fechaInicio, e.fechaFin, e.costo, e.enlaceFacebook) FROM Evento e INNER JOIN e.alumnosParticipantesEvento a WHERE a.id=?1")
	List<EventoDto> findByEventoId(int id);
}
