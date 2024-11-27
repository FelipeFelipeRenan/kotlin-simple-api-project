package org.acme.service

import org.acme.repository.UsuarioRepository
import org.acme.repository.EmprestimoRepository
<<<<<<< HEAD
import org.acme.adapter.LivroRestClient
import org.acme.model.Emprestimo
import org.jboss.resteasy.reactive.common.model.RestClientInterface
import org.eclipse.microprofile.rest.client.inject.RestClient
=======
import org.jboss.resteasy.reactive.common.model.RestClientInterface
>>>>>>> a7d7259f41b9ac16803d253e2820929bf43d4a9e

class UsuarioService(
    val usuarioRepository: UsuarioRepository,
    val emprestimoRepository: EmprestimoRepository,
<<<<<<< HEAD
    
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
=======

    // TODO 
){
    
>>>>>>> a7d7259f41b9ac16803d253e2820929bf43d4a9e
}