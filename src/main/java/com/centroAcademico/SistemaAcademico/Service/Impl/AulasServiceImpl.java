package com.centroAcademico.SistemaAcademico.Service.Impl;

import com.centroAcademico.SistemaAcademico.Domain.Aulas;
import com.centroAcademico.SistemaAcademico.Service.AulasService;
import com.centroAcademico.SistemaAcademico.Dao.AulasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AulasServiceImpl implements AulasService{
    
    @Autowired
    private AulasDao aulasDao;
     
    @Override
    @Transactional(readOnly=true)
    public List<Aulas> getAulas() {
        var lista = aulasDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Aulas getAulas(Aulas aulas) {
        return aulasDao.findById(aulas.getIdAula()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Aulas aulas) {
        aulasDao.save(aulas);
    }

    @Override
    @Transactional
    public void delete(Aulas aulas) {
        aulasDao.delete(aulas);
    }
}
