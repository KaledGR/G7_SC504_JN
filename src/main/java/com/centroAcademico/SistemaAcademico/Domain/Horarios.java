/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "horarios")
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long idHorario;

    @Column(name = "dia_semana")
    private String diaSemana;
    @Column(name = "horario_inc")
    private String horarioInc;
    @Column(name = "horario_fin")
    private String horarioFin;
//
//    @Column(name = "id_profesor")
//    private Long idProfesor;
//
//    @Column(name = "id_materia")
//    private Long idMateria;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = true)
    private Profesores profesor;
    
    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = true)
    private Materias materia;
    
     //Pruebas por error de compilación - Anthony
    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }
}
