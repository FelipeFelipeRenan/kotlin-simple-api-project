package org.felipe.repositories

import jakarta.enterprise.context.ApplicationScoped
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.felipe.models.Livro

@ApplicationScoped
class LivrosRepository : PanacheRepository<Livro>