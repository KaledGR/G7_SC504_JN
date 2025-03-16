/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Service.Impl;


import com.centroAcademico.SistemaAcademico.Domain.Estudiante;

import com.centroAcademico.SistemaAcademico.Service.EstudianteService;
import com.centroAcademico.SistemaAcademico.Dao.EstudianteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

     @Autowired
    private EstudianteDao estudianteDao;
     
    @Override
    @Transactional(readOnly=true)
    public List<Estudiante> getEstudiantes() {
        var lista = estudianteDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Estudiante getEstudiante(Estudiante estudiante) {
        return estudianteDao.findById(estudiante.getIdEstudiante()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Estudiante estudiante) {
        estudianteDao.save(estudiante);
    }

    @Override
    @Transactional
    public void delete(Estudiante estudiante) {
        estudianteDao.delete(estudiante);
    }
    
    
}
