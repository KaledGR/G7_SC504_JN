package com.centroAcademico.SistemaAcademico.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroAcademico.SistemaAcademico.Domain.Aulas;


public interface AulasDao extends JpaRepository<Aulas, Long>{
    
}
