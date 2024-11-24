package org.acme.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import io.quarkus.hibernate.orm.panache.PanacheEntity


@Entity
@Table(name = "usuarios")
data class Usuario(
    
    val nome: String,
    val email: String,
    var pontos : Int = 0
) : PanacheEntity () {
    constructor(): this(nome = "", email = "") 
}