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
    name = "insertar_usuario",
    procedureName = "insertar_usuario",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_username", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombre", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apellidos", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_activo", type = String.class)
    }
)
@NamedStoredProcedureQuery(
    name = "obtener_usuarios",
    procedureName = "obtener_usuarios",
    resultClasses = Usuario.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_result", type = void.class)
    }
)
@NamedStoredProcedureQuery(
    name = "obtener_usuario_por_id",
    procedureName = "obtener_usuario_por_id",
    resultClasses = Usuario.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_cursor", type = void.class)
    }
)
@NamedStoredProcedureQuery(
    name = "actualizar_usuario",
    procedureName = "actualizar_usuario",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_username", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_password", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nombre", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_apellidos", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_activo", type = String.class)
    }
)
@NamedStoredProcedureQuery(
    name = "eliminar_usuario",
    procedureName = "eliminar_usuario",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_usuario", type = Integer.class)
    }
)



@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")

    private Long idUsuario;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correo")
    private String correo;  
    @Column(name = "activo")
    private String activo;

     @OneToMany(mappedBy = "usuario")
    private List<Rol> rol;
     
    
}
