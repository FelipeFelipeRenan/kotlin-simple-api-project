package org.felipe.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.felipe.models.Livro
import org.felipe.repositories.LivrosRepository

@ApplicationScoped
class LivrosService(val livrosRepository: LivrosRepository) {
    fun listAllLivros(): List<Livro> = livrosRepository.listAll()

    fun findLivrosById(id: Long): Livro? = livrosRepository.findById(id)

    @Transactional
    fun addLivro(livro: Livro) {
        if (livro.id == null) {
            livrosRepository.persist(livro)
        }
    }
    @Transactional
    fun deleteLivro(id: Long) {
        livrosRepository.deleteById(id)
    }
}
