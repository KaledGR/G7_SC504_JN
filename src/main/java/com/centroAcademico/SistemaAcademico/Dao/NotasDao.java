/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.centroAcademico.SistemaAcademico.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroAcademico.SistemaAcademico.Domain.Notas;

public interface NotasDao extends JpaRepository<Notas, Long> {

}
