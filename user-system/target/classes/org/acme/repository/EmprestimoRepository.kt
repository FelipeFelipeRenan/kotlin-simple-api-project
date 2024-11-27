package org.acme.repository

import jakarta.enterprise.context.ApplicationScoped
<<<<<<< HEAD
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
=======
import io.quarkus.hibernate.orm.panache.PanacheRepository
>>>>>>> a7d7259f41b9ac16803d253e2820929bf43d4a9e
import org.acme.model.Emprestimo


@ApplicationScoped
class EmprestimoRepository: PanacheRepository<Emprestimo>