/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Service.Impl;


import com.centroAcademico.SistemaAcademico.Domain.Profesores;

import com.centroAcademico.SistemaAcademico.Service.ProfesoresService;
import com.centroAcademico.SistemaAcademico.Dao.ProfesoresDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesoresServiceImpl implements ProfesoresService {

     @Autowired
    private ProfesoresDao profesoresDao;
     
    @Override
    @Transactional(readOnly=true)
    public List<Profesores> getProfesores() {
        var lista = profesoresDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Profesores getProfesor(Profesores profesor) {
        return profesoresDao.findById(profesor.getIdProfesor()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Profesores profesores) {
        profesoresDao.save(profesores);
    }

    @Override
    @Transactional
    public void delete(Profesores profesores) {
        profesoresDao.delete(profesores);
    }
    
    
}
