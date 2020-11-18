package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.AlumnoDTO;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, a.apellidos, a.fechaNacimiento, a.fotografia, a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, a.certificadoMedico, a.cartaResponsiva) FROM Alumno a")
	List<AlumnoDTO> findAllDto();
	
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, a.apellidos, a.fechaNacimiento, a.fotografia, a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, a.certificadoMedico, a.cartaResponsiva) From Alumno a WHERE a.id=?1")
	AlumnoDTO findById(int id);
		
	@Query("SELECT new com.taekwondo.model.AlumnoDTO(a.id, a.nombre, a.apellidos, a.fechaNacimiento, a.fotografia, a.actividadMarcial, a.seguroMedico, a.gradoActividadMarcial, a.certificadoMedico, a.cartaResponsiva) From Alumno a INNER JOIN a.examenesParticipados e WHERE e.id=?1")
	List<AlumnoDTO> findByExamenId(int id);
}
