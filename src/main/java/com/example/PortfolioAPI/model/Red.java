
package com.example.PortfolioAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
public class Red {
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id
    private Long id;
    
}
