/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Service.Impl;


import com.centroAcademico.SistemaAcademico.Domain.Materias;

import com.centroAcademico.SistemaAcademico.Service.MateriasService;
import com.centroAcademico.SistemaAcademico.Dao.MateriasDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MateriasServiceImpl implements MateriasService {

     @Autowired
    private MateriasDao materiasDao;
     
    @Override
    @Transactional(readOnly=true)
    public List<Materias> getMaterias() {
        var lista = materiasDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Materias getMateria(Materias materia) {
        return materiasDao.findById(materia.getIdMateria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Materias materias) {
        materiasDao.save(materias);
    }

    @Override
    @Transactional
    public void delete(Materias materias) {
        materiasDao.delete(materias);
    }

  

   
    
    
}
