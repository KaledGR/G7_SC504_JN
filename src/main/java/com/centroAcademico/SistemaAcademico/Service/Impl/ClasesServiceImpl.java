package com.centroAcademico.SistemaAcademico.Service.Impl;

import com.centroAcademico.SistemaAcademico.Dao.ClasesDao;
import com.centroAcademico.SistemaAcademico.Domain.Clases;
import com.centroAcademico.SistemaAcademico.Service.ClasesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClasesServiceImpl implements ClasesService{
    
    @Autowired
    private ClasesDao clasesDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Clases> getClases() {
        var lista = clasesDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Clases getClases(Clases clases) {
        return clasesDao.findById(clases.getIdClase()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Clases clases) {
        clasesDao.save(clases);
    }

    @Override
    @Transactional
    public void delete(Clases clases) {
        clasesDao.delete(clases);
    }
}
