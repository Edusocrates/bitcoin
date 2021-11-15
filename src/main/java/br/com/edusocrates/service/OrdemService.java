package br.com.edusocrates.service;

import br.com.edusocrates.model.Ordem;
import br.com.edusocrates.model.Usuario;
import br.com.edusocrates.repositories.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {


    @Inject
    OrdemRepository repository;


    public void inserir(SecurityContext securityContext, Ordem ordem) {
        Optional<Usuario> usuarioOptional =
                Usuario.findByIdOptional(ordem.getUserId());//vai buscar se existe um usuario ou não
        Usuario usuario = usuarioOptional.orElseThrow();//se nao existir vai jogar exception
        if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){//valida se o usuario logado é o mesmo que foi passado na requisicao
            throw new RuntimeException("Usuario logado diferente do userId");
        }
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        repository.persist(ordem);
    }
}
