/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Service.Impl;


import com.centroAcademico.SistemaAcademico.Domain.Horarios;

import com.centroAcademico.SistemaAcademico.Service.HorariosService;
import com.centroAcademico.SistemaAcademico.Dao.HorariosDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HorariosServiceImpl implements HorariosService {

     @Autowired
    private HorariosDao horariosDao;
     
    @Override
    @Transactional(readOnly=true)
    public List<Horarios> getHorarios() {
        var lista = horariosDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Horarios getHorario(Horarios horario) {
        return horariosDao.findById(horario.getIdHorario()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Horarios horarios) {
        horariosDao.save(horarios);
    }

    @Override
    @Transactional
    public void delete(Horarios horarios) {
        horariosDao.delete(horarios);
    }
    
    
}
