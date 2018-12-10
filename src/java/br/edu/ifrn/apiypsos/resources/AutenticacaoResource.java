package br.edu.ifrn.apiypsos.resources;

import br.edu.ifrn.apiypsos.domain.Aluno;
import br.edu.ifrn.apiypsos.useful.Authenticator;
import com.google.gson.Gson;

import javax.security.auth.login.LoginException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author matheus
 */
@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AutenticacaoResource{
    
    @POST
    public Response login(Aluno aluno){
        Authenticator auth = new Authenticator();
        try {
            String token = auth.login(aluno);
            String r = new Gson().toJson(token);
            System.out.println("Resposta: " +r);
            return Response.ok(r).build();
            
        } catch (LoginException ex) {
            String r = new Gson().toJson("Erro ao logar");
            return Response.status(Response.Status.UNAUTHORIZED).entity(r).build();
        }
        
    }
}
