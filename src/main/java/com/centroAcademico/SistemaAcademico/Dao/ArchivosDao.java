package com.centroAcademico.SistemaAcademico.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroAcademico.SistemaAcademico.Domain.Congelamientos;
import com.centroAcademico.SistemaAcademico.Domain.Archivos;

public interface ArchivosDao extends JpaRepository<Archivos, Long> {

}
