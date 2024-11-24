package org.acme.repository

import jakarta.enterprise.context.ApplicationScoped
import io.quarkus.hibernate.orm.panache.PanacheRepository
import org.acme.model.Usuario 


@ApplicationScoped
class UsuarioRepository: PanacheRepository<Usuario>