
package com.centroAcademico.SistemaAcademico.Domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Aulas")
public class Aulas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long idAula;
    
    @Column(name = "numeroaula", nullable = false)
    private String numeroAula;
    
    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;
    
    //Pruebas por error de compilación - Anthony
    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }
    
    public String getNumeroAula() { // Getter para nombre
        return numeroAula;
    }

    public void setNumeroAula(String numeroAula) { //Setter para nombre
      this.numeroAula = numeroAula;
    }
}
