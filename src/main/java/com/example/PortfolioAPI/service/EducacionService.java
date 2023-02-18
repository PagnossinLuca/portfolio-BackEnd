
package com.example.PortfolioAPI.service;

import com.example.PortfolioAPI.model.Educacion;
import com.example.PortfolioAPI.repository.EducacionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService {
    
    @Autowired
    private EducacionRepository educRepository;
    
    public Educacion buscarEducacion(Long id) {
        
        // Busca la educacion en el repositorio
        Educacion educ = educRepository.findById(id).orElse(null);
        return educ;
    }
    
    public void crearEducacion(Educacion educ) {
        
        //Crea un objeto educacion
        educRepository.save(educ);
    }
    
    public List<Educacion> verEducacion() {
        
        List<Educacion> listaEducacion = educRepository.findAll();
        return listaEducacion;
    }
    
    public void eliminarEducacion(Long id) {
        
        //Elimina el objeto educacion por id
        educRepository.deleteById(id);
    }
    
    public List<Educacion> verEducUsuario(Long id) {
        
        List<Educacion> educUsuario = new ArrayList<Educacion>();
        
        //Busca los objetos en el repositorio
        List<Educacion> listaEducacion = this.verEducacion();
        
        //Busca los objetos Educacion relacionados con el id dado
        for (int i=0; i < listaEducacion.size(); i++) {
            
            Educacion educ = listaEducacion.get(i);
            
            //Se ejecuta al encontrar un objeto educacion relacionado con el id dado
            if (educ.getId_usuario().equals(id)) {
                
                educUsuario.add(educ);
            }
        }
        
        return educUsuario;
    }
}
