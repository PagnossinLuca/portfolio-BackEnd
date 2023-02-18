
package com.example.PortfolioAPI.repository;

import com.example.PortfolioAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{

    //Repositorio con los usuarios
}
