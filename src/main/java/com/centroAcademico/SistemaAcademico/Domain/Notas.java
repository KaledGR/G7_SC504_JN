package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@NamedStoredProcedureQuery(
    name = "obtener_notas",
    procedureName = "pkg_notas.obtener_notas",
    resultClasses = Notas.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_result", type = void.class)
    }
)
@NamedStoredProcedureQuery(
    name = "crear_nota",
    procedureName = "pkg_notas.insertar_notas",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_profesor", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_materia", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_estudiante", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_calificacion", type = BigDecimal.class)
    }
)
@NamedStoredProcedureQuery(
    name = "actualizar_notas",
    procedureName = "pkg_notas.actualizar_notas",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_nota", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_profesor", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_materia", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_estudiante", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_calificacion", type = BigDecimal.class)
    }
)
@NamedStoredProcedureQuery(
    name = "eliminar_notas",
    procedureName = "pkg_notas.eliminar_notas",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_nota", type = Long.class)
    }
)
@NamedStoredProcedureQuery(
    name = "obtener_nota_por_id",
    procedureName = "pkg_notas.obtener_notas_por_id",
    resultClasses = Notas.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id_nota", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "p_result", type = void.class)
    }
)
@Data
@Table(name = "Notas")
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Long idNota;
    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = true)
    private Profesores profesor;

    @ManyToOne
    @JoinColumn(name = "id_materia", nullable = true)
    private Materias materia;
    @ManyToOne
    @JoinColumn(name = "id_estudiante", nullable = false)
    private Estudiante estudiante;
    @Column(name = "calificacion", precision = 5, scale = 2, nullable = false)
    private BigDecimal calificacion;
    
    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public Profesores getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesores profesor) {
        this.profesor = profesor;
    }

    public Materias getMateria() {
        return materia;
    }

    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public BigDecimal getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigDecimal calificacion) {
        this.calificacion = calificacion;
    }
    
}
