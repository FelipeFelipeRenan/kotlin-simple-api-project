package org.acme.models

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity

@Entity
data class Livro(

        // PanacheEntity ja vem com ID por padrao, porém pode usar o ID se
        // se escolher o

        var title: String,
        var author: String,
        var isbn: String
        var status: String = "DISPONIVEL"
        
) : PanacheEntity() {
    constructor() : this(title = "", author = "", isbn = "")
}
