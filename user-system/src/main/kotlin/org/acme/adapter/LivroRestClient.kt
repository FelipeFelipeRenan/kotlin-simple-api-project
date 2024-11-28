package org.acme.adapter

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Consumes

import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.POST
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.acme.models.Livro

@RegisterRestClient(configKey = "livros-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces()
interface LivroRestClient{

    @GET
    @Path("/id")
    fun obterLivro(@PathParam("id") id: Long): Livro?

    @POST
    @Path("/{id}/reservar")
    fun reservarLivro(@PathParam("id") id: Long, usuarioId: Long): Boolean

    @POST
    @Path("/{id}/atualizar-status")
    fun atualizarStatusLivro(@PathParam("id") id : Long, status: String) : Boolean


}