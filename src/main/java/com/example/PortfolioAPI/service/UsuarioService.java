
package com.example.PortfolioAPI.service;

import com.example.PortfolioAPI.DTO.UsuarioDto;
import com.example.PortfolioAPI.model.Educacion;
import com.example.PortfolioAPI.model.Usuario;
import com.example.PortfolioAPI.repository.EducacionRepository;
import com.example.PortfolioAPI.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;


@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository userRepository;
    private EducacionService educService;
    
    
    public Usuario buscarUsuario(Long id) {
        
        // Busca el usuario en el repositorio
        Usuario usuario = userRepository.findById(id).orElse(null);
        return usuario;
    }
    
    public List<Usuario> verUsuarios() {
        
        List<Usuario> listaUsuarios = userRepository.findAll();
        return listaUsuarios;
    }
    
    public void crearUsuario(Usuario usuario) {
        
        //Guarda al usuario en el repositorio
        userRepository.save(usuario);
    }
}
