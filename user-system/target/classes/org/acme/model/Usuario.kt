package org.acme.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import jakarta.persistence.OneToMany
import jakarta.persistence.CascadeType
import jakarta.persistence.FetchType
<<<<<<< HEAD
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
=======
import io.quarkus.hibernate.orm.panache.PanacheEntity
>>>>>>> a7d7259f41b9ac16803d253e2820929bf43d4a9e


@Entity
@Table(name = "usuarios")
data class Usuario(
    
    val nome: String,
    val email: String,
    var pontos : Int = 0,
    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val emprestimos: List<Emprestimo> = mutableListOf()

) : PanacheEntity () {
    constructor(): this(nome = "", email = "") 
}