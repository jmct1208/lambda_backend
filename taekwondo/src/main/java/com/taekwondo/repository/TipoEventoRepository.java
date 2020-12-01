package com.taekwondo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.*;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Integer>{

}
