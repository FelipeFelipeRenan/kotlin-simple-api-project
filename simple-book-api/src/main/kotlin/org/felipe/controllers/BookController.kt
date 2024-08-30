package org.felipe.controllers

import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.PUT
import jakarta.ws.rs.DELETE
import jakarta.transaction.Transactional
import org.felipe.models.Livro
import org.felipe.service.LivrosService

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class LivroResource(val livrosService: LivrosService) {

    @GET
    fun listarLivros(): List<Livro> = livrosService.listAllLivros()

    @GET
    @Path("/test")
    fun test() : String {
        return "Hello world"
    }
}