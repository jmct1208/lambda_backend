package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNombre(String nombre);
	
	@Query("SELECT u FROM Usuario u WHERE u.id NOT IN(" +
		   "SELECT u1.id FROM Alumno a INNER JOIN a.usuario u1)" +
		   "AND u.tipoUsuario = FALSE")
	List<Usuario> findByNoAlumno();
}
