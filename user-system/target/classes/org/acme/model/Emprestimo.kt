package org.acme.model

import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import java.time.LocalDate

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

)