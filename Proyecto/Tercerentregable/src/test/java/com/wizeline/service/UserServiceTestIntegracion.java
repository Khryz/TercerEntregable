package com.wizeline.service;

import com.wizeline.dao.UserDAO;
import com.wizeline.dto.ResponseDTO;
import com.wizeline.dto.UsuarioDTO;
import com.wizeline.entidad.UsuarioEntidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTestIntegracion {
    /* Generación de logs por prueba - UserServiceTestIntegracion: Logger */
    private static final Logger log = LoggerFactory.getLogger(UserServiceTestIntegracion.class);
    @MockBean
    private UserDAO userDAO;

    @Autowired
    private UserServiceImpl userService;

    @Test
    @DisplayName("CrearUsuarioTest")
    public void DadoElServicioCreateUser_CuandoEntraUnCuerpoBueno_SeCreaElUsuario(){
        UsuarioEntidad usuarioEntidad = new UsuarioEntidad("usuarioSimulado","sontraseniaSimulada");
        UsuarioDTO usuarioDTO =  new UsuarioDTO();

        BeanUtils.copyProperties(usuarioEntidad, usuarioDTO);

        Mockito.when(userDAO.crearUsuario(Mockito.any(UsuarioEntidad.class))).thenReturn(usuarioEntidad);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.crearUsuarioService(usuarioDTO);

        Assertions.assertAll(
                () -> Assertions.assertEquals("OK000", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("NoCreaUsuarioTest")
    public void DadoElServicioCreateUser_CuandoEntraUnCuerpoMalo_NoSeCreaElUsuario(){
        UsuarioEntidad usuarioEntidad = new UsuarioEntidad("usuarioSimulado","sontraseniaSimulada");
        UsuarioDTO usuarioDTO =  new UsuarioDTO();

        BeanUtils.copyProperties(usuarioEntidad, usuarioDTO);

        Mockito.when(userDAO.crearUsuario(Mockito.any(UsuarioEntidad.class))).thenReturn(null);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.crearUsuarioService(usuarioDTO);

        Assertions.assertAll(
                () -> Assertions.assertEquals("ER001", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("LoginTest")
    public void loginTest (){
        UsuarioEntidad usuarioEntidad = new UsuarioEntidad("usuarioSimulado","sontraseniaSimulada");
        Mockito.when(userDAO.login("usuarioSimulado", "sontraseniaSimulada")).thenReturn(usuarioEntidad);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.loginService("usuarioSimulado", "sontraseniaSimulada");

        Assertions.assertAll(
                () -> Assertions.assertEquals("OK000", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("LoginTestFallo")
    public void loginTestFallo (){
        Mockito.when(userDAO.login("usuarioSimulado", "sontraseniaSimulada")).thenReturn(null);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.loginService("usuarioSimulado", "sontraseniaSimulada");

        Assertions.assertAll(
                () -> Assertions.assertEquals("ER001", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("CambiarContraseniaTest")
    public void cambiarContrasenia (){
        String idUsuario = "1882886105";
        String nuevaContrasenia = "xd";

        Mockito.when(userDAO.cambiarContrasenia("1882886105", "xd")).thenReturn(1L);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.cambiarContrasenia(idUsuario, nuevaContrasenia);

        Assertions.assertAll(
                () -> Assertions.assertEquals("OK000", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("Edge case - UserServiceIntegracion - CambiarContraseniaFallaTest")
    public void CambiarContraseniaFallaTest(){
        String idUsuario = "1882886105";
        String nuevaContrasenia = "xd";

        Mockito.when(userDAO.cambiarContrasenia("1882886105", "xd")).thenReturn(0L);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.cambiarContrasenia(idUsuario, nuevaContrasenia);

        Assertions.assertAll(
                () -> Assertions.assertEquals("ER001", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("ObtenerUsuariosTest")
    public void ObtenerUsuarios (){
        List<UsuarioEntidad> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new UsuarioEntidad("usuario1", "contrasenia2"));
        listaUsuarios.add(new UsuarioEntidad("usuario1", "contrasenia2"));

        Mockito.when(userDAO.obtenerUsuarios()).thenReturn(listaUsuarios);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.obtenerUsuarios();

        Assertions.assertAll(
                () -> Assertions.assertEquals("OK000", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("Edge case - UserServiceIntegracion - ObtenerUsuariosFallaTest")
    public void ObtenerUsuariosFallaTest(){
        List<UsuarioEntidad> listaUsuarios = new ArrayList<>();

        Mockito.when(userDAO.obtenerUsuarios()).thenReturn(listaUsuarios);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.obtenerUsuarios();

        Assertions.assertAll(
                () -> Assertions.assertEquals("ER001", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("obtenerUsuarioPorIdTest")
    public void obtenerUsuarioPoId (){
        UsuarioEntidad usuarioEntidad = new UsuarioEntidad("usuario1", "contrasenia2");

        Mockito.when(userDAO.obtenerUsuario(Mockito.anyString())).thenReturn(usuarioEntidad);

        String idUsuario = ""+usuarioEntidad.getId();

        ResponseEntity<ResponseDTO> respuestaServicio = userService.obtenerUsuarioPoId(idUsuario);

        Assertions.assertAll(
                () -> Assertions.assertEquals("OK000", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("Edge case - UserServiceIntegracion - obtenerUsuarioPorIdFallaTest")
    public void obtenerUsuarioPorIdFallaTest(){
        UsuarioEntidad usuarioEntidad = new UsuarioEntidad("usuario1", "contrasenia2");

        Mockito.when(userDAO.obtenerUsuario(Mockito.anyString())).thenReturn(null);

        String idUsuario = ""+usuarioEntidad.getId();

        ResponseEntity<ResponseDTO> respuestaServicio = userService.obtenerUsuarioPoId(idUsuario);

        Assertions.assertAll(
                () -> Assertions.assertEquals("ER001", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("borrarUsuarioPorIdTest")
    public void borrarUsuarioId (){
        String idUsuarioABorrar = "123";

        Mockito.when(userDAO.borrarUsuario(Mockito.anyString())).thenReturn(1L);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.borrarUsuarioId(idUsuarioABorrar);

        Assertions.assertAll(
                () -> Assertions.assertEquals("OK000", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("Edge case - UserServiceIntegracion - borrarUsuarioPorIdFallaTest")
    public void borrarUsuarioPorIdFallaTest(){
        String idUsuarioABorrar = "123";

        Mockito.when(userDAO.borrarUsuario(Mockito.anyString())).thenReturn(0L);

        ResponseEntity<ResponseDTO> respuestaServicio = userService.borrarUsuarioId(idUsuarioABorrar);

        Assertions.assertAll(
                () -> Assertions.assertEquals("ER001", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }

    @Test
    @DisplayName("consumirApiPublicaTest")
    public void consumirApiPublica (){
        /* Debe ser una api publica existente/real */
        String url = "https://jsonplaceholder.typicode.com/todos/1";

        ResponseEntity<ResponseDTO> respuestaServicio = userService.consumirApiPublica(url);

        Assertions.assertAll(
                () -> Assertions.assertEquals("OK000", respuestaServicio.getBody().getCode())
        );

        log.info("Resultado: "+respuestaServicio.getBody().getCode());
    }
}
