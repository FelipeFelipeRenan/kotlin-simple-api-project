package org.acme.repository

import jakarta.enterprise.context.ApplicationScoped
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import org.acme.model.Emprestimo


@ApplicationScoped
class EmprestimoRepository: PanacheRepository<Emprestimo>