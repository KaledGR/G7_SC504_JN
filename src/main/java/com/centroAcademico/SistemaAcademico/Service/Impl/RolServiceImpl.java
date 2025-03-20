/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Service.Impl;


import com.centroAcademico.SistemaAcademico.Domain.Rol;

import com.centroAcademico.SistemaAcademico.Service.RolService;
import com.centroAcademico.SistemaAcademico.Dao.RolDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolServiceImpl implements RolService {

     @Autowired
    private RolDao rolDao;
     
    @Override
    @Transactional(readOnly=true)
    public List<Rol> getRoles() {
        var lista = rolDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Rol getRol(Rol rol) {
        return rolDao.findById(rol.getIdRol()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Rol rol) {
        rolDao.save(rol);
    }

    @Override
    @Transactional
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }
    
    
}
