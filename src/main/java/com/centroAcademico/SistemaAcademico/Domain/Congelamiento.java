package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.time.LocalDate;

@Entity
@NamedStoredProcedureQuery(
name = "crear_congelamiento",// es que se llama no necesariamente igual al nombre del procedimiento almacenado enm la db
procedureName = "pkg_congelamiento.crear",// este es el que esta en la db 
parameters = { // estos son los parametros que recibe el procedimiento almacenado
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_congelamiento", type = Long.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_estudiante", type = Long.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecha_complemento", type = String.class)
}
)
@NamedStoredProcedureQuery(
name = "actualizar_congelamiento",// es que se llama no necesariamente igual al nombre del procedimiento almacenado enm la db
procedureName = "pkg_congelamiento.actualizar",// este es el que esta en la db 
parameters = { // estos son los parametros que recibe el procedimiento almacenado
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_congelamiento", type = Long.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_estudiante", type = Long.class),
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecha_complemento", type = String.class)
}
)
@NamedStoredProcedureQuery(
name = "eliminar_congelamiento",// es que se llama no necesariamente igual al nombre del procedimiento almacenado enm la db
procedureName = "pkg_congelamiento.eliminar",// este es el que esta en la db 
parameters = { // estos son los parametros que recibe el procedimiento almacenado
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_congelamiento", type = Long.class),
 }
)
@NamedStoredProcedureQuery(
name = "obtener_congelamiento",// es que se llama no necesariamente igual al nombre del procedimiento almacenado enm la db
procedureName = "pkg_congelamiento.obtener",// este es el que esta en la db 
parameters = { // estos son los parametros que recibe el procedimiento almacenado
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_congelamiento", type = Long.class),
 }
)




@Data
@Table(name = "congelamiento")
public class Congelamiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_congelamiento")
    private Long idCongelamiento;
   
    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;
    
    @Column(name = "fecha_complemento", nullable = false)
    private String fechaComplemento;
    
    //Pruebas por error de compilación - Anthony
    
}
