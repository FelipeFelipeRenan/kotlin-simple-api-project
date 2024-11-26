package org.acme.service

import org.acme.repository.UsuarioRepository
import org.acme.repository.EmprestimoRepository
import org.jboss.resteasy.reactive.common.model.RestClientInterface

class UsuarioService(
    val usuarioRepository: UsuarioRepository,
    val emprestimoRepository: EmprestimoRepository,

    // TODO 
){
    
}