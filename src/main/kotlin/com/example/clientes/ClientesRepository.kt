package com.example.clientes

import org.springframework.data.jpa.repository.JpaRepository

interface ClientesRepository : JpaRepository<ClientesModel, Long>