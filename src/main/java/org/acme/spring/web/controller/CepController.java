package org.acme.spring.web.controller;

import org.acme.spring.web.integration.CepIntegration;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cep")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CepController {

    @Inject
    @RestClient
    CepIntegration cepIntegration;

    @GET
    @Path("{cep}")
    public Response hello(@PathParam("cep") String cep) {
        var cepResponse = cepIntegration.getCep(cep);
        if (cepResponse.isPresent()) {
            return Response.ok(cepResponse.get()).build();
        }
        return Response.noContent().build();
    }
}
