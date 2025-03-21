package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Congelamiento")
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
    public Long getIdCongelamiento() {
        return idCongelamiento;
    }

    public void setIdCongelamiento(Long idCongelamiento) {
        this.idCongelamiento = idCongelamiento;
    }
}
