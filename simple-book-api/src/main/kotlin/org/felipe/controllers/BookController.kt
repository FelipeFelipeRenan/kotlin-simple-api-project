package org.felipe.controllers

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.DELETE
import org.felipe.models.Livro
import org.felipe.service.LivrosService

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class LivroResource(val livrosService: LivrosService) {

    @GET
    @Path("/test")
    fun test(): String {
        return "Hello world"
    }
    
    @GET fun listarLivros(): List<Livro> = livrosService.listAllLivros()

    @GET
    @Path("/{id}")
    fun findById(@PathParam("id") id: Long): Response {
        val livro = livrosService.findLivrosById(id)
        return if (livro != null) Response.ok(livro).build()
        else Response.status(Response.Status.NOT_FOUND).build()
    }

    @POST
    fun addLivro(livro: Livro): Response {
        livrosService.addLivro(livro)
        return Response.status(Response.Status.CREATED).build()
    }

    @DELETE
    @Path("/{id}")
    fun deleteLivro(@PathParam("id") id: Long): Response {
        livrosService.deleteLivro(id)
        return Response.status(Response.Status.NO_CONTENT).build()
    }
    @GET
    @Path("/name/{name}")
    fun showName(@PathParam("name") name: String): Response {
        return Response.ok("obrigado por entrar em contato $name").build()
    }

}
