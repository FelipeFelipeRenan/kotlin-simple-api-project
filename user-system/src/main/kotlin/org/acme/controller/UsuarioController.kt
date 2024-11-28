package org.acme.controller

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.acme.service.UsuarioService

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UsuarioController(val usuarioService: UsuarioService) {

    @POST
    @Path("/{id}/emprestar/{livroId}")
    fun emprestarLivro(@PathParam("id") id: Long, @PathParam("livroId") livroId: Long): Response {
        return if (usuarioService.emprestarLivro(id, livroId))
                Response.ok("livro emprestado com sucesso").build()
        else Response.status(Response.Status.BAD_REQUEST).entity("Falha na devoluçao!").build()
    }
}
