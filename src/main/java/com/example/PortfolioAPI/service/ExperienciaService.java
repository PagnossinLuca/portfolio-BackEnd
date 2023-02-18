
package com.example.PortfolioAPI.service;

import com.example.PortfolioAPI.model.Experiencia;
import com.example.PortfolioAPI.repository.ExperienciaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {
    
    @Autowired
    private ExperienciaRepository expRepository;
    
    public Experiencia buscarExperiencia(Long id) {
        
        // Busca la experiencia en el repositorio
        Experiencia exp = expRepository.findById(id).orElse(null);
        return exp;
    }
    
    public void crearExperiencia(Experiencia exp) {
        
        //Crea un objeto experiencia
        expRepository.save(exp);
    }
    
    public List<Experiencia> verExperiencia() {
        
        List<Experiencia> listaExperiencia = expRepository.findAll();
        return listaExperiencia;
    }
    
    public void eliminarExperiencia(Long id) {
        
        //Elimina el objeto experiencia por id
        expRepository.deleteById(id);
    }
    
    public List<Experiencia> verExpUsuario(Long id) {
        
        List<Experiencia> educUsuario = new ArrayList<Experiencia>();
        
        //Busca los objetos en el repositorio
        List<Experiencia> listaExperiencia = this.verExperiencia();
        
        //Busca los objetos Educacion relacionados con el id dado
        for (int i=0; i < listaExperiencia.size(); i++) {
            
            Experiencia exp = listaExperiencia.get(i);
            
            //Se ejecuta al encontrar un objeto educacion relacionado con el id dado
            if (exp.getId_usuario().equals(id)) {
                
                educUsuario.add(exp);
            }
        }
        
        return educUsuario;
    }
}
