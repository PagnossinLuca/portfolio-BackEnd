
package com.example.PortfolioAPI.service;

import com.example.PortfolioAPI.model.Proyecto;
import com.example.PortfolioAPI.repository.ProyectoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProyectoService {
    
    @Autowired
    private ProyectoRepository prjtRepository;
    
    public List<Proyecto> verProyectos() {
        
        List<Proyecto> listaProyectos = prjtRepository.findAll();
        return listaProyectos;
    }
    
    public Proyecto buscarProyecto(Long id) {
        
        // Busca el proyecto en el repositorio
        Proyecto prjt = prjtRepository.findById(id).orElse(null);
        return prjt;
    }
    
    public void crearProyecto(Proyecto prjt) {
        
        //Crea un objeto proyecto
        prjtRepository.save(prjt);
    }
    
    public List<Proyecto> verPrjtsUsuario(Long id) {
        
        List<Proyecto> prjtsUsuario = new ArrayList<Proyecto>();
        
        //Busca los objetos en el repositorio
        List<Proyecto> listaPrjts = this.verProyectos();
        
        //Busca los objetos relacionados con el id dado
        for (int i=0; i < listaPrjts.size(); i++) {
            
            Proyecto prjt = listaPrjts.get(i);
            
            //Se ejecuta al encontrar un objeto relacionado con el id dado
            if (prjt.getId_usuario().equals(id)) {
                
                prjtsUsuario.add(prjt);
            }
        }
        
        return prjtsUsuario;
    }
    
    public void eliminarProyecto(Long id) {
        
        //Elimina el objeto por id
        prjtRepository.deleteById(id);
    }
}