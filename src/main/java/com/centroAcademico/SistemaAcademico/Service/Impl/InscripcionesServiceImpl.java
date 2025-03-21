package com.centroAcademico.SistemaAcademico.Service.Impl;

import com.centroAcademico.SistemaAcademico.Dao.InscripcionesDao;
import com.centroAcademico.SistemaAcademico.Domain.Inscripciones;
import com.centroAcademico.SistemaAcademico.Service.InscripcionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InscripcionesServiceImpl implements InscripcionesService{
    @Autowired
    private InscripcionesDao inscripcionesDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Inscripciones> getInscripciones() {
        var lista = inscripcionesDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Inscripciones getInscripciones(Inscripciones inscripciones) {
        return inscripcionesDao.findById(inscripciones.getIdInscripciones()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Inscripciones clases) {
        inscripcionesDao.save(clases);
    }

    @Override
    @Transactional
    public void delete(Inscripciones clases) {
        inscripcionesDao.delete(clases);
    }
}
