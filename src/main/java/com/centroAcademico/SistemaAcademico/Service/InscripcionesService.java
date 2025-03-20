package com.centroAcademico.SistemaAcademico.Service;

import com.centroAcademico.SistemaAcademico.Domain.Inscripciones;
import java.util.List;

public interface InscripcionesService {
    
    // Se Obtiene los registros de la tabla 
    public List<Inscripciones> getInscripciones();

    // Recupera el ristro de la tabla
    public Inscripciones getInscripciones(Inscripciones inscripciones);

    // Actualiza un registro en la tabla
    // Crea un registro en la tabla
    public void save(Inscripciones inscripciones);

    // Elimina el registro de la tabla
    public void delete(Inscripciones inscripciones);
    
}
