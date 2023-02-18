
package com.example.PortfolioAPI.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter @Setter
@Entity
public class Usuario {
    
    //Atributos
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id
    private Long id;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String contrasenia;
    private String localidad;
    private String dni;
    private String foto;
    private String banner;
    private String titulo;
    private String texto;
    private String about;
}
