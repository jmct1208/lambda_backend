package com.taekwondo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Examen;
import com.taekwondo.model.ExamenDTO;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {
	@Query("SELECT new com.taekwondo.model.ExamenDTO(e.id, e.nombre, e.tipo, e.fechaHora, e.costo, e.enlaceFacebook, e.solicitudExamen) FROM Examen e")
	List<ExamenDTO> findAllDto();
	
	@Query("SELECT new com.taekwondo.model.ExamenDTO(e.id, e.nombre, e.tipo, e.fechaHora, e.costo, e.enlaceFacebook, e.solicitudExamen) FROM Examen e WHERE e.id=?1")
	ExamenDTO findById(int id);
	
	
	@Query("SELECT new com.taekwondo.model.ExamenDTO(e.id, e.nombre, e.tipo, e.fechaHora, e.costo, e.enlaceFacebook, e.solicitudExamen) FROM Examen e INNER JOIN e.alumnosParticipantes a WHERE a.id=?1")
	List<ExamenDTO> findByAlumnoId(int id);
}
