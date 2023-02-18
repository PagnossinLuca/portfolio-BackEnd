
package com.example.PortfolioAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter
@Entity
public class Skill {
    
    //Atributos
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String nombre;
    private String logo;
    private String exp;
    private String descripcion;
    private Long id_usuario;
    
    public Skill() {
        
        this.nombre = "";
        this.logo = "";
        this.exp = "";
        this.descripcion = "";
    }
}
