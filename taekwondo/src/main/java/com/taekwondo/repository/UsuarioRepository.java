package com.taekwondo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
       
	Usuario findByid(int id);
	
	//@Query(value = "SELECT u FROM USUARIO u LEFT JOIN FETCH u.nombre e WHERE e.usuario = ?1",nativeQuery = true)
	Usuario findByNombre(String nombre);
	
	@Query(value="SELECT a1 FROM Usuario a1 NATURAL JOIN a1.usuario e",nativeQuery = true)
	ArrayList<Usuario> usuarioSinAlumno();
}
