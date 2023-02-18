
package com.example.PortfolioAPI.service;

import com.example.PortfolioAPI.model.Skill;
import com.example.PortfolioAPI.repository.SkillsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillService {
    
    @Autowired
    private SkillsRepository skillRepository;
    
    public List<Skill> verSkills() {
        
        List<Skill> listaSkills = skillRepository.findAll();
        return listaSkills;
    }
    
    public Skill buscarSkill(Long id) {
        
        // Busca la skill en el repositorio
        Skill skill = skillRepository.findById(id).orElse(null);
        return skill;
    }
    
    public void crearSkill(Skill skill) {
        
        //Crea un objeto educacion
        skillRepository.save(skill);
    }
    
    public List<Skill> verSkillsUsuario(Long id) {
        
        List<Skill> skillsUsuario = new ArrayList<Skill>();
        
        //Busca los objetos en el repositorio
        List<Skill> listaSkills = this.verSkills();
        
        //Busca los objetos Educacion relacionados con el id dado
        for (int i=0; i < listaSkills.size(); i++) {
            
            Skill skill = listaSkills.get(i);
            
            //Se ejecuta al encontrar un objeto educacion relacionado con el id dado
            if (skill.getId_usuario().equals(id)) {
                
                skillsUsuario.add(skill);
            }
        }
        
        return skillsUsuario;
    }
    
    public void eliminarSkill(Long id) {
        
        //Elimina el objeto educacion por id
        skillRepository.deleteById(id);
    }
}
