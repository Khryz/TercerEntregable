package com.wizeline.utils;

import com.wizeline.entidad.UsuarioEntidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(UtilsTest.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class UtilsTest {
    /* Generación de logs por prueba - UtilsTest: Logger */
    private static final Logger log = LoggerFactory.getLogger(UtilsTest.class);

    MockedStatic<Utils> utilsMockeado = Mockito.mockStatic(Utils.class);

    @Test
    @DisplayName("UtilsMethod - ObtenerNumeroDeCuentaRandom")
    public void DadoElMetodoEstaticoNumeroDeCuentaRandom_CuandoSeMandaALlamar_DevuelveUnNumeroRamdomPositivo(){
        log.info("Se contesta con lo esperado cuando se mande a llamar el metodo estatico de la clase Utils");
        utilsMockeado.when(Utils::randomAccountNumber).thenReturn(1);

        log.info("Se crea cuerpo que manda a llamar internamente el metodo estatico");
        UsuarioEntidad usuarioEntidad = new UsuarioEntidad();

        log.info("Se compara el valor esperado con el real");
        Assertions.assertEquals(1, usuarioEntidad.getId());
    }

    /*@Test
    @DisplayName("Edge Case - UtilsMethod - ObtenerNumeroDeCuentaRandomExcepcion")
    public void DadoElMetodoEstaticoNumeroDeCuentaRandom_CuandoSeMandaALlamar_SillegaAFallarDebeSerConAlgunaExcepcion(){
        log.info("Se contesta con lo esperado cuando se mande a llamar el metodo estatico de la clase Utils");
        utilsMockeado.when(Utils::randomAccountNumber).thenThrow(new NullPointerException("Excepcion nula xd"));

        NullPointerException thrown = Assertions.assertThrows(
                NullPointerException.class,
                () -> Utils.randomAccountNumber(),
                "Excepcion nula xd"
        );

        log.info("Se compara el mennsaje esperado con el real");
        Assertions.assertEquals("Excepcion nula xd", thrown.getMessage());
    }*/
}
