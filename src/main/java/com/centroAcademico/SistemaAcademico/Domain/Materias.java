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
@Table(name="materias")
public class Materias implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_materia")
    private Long idMateria;
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "codigo_materia")
    private String codigoMateria;
    
    
     @OneToMany
    @JoinColumn(name="id_materia", updatable=false)
    private List<Horarios> horarios;
}
