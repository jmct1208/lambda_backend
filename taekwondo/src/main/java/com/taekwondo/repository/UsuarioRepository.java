package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
       	
	@Query("Select u FROM Usuario u "
			+ "JOIN FETCH u.tipoUsuario "
			+ "WHERE (?1 IS NULL OR u.id = CAST(CAST(?1 as string) as int)) "
			+ "AND (?2 IS NULL OR u.nombre=?2) ")
	Usuario findByKey(Integer id, String nombre);
	
	@Query("Select u FROM Usuario u JOIN FETCH u.tipoUsuario")
	List<Usuario> findAll();
	
	@Query("FROM Usuario u JOIN FETCH u.tipoUsuario t_u "
			+ "WHERE u.id NOT IN "
			+ "(SELECT u1.id FROM Alumno e INNER JOIN e.usuario u1)"
			+ "AND t_u.nombre = 'ALUMNO'")
	List<Usuario> usuariosSinAlumno();
}
