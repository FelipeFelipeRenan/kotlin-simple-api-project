package org.acme.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import java.time.LocalDate
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity

@Entity
@Table(name = "emprestimos")
data class Emprestimo(

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "usuario_id")
    val usuario: Usuario? = null,
    
    val livroId: Long,
    val dataEmprestimo: LocalDate = LocalDate.now(),
    var dataDevolução: LocalDate? = null,
    var status: String = "EM ANDAMENTO"

) : PanacheEntity(){
     constructor() : this(null, 0, LocalDate.now(), null, "EM ANDAMENTO")
}