
package com.example.PortfolioAPI.repository;

import com.example.PortfolioAPI.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository <Proyecto, Long>{

    //Repositorio con los proyectos
}
