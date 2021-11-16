package br.com.edusocrates.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
public class UsuarioTest {


    @Test
    void findByIdOptionalTest(){
        PanacheMock.mock(Usuario.class);

        Usuario usuario = new Usuario();
        Optional<PanacheEntityBase> usuarioOptional = Optional.of(usuario);

        Mockito.when(Usuario.findByIdOptional(123)).thenReturn(usuarioOptional);
        Assertions.assertSame(usuario,Usuario.findByIdOptional(123).get());
    }

}
