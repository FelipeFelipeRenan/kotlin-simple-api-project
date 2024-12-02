package org.acme.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import jakarta.persistence.OneToMany
import jakarta.persistence.CascadeType
import jakarta.persistence.FetchType
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity


@Entity
@Table(name = "usuarios")
data class Usuario(
    
    val nome: String,
    val email: String,
    val senha: String,
    var pontos : Int = 0,
    @OneToMany(mappedBy = "usuario", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val emprestimos: List<Emprestimo> = mutableListOf()

) : PanacheEntity () {
    constructor(): this(nome = "", email = "", senha = "") 
}