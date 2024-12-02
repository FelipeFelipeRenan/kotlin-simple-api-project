package org.acme.service

import org.acme.repository.UsuarioRepository
import org.acme.repository.EmprestimoRepository
import org.acme.adapter.LivroRestClient
import org.acme.model.Emprestimo
import org.acme.model.Usuario
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.time.LocalDate
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UsuarioService(
    val usuarioRepository: UsuarioRepository,
    val emprestimoRepository: EmprestimoRepository,
    
    @RestClient val livroClient: LivroRestClient

    ){

    fun listarTodos(): List<Usuario>{
        val usuarios = usuarioRepository.findAll()
        return usuarios.list()
    }

    fun criarUsuario(nome: String, email: String, senha: String): Usuario{
        val usuario = Usuario(
            nome = nome,
            email = email,
            senha = senha
        )

        usuario.persist()
        return usuario
    }

    fun emprestarLivro(usuarioId: Long, livroId: Long): Boolean{
        val usuario = usuarioRepository.findById(usuarioId) ?: return false
        
        val livro = livroClient.obterLivro(livroId) ?: return false
        if(livro.status != "DISPONIVEL" ) return false

        val emprestimo = Emprestimo(usuario = usuario, livroId = livroId)
        emprestimoRepository.persist(emprestimo)

        livroClient.reservarLivro(livroId, usuarioId)
        
        return true
    }


    fun devolverLivro(emprestimoId: Long): Boolean{
        val emprestimo = emprestimoRepository.findById(emprestimoId) ?: return false
        
        if (emprestimo.status != "EM ANDAMENTO") return false

        // emprestimo finalizado
        emprestimo.status =  "FINALIZADO"
        emprestimo.dataDevolução = LocalDate.now()

        // atualiza status do livro para disponivel
        livroClient.atualizarStatusLivro(emprestimo.livroId, "DISPONIVEL")

        // atualiza pontos do usuario
        val usuario = emprestimo.usuario
        if(usuario == null){
            throw IllegalArgumentException("Usuario nao pode ser nulo ao devolver livro")
        }
        usuario.pontos += 10
        usuarioRepository.persist(usuario)

        return true
    }

    fun listarEmprestimos(usuarioId: Long) : List<Emprestimo>{
        return emprestimoRepository.list("usuario.id", usuarioId)
    }

    fun listarUsuariosMaisAtivos(): List<Usuario> {
        return usuarioRepository.list("ORDER BY pontos DESC").take(5)
    }
}