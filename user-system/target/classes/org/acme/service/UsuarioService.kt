package org.acme.service

import org.acme.repository.UsuarioRepository
import org.acme.repository.EmprestimoRepository
import org.acme.adapter.LivroRestClient
import org.acme.model.Emprestimo
import org.jboss.resteasy.reactive.common.model.RestClientInterface
import org.eclipse.microprofile.rest.client.inject.RestClient

class UsuarioService(
    val usuarioRepository: UsuarioRepository,
    val emprestimoRepository: EmprestimoRepository,
    
    @RestClient val livroClient: LivroRestClient

    ){

    fun emprestarLivro(usuarioId: Long, livroId: Long): Boolean{
        val usuario = usuarioRepository.findById(usuarioId) ?: return false
        
        val livro = livroClient.obterLivro(livroId) ?: return false
        if(livro.status != "DISPONIVEL" ) return false

        val emprestimo = Emprestimo(usuario = usuario, livroId = livroId)
        EmprestimoRepository.persist(emprestimo)

        livroClient.reservarLivro(livroId, usuarioId)
        
        return true
    }
}