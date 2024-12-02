package org.acme.seed

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import org.acme.service.UsuarioService
import org.acme.model.Usuario
import io.quarkus.runtime.StartupEvent


@ApplicationScoped
class UsuarioSeed(private val usuarioService: UsuarioService){
    

    fun onStart(@Observes event: StartupEvent){
        if(usuarioService.listarTodos().isEmpty()){
            val usuarios = listOf(){
                Usuario(nome = "Ana Silva", email = "ana.silva@example.com", senha = "senha123"),
                Usuario(nome = "Carlos Oliveira", email = "carlos.oliveira@example.com", senha = "senha456"),
                Usuario(nome = "Mariana Costa", email = "mariana.costa@example.com", senha = "senha789")
            }
            
        }
    }
}