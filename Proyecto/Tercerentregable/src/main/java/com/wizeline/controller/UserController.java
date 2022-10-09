package com.wizeline.controller;

import com.wizeline.dto.ResponseDTO;
import com.wizeline.dto.UsuarioDTO;
import com.wizeline.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    /* API generada por Spring MVC con un endpoint de cada tipo: POST - crearusuario */
    @PostMapping("/crearusuario")
    public ResponseEntity<?> createUser(
            @RequestBody
            UsuarioDTO usuario){

        return userServiceImpl.crearUsuarioService(usuario);
    }

    /* API generada por Spring MVC con un endpoint de cada tipo: POST - login de usuario */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam(name = "usuario") String usuario, @RequestParam(name = "contrasenia") String contrasenia){

        return userServiceImpl.loginService(usuario, contrasenia);
    }

    /* API generada por Spring MVC con un endpoint de cada tipo: GET - obtenerusuarios */
    @GetMapping("/obtenerusuarios")
    public ResponseEntity<?> obtenerusuarios(){

        return userServiceImpl.obtenerUsuarios();
    }

    /* API generada por Spring MVC con un endpoint de cada tipo: PUT - actualizarcontrasenia */
    @PutMapping("/actualizarcontrasenia")
    public ResponseEntity<?> actualizarcontrasenia(
            @RequestParam(name = "idUsuario")
            String idUsuario,
            @RequestParam(name = "nuevaContrasenia")
            String nuevaContrasenia){

        return userServiceImpl.cambiarContrasenia(idUsuario, nuevaContrasenia);
    }

    /* API generada por Spring MVC con un endpoint de cada tipo: GET - obtenerUsuarioPorId */
    @GetMapping("/obtenerusuario/{idUsuario}")
    public ResponseEntity<?> obtenerusuario(@PathVariable(name = "idUsuario") String idUsuario){

        return userServiceImpl.obtenerUsuarioPoId(idUsuario);
    }

    /* API generada por Spring MVC con un endpoint de cada tipo: DELETE - borrarUsuarioPorId */
    @DeleteMapping("/borrarusuario/{idUsuario}")
    public ResponseEntity<?> borrarUsuario(@PathVariable(name = "idUsuario") String idUsuario){

        return userServiceImpl.borrarUsuarioId(idUsuario);
    }

    /* API generada por Spring MVC con un endpoint de cada tipo: GET - apiPublica */
    @GetMapping("/apipublica/jsonplaceholder")
    public ResponseEntity<ResponseDTO> jsonplaceholder(){
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        return userServiceImpl.consumirApiPublica(url);
    }
}
