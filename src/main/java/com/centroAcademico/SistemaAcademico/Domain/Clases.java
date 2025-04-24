package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;



@Data
@Entity
@Table(name = "Clases")
public class Clases implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clase")
    private Long idClase;
    
    @ManyToOne
    @JoinColumn(name = "id_horario", nullable = false)
    private Horarios idHorario;
    
    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesores idProfesor;
    
    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = false)
    private Materias idMateria;
    
    @ManyToOne
    @JoinColumn(name = "id_aula", nullable = false)
    private Materias idAula;
    
    //Pruebas por error de compilación - Anthony
    public Long getIdClase() {
        return idClase;
    }

    public void setIdClase(Long idClase) {
        this.idClase = idClase;
    }

    public Horarios getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horarios idHorario) {
        this.idHorario = idHorario;
    }

    public Profesores getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesores idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Materias getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materias idMateria) {
        this.idMateria = idMateria;
    }
}
