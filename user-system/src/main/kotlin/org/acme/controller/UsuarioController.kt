package org.acme.controller

import jakarta.ws.rs.Consumes
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.PUT
import org.acme.model.Emprestimo
import org.acme.service.UsuarioService
import org.acme.model.Usuario

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UsuarioController(val usuarioService: UsuarioService) {

    @GET
    @Path("/all")
    fun listarTodos(): Response{
        return Response.ok(usuarioService.listarTodos()).build()
    }


    @POST
    @Path("/{id}/emprestar/{livroId}")
    fun emprestarLivro(@PathParam("id") id: Long, @PathParam("livroId") livroId: Long): Response {
        return if (usuarioService.emprestarLivro(id, livroId))
                Response.ok("livro emprestado com sucesso").build()
        else Response.status(Response.Status.BAD_REQUEST).entity("Falha na devoluçao!").build()
    }

    @POST
    @Path("/devolver/{emprestimoId}")
    fun devolverLivro(@PathParam("emprestimoId") emprestimoId: Long): Response {
        return if (usuarioService.devolverLivro(emprestimoId))
                Response.ok("Livro devolvido com sucesso!").build()
        else Response.status(Response.Status.BAD_REQUEST).entity("Falha na devolução").build()
    }

    @GET
    @Path("/{id}/emprestimos")
    fun listarEmprestimos(@PathParam("id") id: Long): List<Emprestimo> {
        return usuarioService.listarEmprestimos(id)
    }

    @GET
    @Path("/ativos")
    fun listarUsuariosMaisAtivos(): List<Usuario>{
        return usuarioService.listarUsuariosMaisAtivos()
    }

    @GET
    @Path("/teste/{name}")
    fun testeNome(@PathParam("name") name: String): Response{
        return Response.ok(name).build()
    }
}
