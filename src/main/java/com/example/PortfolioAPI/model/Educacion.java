
package com.example.PortfolioAPI.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
public class Educacion {
    
    //Atributos
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String escuela;
    private String tiempo;
    private String titulo;
    private Long id_usuario;
    private String logo;
    private String certificado;
    
    public Educacion() {
        
        this.escuela = "";
        this.tiempo = "";
        this.titulo = "";
        this.logo = "";
        this.certificado = "";
    }
}
