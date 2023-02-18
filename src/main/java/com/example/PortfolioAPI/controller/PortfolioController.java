
package com.example.PortfolioAPI.controller;

import com.example.PortfolioAPI.DTO.UsuarioDto;
import com.example.PortfolioAPI.model.*;
import com.example.PortfolioAPI.service.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class PortfolioController {
    
    @Autowired
    private UsuarioService userService;
    @Autowired
    private EducacionService educService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private ExperienciaService expService;
    @Autowired
    private ProyectoService prjtService;
    
    private String assetsDir = "C:/Users/Luca/Documents/YoProgramo/PortfolioLucaPagnossin/src/assets/";
    
    @PostMapping("/iniciar_sesion")
    public boolean iniciarSesion(@RequestBody Sesion sesion) {
        
        boolean autenticar = false;
        
        // Busca la lista de usuarios
        List<Usuario> listaUsuarios = userService.verUsuarios();
        
        // Busca el usuario por nombre
        for (int i=0; i < listaUsuarios.size(); i++) {
            
            Usuario user = listaUsuarios.get(i);
            
            if (sesion.getUsuario().equals(user.getNombreUsuario())) {
                
                // Si coincide el nombre, revisa la contraseña
                if (sesion.getContrasenia().equals(user.getContrasenia())) {
                    
                    // Devuelve el usuario si coincide el nombre y la contraseña
                    autenticar = true;
                    
                    break;
                }
            }
        }
                
        // Llama a la función para ver al usuario
        return autenticar;
    }
    
    @PutMapping("/usuario/modificar")
    public Usuario modificarUsuario(@RequestBody Usuario form) throws IOException {
        
        //Busca el objeto educacion a modificar
        Usuario user = userService.buscarUsuario(form.getId());
        
        //Actualiza los valores del objeto
        user.setNombre(form.getNombre());
        user.setTitulo(form.getTitulo());
        user.setTexto(form.getTexto());
        user.setAbout(form.getAbout());
        
        //Elimina la imagen anterior si existe
        eliminarArchivo(assetsDir + user.getFoto());
        eliminarArchivo(assetsDir + user.getBanner());
        
        //Actualiza las imágenes
        user.setFoto(form.getFoto());
        user.setBanner(form.getBanner());
        
        //Guarda el objeto
        userService.crearUsuario(user);
        return user;
    }
    
    // Usuario //
    
    @GetMapping("/usuario/completo")
    @ResponseBody
    public UsuarioDto verCompleto (@RequestParam Long id) {
        
        //Busca al usuario y su información
        Usuario usuario = userService.buscarUsuario(id);
        List<Educacion> educacion = educService.verEducUsuario(id);
        List<Skill> skills = skillService.verSkillsUsuario(id);
        List<Experiencia> experiencia = expService.verExpUsuario(id);
        List<Proyecto> proyectos = prjtService.verPrjtsUsuario(id);
        
        //Crea un DTO con toda la información del usuario
        UsuarioDto usuarioDTO = new UsuarioDto();
        
        //Almacena los datos del usuario en el DTO
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setBanner(usuario.getBanner());
        usuarioDTO.setFoto(usuario.getFoto());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setTitulo(usuario.getTitulo());
        usuarioDTO.setTexto(usuario.getTexto());
        usuarioDTO.setAbout(usuario.getAbout());
        
        //Almacena las tablas relacionadas con el usuario en el DTO
        usuarioDTO.setEducacion(educacion);
        usuarioDTO.setSkills(skills);
        usuarioDTO.setExperiencia(experiencia);
        usuarioDTO.setProyectos(proyectos);
        
        System.out.println(usuarioDTO);
        
        return usuarioDTO;
    }
    
    @GetMapping("/usuario/ver")
    public Usuario verUsuario(@RequestParam Long id) {
        
        // Utiliza el servicio para buscar y devolver el usuario
        Usuario usuario = userService.buscarUsuario(id);
        return usuario;
    }
    
    @GetMapping("/usuario/traer")
    public List<Usuario> traerUsuarios() {
        
        // Utiliza el servicio para buscar y devolver el usuario
        List<Usuario> listaUsuario = userService.verUsuarios();
        return listaUsuario;
    }
    
    @PostMapping("/usuario/crear")
    public void crearUsuario(@RequestBody Usuario usuario) {
        
        //Llama al servicio para crear un usuario
        userService.crearUsuario(usuario);
    }
    
    @GetMapping("/usuario/educacion/traer")
    public List<Educacion> traerEducacion() {
        
        // Utiliza el servicio para buscar y devolver el usuario
        List<Educacion> educ = educService.verEducacion();
        return educ;
    }
    
    // Educacion //
    
    @PutMapping("/educacion/modificar")
    public Educacion modificarEducacion(@RequestBody Educacion form) throws IOException {
        
        //Busca el objeto educacion a modificar
        Educacion nuevaEduc = educService.buscarEducacion(form.getId());
        
        //Actualiza los valores del objeto
        nuevaEduc.setCertificado(form.getCertificado());
        nuevaEduc.setTitulo(form.getTitulo());
        nuevaEduc.setEscuela(form.getEscuela());
        nuevaEduc.setTiempo(form.getTiempo());
        
        eliminarArchivo(assetsDir + nuevaEduc.getLogo());
        
        nuevaEduc.setLogo(form.getLogo());
        
        //Guarda el objeto
        educService.crearEducacion(nuevaEduc);
        return nuevaEduc;
    }
    
    @GetMapping("/usuario/educacion/ver")
    public List<Educacion> traerEducUsuario(@RequestParam Long id) {
        
        // Utiliza el servicio para buscar y devolver el usuario
        List<Educacion> listaEducacion = educService.verEducUsuario(id);
        return listaEducacion;
    }
    
    @PostMapping("/educacion/crear")
    public Educacion crearEducacion(@RequestBody Educacion educ) {
        
        //Llama al servicio para crear un usuario
        educService.crearEducacion(educ);
        
        return educ;
    }
    
    @DeleteMapping("/educacion/eliminar")
    public Long eliminarEducacion(@RequestParam Long id) {
        
        //Llama al servicio para eliminar el objeto educacion
        educService.eliminarEducacion(id);
        System.out.println(id);
        
        return id;
    }
    
    // Skills //
    
    @PostMapping("/skill/crear")
    public Skill crearSkills(@RequestBody Skill skill) {
        
        //Llama al servicio para crear un usuario
        skillService.crearSkill(skill);
        
        return skill;
    }
    
    
    @PutMapping("/skill/modificar")
    public Skill modificarSkill(@RequestBody Skill form) throws IOException {
        
        //Busca el objeto skill a modificar
        Skill nuevaSkill = skillService.buscarSkill(form.getId());
        
        System.out.println(Paths.get(assetsDir + nuevaSkill.getLogo()));
        
        //Actualiza los valores del objeto
        nuevaSkill.setNombre(form.getNombre());
        nuevaSkill.setDescripcion(form.getDescripcion());
        nuevaSkill.setExp(form.getExp());
        
        eliminarArchivo(assetsDir + nuevaSkill.getLogo());
        
        //Obtiene el nombre de la imagen
        nuevaSkill.setLogo(form.getLogo());
        
        //Guarda el objeto
        skillService.crearSkill(nuevaSkill);
        return nuevaSkill;
    }
    
    @DeleteMapping("/skill/eliminar")
    public Long eliminarSkill(@RequestParam Long id) {
        
        //Llama al servicio para eliminar el objeto educacion
        skillService.eliminarSkill(id);
        
        return id;
    }
    
    // Experiencia //
    
    @PostMapping("/experiencia/crear")
    public Experiencia crearExperiencia(@RequestBody Experiencia exp) {
        
        //Llama al servicio para crear un usuario
        expService.crearExperiencia(exp);
        
        return exp;
    }
    
    
    @PutMapping("/experiencia/modificar")
    public Experiencia modificarExperiencia(@RequestBody Experiencia form) throws IOException {
        
        //Busca el objeto skill a modificar
        Experiencia nuevaExp = expService.buscarExperiencia(form.getId());
        
        System.out.println(Paths.get(assetsDir + nuevaExp.getLogo()));
        
        //Actualiza los valores del objeto
        nuevaExp.setEmpresa(form.getEmpresa());
        nuevaExp.setTiempo(form.getTiempo());
        nuevaExp.setArea(form.getArea());
        nuevaExp.setLogo(form.getLogo());
        
        eliminarArchivo(assetsDir + nuevaExp.getLogo());
        
        //Obtiene el nombre de la imagen
        nuevaExp.setLogo(form.getLogo());
        
        //Guarda el objeto
        expService.crearExperiencia(nuevaExp);
        return nuevaExp;
    }
    
    @DeleteMapping("/experiencia/eliminar")
    public Long eliminarExperiencia(@RequestParam Long id) {
        
        //Llama al servicio para eliminar el objeto educacion
        expService.eliminarExperiencia(id);
        
        return id;
    }
    
    // Proyectos //
    
    @PostMapping("/proyecto/crear")
    public Proyecto crearProyecto(@RequestBody Proyecto prjt) {
        
        //Llama al servicio para crear un usuario
        prjtService.crearProyecto(prjt);
        
        return prjt;
    }
    
    
    @PutMapping("/proyecto/modificar")
    public Proyecto modificarExperiencia(@RequestBody Proyecto form) throws IOException {
        
        //Busca el objeto a modificar
        Proyecto nuevoPrjt = prjtService.buscarProyecto(form.getId());
        
        //Actualiza los valores del objeto 
        nuevoPrjt.setNombre(form.getNombre());
        nuevoPrjt.setTiempo(form.getTiempo());
        nuevoPrjt.setDescripcion(form.getDescripcion());
        nuevoPrjt.setRef(form.getRef());
        
        eliminarArchivo(assetsDir + nuevoPrjt.getLogo());
        
        //Obtiene el nombre de la imagen
        nuevoPrjt.setLogo(form.getLogo());
        
        //Guarda el objeto
        prjtService.crearProyecto(nuevoPrjt);
        return nuevoPrjt;
    }
    
    @DeleteMapping("/proyecto/eliminar")
    public Long eliminarProyecto(@RequestParam Long id) {
        
        //Llama al servicio para eliminar el objeto
        prjtService.eliminarProyecto(id);
        
        return id;
    }
    
    // Administrar archivos //
    
    @PostMapping("/guardar_asset")
    public MultipartFile guardarAsset(@RequestParam("archivo") MultipartFile mpFile) throws IOException {
        
        //Consigue el nombre de la imagen
        String fileName = StringUtils.cleanPath(mpFile.getOriginalFilename());
        
        //Guarda la imagen
        GuardarArchivo(assetsDir, fileName, mpFile);
        
        return mpFile;
    }
    
    public void GuardarArchivo(String dir, String archivo, MultipartFile mpf) throws IOException {
        
        Path direccion = Paths.get(dir);
        
        if(!Files.exists(direccion)) {
            
            Files.createDirectories(direccion);
        }
        
        try (InputStream inputStream = mpf.getInputStream()) {
            
            Path filePath = direccion.resolve(archivo);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ioe){
            
            throw new IOException("No se pudo guardar la imagen: " + archivo, ioe);
        }
    
    }
    
    public void eliminarArchivo(String dir) throws IOException {
        
        //Elimina la imagen anterior si existe
        Path archivoAntiguo = Paths.get(dir);
        
        if (!Files.exists(archivoAntiguo)) {
            
            Files.delete(archivoAntiguo);
        }
    }
    
    public static void saveFile(String uploadDir, String fileName,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
          
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
          
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
    }

}
