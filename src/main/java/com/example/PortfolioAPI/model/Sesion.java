
package com.example.PortfolioAPI.model;

import jakarta.persistence.Entity;
import lombok.*;

public class Sesion {
    
    private String usuario;
    private String contrasenia;

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
