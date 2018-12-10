/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.apiypsos.resources;

import br.edu.ifrn.apiypsos.domain.Aluno;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author matheus
 */
@Path("/alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {
    
    
    @POST
    public Response createAluno(Aluno aluno){
        if(aluno.create()){
            String r = new Gson().toJson("criado");
            return Response.status(Response.Status.CREATED).entity(r).build();
        }
        String r = new Gson().toJson("oops, erro ao cadastrar");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(r).build();
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlunos(){
        List<Aluno> alunos = Aluno.getAlunos();
        String response = new Gson().toJson(alunos);
        return Response.ok(response).build();
    }
    
    
}
