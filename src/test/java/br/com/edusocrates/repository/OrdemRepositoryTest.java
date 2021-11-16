package br.com.edusocrates.repository;

import br.com.edusocrates.model.Ordem;
import br.com.edusocrates.repositories.OrdemRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class OrdemRepositoryTest {

    @InjectMock
    OrdemRepository repository;

    @Test
     void listAllTest(){
        Ordem ordem1 = new Ordem();
        Ordem ordem2 = new Ordem();
        List<Ordem> ordemList = new ArrayList<>();

        ordemList.add(ordem1);
        ordemList.add(ordem2);

        Mockito.when(repository.listAll()).thenReturn(ordemList);
        Assertions.assertSame(ordem2,repository.listAll().get(1));
     }
}
