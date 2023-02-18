
package com.example.PortfolioAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {
    
    //Atributos
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String logo;
    private String empresa;
    private String tiempo;
    private String area;
    private Long id_usuario;
    
    public Experiencia() {
        
        this.empresa = "";
        this.tiempo = "";
        this.area = "";
        this.logo = "";
    }
}
