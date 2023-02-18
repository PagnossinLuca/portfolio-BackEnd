
package com.example.PortfolioAPI.repository;

import com.example.PortfolioAPI.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkillsRepository extends JpaRepository <Skill, Long>{

    //Repositorio con las skills
}
