package com.example.clientes

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "clientes")
data class ClientesModel(

    @Id @GeneratedValue
    var id: Long? = null,
    val nome: String ? = null,
    val endereco: String ? = null,
    val bairro: String ? = null,
    val cidade: String ? = null,
    val uf: String ? = null,
    val celular: String ? = null
)