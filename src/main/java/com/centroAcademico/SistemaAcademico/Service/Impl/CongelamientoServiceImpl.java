/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Service.Impl;


import com.centroAcademico.SistemaAcademico.Domain.Congelamiento;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.centroAcademico.SistemaAcademico.Dao.CongelamientoDao;
import com.centroAcademico.SistemaAcademico.Service.CongelamientoService;

@Service
public class CongelamientoServiceImpl implements CongelamientoService {

     @Autowired
    private CongelamientoDao congelamientosDao;
     
    @Override
    @Transactional(readOnly=true)
    public List<Congelamiento> getCongelamientos() {
        var lista = congelamientosDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Congelamiento getCongelamiento(Congelamiento congelamientos) {
        return congelamientosDao.findById(congelamientos.getIdCongelamiento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Congelamiento congelamientos) {
        congelamientosDao.save(congelamientos);
    }

    @Override
    @Transactional
    public void delete(Congelamiento congelamientos) {
        congelamientosDao.delete(congelamientos);
    }
    
    
}
