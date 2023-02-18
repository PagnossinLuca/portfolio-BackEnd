
package com.example.PortfolioAPI.DTO;

import com.example.PortfolioAPI.model.*;
import com.example.PortfolioAPI.service.*;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter @Setter
public class UsuarioDto implements Serializable{
    
    private Long id;
    private String nombre;
    private String email;
    private String contrasenia;
    private String texto;
    private String about;
    private String localidad;
    private String dni;
    private String foto;
    private String banner;
    private String titulo;
    
    private List<Educacion> educacion;
    private List<Experiencia> experiencia;
    private List<Skill> skills;
    private List<Proyecto> proyectos;
    private List<Red> redes;
   
    public UsuarioDto () {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Educacion> getEducacion() {
        return educacion;
    }

    public void setEducacion(List<Educacion> educacion) {
        this.educacion = educacion;
    }

    public List<Experiencia> getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(List<Experiencia> experiencia) {
        this.experiencia = experiencia;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
