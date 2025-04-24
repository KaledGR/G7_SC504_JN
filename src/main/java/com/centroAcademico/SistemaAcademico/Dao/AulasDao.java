package com.centroAcademico.SistemaAcademico.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroAcademico.SistemaAcademico.Domain.Aulas;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AulasDao extends JpaRepository<Aulas, Long>{
    @Procedure(name = "crear")
    void insertarAula(
            @Param("p_id_aula") Long idAula,
            @Param("p_numero_Aula") String numeroAula,
            @Param("p_capacidad") Integer capacidad
    );

    @Procedure(name = "actualizar")
    void actualizarAula(
            @Param("p_id_aula") Long idAula,
            @Param("p_numero_Aula") String numeroAula,
            @Param("p_capacidad") Integer capacidad
    );

    @Procedure(name = "eliminar")
    void eliminar(@Param("p_id_aula") Long idAula);

    @Procedure(name = "obtener_aulas")
    List<Aulas> getAulas();
    
    @Procedure(name = "obtener_aulas_por_id")
    List<Aulas> getAula(@Param("p_id_aula") Long idAula);

}
