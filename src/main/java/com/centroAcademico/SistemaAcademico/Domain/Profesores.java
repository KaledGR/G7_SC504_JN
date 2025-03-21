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
@Table(name="profesores")
public class Profesores implements Serializable {
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_profesor")
    private Long idProfesor;
    @Column(name = "cedula_profesor")
    private String cedulaProfesor;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "codigo_profesor")
    private String codigoProfesor;
    
    
    @OneToMany(mappedBy = "profesor")
    private List<Horarios> horarios;
    
    @OneToMany(mappedBy = "profesor")
    private List<Notas> notas;

     //Pruebas por error de compilación - Anthony
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }
    
}
