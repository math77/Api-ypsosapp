package br.edu.ifrn.apiypsos.filters;

import br.edu.ifrn.apiypsos.useful.Headers;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author matheus
 */

@Provider
@PreMatching
public class ResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestCtx, ContainerResponseContext responseCtx) throws IOException {
       responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
       responseCtx.getHeaders().add("Access-Control-Allow-Credentials", "true");
       responseCtx.getHeaders().add("Access-Control-Methods", "GET, POST, PUT, DELETE");
       responseCtx.getHeaders().add("Access-Control-Allow-Headers", Headers.TOKEN);
    }
    
}
