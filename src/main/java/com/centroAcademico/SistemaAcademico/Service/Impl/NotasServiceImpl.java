/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    @Transactional(readOnly=true)
    public List<Notas> getNotas() {
        var lista = notasDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Notas getNota(Notas notas) {
        return notasDao.findById(notas.getIdNota()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Notas notas) {
        notasDao.save(notas);
    }

    @Override
    @Transactional
    public void delete(Notas notas) {
        notasDao.delete(notas);
    }
    
    
}
