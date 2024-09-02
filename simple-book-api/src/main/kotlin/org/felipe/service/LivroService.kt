package org.felipe.service

import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.felipe.repositories.LivrosRepository
import org.felipe.models.Livro

@ApplicationScoped
class LivrosService(val livrosRepository: LivrosRepository){
    fun listAllLivros(): List<Livro> = livrosRepository.listAll()

    fun findLivrosById(id : Long): Livro? = livrosRepository.findById(id)

    @Transactional
    fun addLivro(livro: Livro){
        livrosRepository.persist(livro)
    }

    @Transactional
    fun deleteLivro(id: Long){
        livrosRepository.deleteById(id)
    }
}