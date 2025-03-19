package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Notas")
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;

    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_profesor", nullable = false)
    private Profesores profesor;

    @ManyToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", nullable = false)
    private Materias materia;

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante", nullable = false)
    private Estudiante estudiante;

    @Column(name = "calificacion", precision = 5, scale = 2, nullable = false)
    private BigDecimal calificacion;
}
