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
    @Transactional(readOnly = true)
    public List<Congelamiento> getCongelamientos() {
        return congelamientosDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
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

    // Nuevo método para crear un congelamiento usando el procedimiento almacenado
    @Transactional
    public void crearCongelamiento(Long idCongelamiento, Long idEstudiante, String fechaComplemento) {
        congelamientosDao.crearCongelamiento(idCongelamiento, idEstudiante, fechaComplemento);
    }

    // Nuevo método para actualizar un congelamiento usando el procedimiento almacenado
    @Transactional
    public void actualizarCongelamiento(Long idCongelamiento, Long idEstudiante, String fechaComplemento) {
        congelamientosDao.actualizarCongelamiento(idCongelamiento, idEstudiante, fechaComplemento);
    }

    // Nuevo método para eliminar un congelamiento usando el procedimiento almacenado
    @Transactional
    public void eliminarCongelamiento(Long idCongelamiento) {
        congelamientosDao.eliminarCongelamiento(idCongelamiento);
    }

    // Nuevo método para obtener un congelamiento usando el procedimiento almacenado
    @Transactional(readOnly = true)
    public Congelamiento obtenerCongelamiento(Long idCongelamiento) {
        return congelamientosDao.obtenerCongelamiento(idCongelamiento);
    }
}