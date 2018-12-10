/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.apiypsos.filters;

import br.edu.ifrn.apiypsos.useful.Authenticator;
import br.edu.ifrn.apiypsos.useful.Headers;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author matheus
 */
@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        
        String path = crc.getUriInfo().getPath();
        System.out.println("CAMINHO: " +path);
        
        if(crc.getRequest().getMethod().equals("OPTIONS")){
            crc.abortWith(Response.status(Response.Status.OK).build());
        }
        
        Authenticator auth = new Authenticator();
        
        
        if(!path.startsWith("/login") && !(path.startsWith("/alunos") && crc.getRequest().getMethod().equals("POST"))){
            String authToken = crc.getHeaderString(Headers.TOKEN);
            
            if(!auth.isTokenValid(authToken)){
                crc.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }
    }
    
}
