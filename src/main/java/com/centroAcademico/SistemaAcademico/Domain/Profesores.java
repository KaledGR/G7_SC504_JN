/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedStoredProcedureQuery(
    name = "sp_profesores",
    procedureName = "sp_profesores",
    resultClasses = Profesores.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class)
    }
)

@NamedStoredProcedureQuery(
    name = "sp_obtener_profesor",
    procedureName = "sp_obtener_profesor",
    resultClasses = Profesores.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_profesor", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_result", type = void.class)
    }
)

@NamedStoredProcedureQuery(
    name = "insertar_profesor",
    procedureName = "insertar_profesor",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedula", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombre", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apellido", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codigo_profesor", type = String.class)
    }
)

@NamedStoredProcedureQuery(
    name = "sp_actualizar_profesor",
    procedureName = "sp_actualizar_profesor",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_profesor", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cedula_profesor", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombre", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apellido", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codigo_profesor", type = String.class)
    }
)

@NamedStoredProcedureQuery(
    name = "sp_eliminar_profesor",
    procedureName = "sp_eliminar_profesor",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_profesor", type = Integer.class)
    }
)

@Data

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
   
    
}
