package com.taekwondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	Alumno findById(int id);
	
	@Query(value = "SELECT * FROM alumno WHERE usuario_id = :idUsuario", nativeQuery = true)
	Alumno getUsuarioAlumno(int idUsuario);
}
