package org.acme.seed

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import org.acme.service.UsuarioService
import org.acme.model.Usuario
import io.quarkus.runtime.StartupEvent

data class UsuarioSeedData(val nome: String, val email: String, val senha: String)

@ApplicationScoped
class UsuarioSeed(private val usuarioService: UsuarioService){
    

    fun onStart(@Observes event: StartupEvent){
        
        if(usuarioService.listarTodos().isEmpty()){

            val usuarios = listOf(
                    UsuarioSeedData("Ana Silva", "ana.silva@example.com", "senha123"),
                    UsuarioSeedData("Carlos Oliveira", "carlos.oliveira@example.com", "senha456"),
                    UsuarioSeedData("Mariana Costa", "mariana.costa@example.com", "senha789")
                )

                usuarios.forEach { usuario ->
                    usuarioService.criarUsuario(usuario.nome, usuario.email, usuario.senha)
                }
            println("Seed de usuarios realizada com sucesso")
        } else {
            println("Usuarios ja existem no banco de dados")
        }
    }
}