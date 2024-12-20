package org.felipe.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "livros")
data class Livro(

        // PanacheEntity ja vem com ID por padrao, porém pode usar o ID se
        // se escolher o

        var title: String,
        var author: String,
        var isbn: String
) : PanacheEntity() {
    constructor() : this(title = "", author = "", isbn = "")
}
