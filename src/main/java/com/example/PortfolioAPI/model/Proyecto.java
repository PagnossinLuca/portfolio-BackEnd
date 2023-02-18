
package com.example.PortfolioAPI.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
public class Proyecto {
    
    //Atributos
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String nombre;
    private String tiempo;
    private String descripcion;
    private String ref;
    private String logo;
    private Long id_usuario;
    
    public Proyecto() {
        
        this.nombre = "";
        this.tiempo = "";
        this.descripcion = "";
        this.ref = "";
        this.logo = "";
    }
}
