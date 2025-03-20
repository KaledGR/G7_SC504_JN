package com.centroAcademico.SistemaAcademico.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroAcademico.SistemaAcademico.Domain.Congelamiento;
import com.centroAcademico.SistemaAcademico.Domain.Materias;

public interface CongelamientoDao extends JpaRepository<Congelamiento, Long> {

}
