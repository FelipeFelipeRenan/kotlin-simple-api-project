package org.acme.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import java.time.LocalDate
<<<<<<< HEAD
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
=======
>>>>>>> a7d7259f41b9ac16803d253e2820929bf43d4a9e

@Entity
@Table(name = "emprestimos")
data class Emprestimo(

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "usuario_id")
    val usuario: Usuario,
    
    val livroId: Long,
    val dataEmprestimo: LocalDate = LocalDate.now(),
    var dataDevolução: LocalDate? = null,
    var status: String = "EM ANDAMENTO"

<<<<<<< HEAD
) : PanacheEntity(){
    constructor(): this(usuario = , livroId= 0, dataEmprestimo = , dataDevolução = null, status = "" )
}
=======
)
>>>>>>> a7d7259f41b9ac16803d253e2820929bf43d4a9e
