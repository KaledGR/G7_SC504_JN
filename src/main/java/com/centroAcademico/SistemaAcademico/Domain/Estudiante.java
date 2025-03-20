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
@Table(name = "estudiantes")
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")

    private Long idEstudiante;

    @Column(name = "cedula_estudiante")
    private String cedulaEstudiante;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "codigo_estudiante")
    private String codigoEstudiante;
    
     @OneToMany(mappedBy = "estudiante")
    private List<Congelamiento> congelamientos;
     
     @OneToMany(mappedBy = "estudiante")
    private List<Archivos> archivos;
     
     @OneToMany(mappedBy = "estudiante")
    private List<Notas> notas;
     
     //Pruebas por error de compilación - Anthony
    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

}
