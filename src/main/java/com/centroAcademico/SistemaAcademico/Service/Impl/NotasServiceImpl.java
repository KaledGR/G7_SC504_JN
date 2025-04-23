package com.centroAcademico.SistemaAcademico.Service.Impl;

import com.centroAcademico.SistemaAcademico.Domain.Notas;
import com.centroAcademico.SistemaAcademico.Service.NotasService;
import com.centroAcademico.SistemaAcademico.Dao.NotasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotasServiceImpl implements NotasService {

    @Autowired
    private NotasDao notasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Notas> getNotas() {
        return notasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Notas getNota(Notas nota) {
        return notasDao.findById(nota.getIdNota()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Notas notas) {
        if (notas.getIdNota() == null) {
            notasDao.insertarNotas(
                null, // idNota será generado automáticamente
                notas.getProfesor() != null ? notas.getProfesor().getIdProfesor() : null,
                notas.getMateria() != null ? notas.getMateria().getIdMateria() : null,
                notas.getEstudiante() != null ? notas.getEstudiante().getIdEstudiante() : null,
                notas.getCalificacion()
            );
        } else {
            // Actualización de una nota existente
            notasDao.actualizarNotas(
                notas.getIdNota(),
                notas.getProfesor() != null ? notas.getProfesor().getIdProfesor() : null,
                notas.getMateria() != null ? notas.getMateria().getIdMateria() : null,
                notas.getEstudiante() != null ? notas.getEstudiante().getIdEstudiante() : null,
                notas.getCalificacion()
            );
        }
    }

    @Override
    @Transactional
    public void delete(Notas nota) {
        notasDao.eliminarNotas(nota.getIdNota());
    }
}