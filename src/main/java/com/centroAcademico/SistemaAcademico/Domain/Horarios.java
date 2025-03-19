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

    @Column(name = "id_profesor")
    private int idProfesor;

    @Column(name = "id_materia")
    private int idMateria;

}
