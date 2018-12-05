/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.apiypsos.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author matheus
 */
@Path("/alunos")
public class AlunoResource {
    
    //teste
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ola(){
        return "Olá";
    }
}
