package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
       
	Usuario findByid(int id);
	
	@Query("Select u FROM Usuario u "
			+ "JOIN FETCH u.tipoUsuario tp "
			+ "WHERE u.nombre=?1")
	Usuario findByNombre(String nombre);
	
	@Query("FROM Usuario u JOIN FETCH u.tipoUsuario")
	List<Usuario> findAll();
}
