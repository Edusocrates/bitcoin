package br.com.edusocrates.controller;

import br.com.edusocrates.model.Ordem;
import br.com.edusocrates.repositories.OrdemRepository;
import br.com.edusocrates.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@Path("/ordens")
public class OrdemController {

    @Inject
    OrdemService service;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(@Context SecurityContext securityContext, Ordem ordem){
        service.inserir(securityContext,ordem);

    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> listar(){
        return service.listar();
    }

}
