package com.centroAcademico.SistemaAcademico.Service;

import java.util.List;
import com.centroAcademico.SistemaAcademico.Domain.Aulas;

public interface AulasService {
    
    // Se Obtiene los registros de la tabla 
    public List<Aulas> getAulas();

    // Recupera el ristro de la tabla
    public Aulas getAulas(Aulas aulas);

    // Actualiza un registro en la tabla
    // Crea un registro en la tabla
    public void save(Aulas aulas);

    // Elimina el registro de la tabla
    public void delete(Aulas aulas);

}
