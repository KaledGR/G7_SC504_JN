
package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NamedStoredProcedureQuery ( // se definen los procedimientos almacenados que se van a utilizar 
    name = "obtener_aulas",// es que se llama no necesariamente igual al nombre del procedimiento almacenado enm la db 
    procedureName = "pkg_aulas.obtener_aulas",// este es el que esta en la db
    resultClasses = Aulas.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_result", type = void.class)
    }
    )

@NamedStoredProcedureQuery(
    name = "obtener_aulas_por_id",
    procedureName = "pkg_aulas.obtener_aulas_por_id",
    resultClasses = Aulas.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_aula", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_result", type = void.class)
    }
)

@NamedStoredProcedureQuery(
    name = "crear",
    procedureName = "pkg_aulas.crear",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_aula", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numero_Aula", type = String.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_capacidad", type = Integer.class)
    }
)
@NamedStoredProcedureQuery(
    name = "actualizar",
    procedureName = "pkg_aulas.actualizar",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_aula", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numero_Aula", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_capacidad", type = Integer.class)
    }
)
@NamedStoredProcedureQuery(
    name = "eliminar",
    procedureName = "pkg_aulas.eliminar",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_aula", type = Long.class)
    }
)

@Data
@Table(name = "Aulas")
public class Aulas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long idAula;
    
    @Column(name = "numero_aula", nullable = false)
    private String numeroAula;
    
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
    
    //Pruebas por error de compilación - Anthony
    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public String getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(String numeroAula) {
        this.numeroAula = numeroAula;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
