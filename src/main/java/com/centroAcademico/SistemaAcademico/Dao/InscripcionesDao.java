package com.centroAcademico.SistemaAcademico.Dao;

import com.centroAcademico.SistemaAcademico.Domain.Inscripciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionesDao extends JpaRepository<Inscripciones, Long>{
    
}
