package org.acme.spring.web.controller;

import org.acme.spring.web.entities.Product;
import org.acme.spring.web.model.request.ProductRequest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @GET
    public Response findAll() {
        return Response.ok(Product.listAll()).build();
    }

    @POST
    @Transactional
    public Response create(ProductRequest productRequest) {
        var product = new Product();
        product.setName(productRequest.getName());
        product.setValue(productRequest.getValue());
        product.persist();
        return Response.created(null).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, ProductRequest productRequest) {
        var savedProduct = (Product) Product.findByIdOptional(id).orElseThrow(NotFoundException::new);
        savedProduct.setName(productRequest.getName());
        savedProduct.setValue(productRequest.getValue());
        savedProduct.persist();
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Product.findByIdOptional(id).orElseThrow(NotFoundException::new);
        Product.deleteById(id);
        return Response.noContent().build();
    }
}
