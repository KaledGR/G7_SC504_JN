package com.centroAcademico.SistemaAcademico.Domain;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "archivos")

public class Inscripciones implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materia")
    private Long idMateria;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;
    
    //Pruebas por error de compilación - Anthony
    public Long getIdInscripciones() {
        return idMateria;
    }

    public void setIdInscripciones(Long idMateria) {
        this.idMateria = idMateria;
    }
    
}
