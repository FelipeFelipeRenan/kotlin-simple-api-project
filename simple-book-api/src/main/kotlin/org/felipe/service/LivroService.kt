package org.felipe.service

import jakarta.enterprise.context.ApplicationScoped
import org.felipe.repositories.LivrosRepository
import org.felipe.models.Livro

@ApplicationScoped
class LivrosService(val livrosRepository: LivrosRepository){
    fun listAllLivros(): List<Livro> = livrosRepository.listAll()
}