package org.acme.spring.web.integration;

import org.acme.spring.web.model.response.CepResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RegisterRestClient(configKey = "cep.base.url")
public interface CepIntegration {

    @GET
    @Path("/{cep}/json")
    @Produces(MediaType.APPLICATION_JSON)
    Optional<CepResponse> getCep(@PathParam("cep") String cep);
}
