package com.example.clientes

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/clientes")
class ClientesController(private val repository: ClientesRepository) {

    @PostMapping
    private fun Create(@RequestBody clientesModel: ClientesModel): ClientesModel  = repository.save((clientesModel))

    @GetMapping
    private fun getall(): List<ClientesModel> = repository.findAll()

    @GetMapping( "/{id}")
    private  fun getbyId(@PathVariable id: Long) : ResponseEntity<ClientesModel> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping( "/{id}")
    private fun update(@PathVariable id: Long, @RequestBody clientesModel: ClientesModel): ResponseEntity<ClientesModel> =
        repository.findById(id).map {

            val clientesModelToUpdate = it.copy(
                nome = clientesModel.nome,
                endereco = clientesModel.endereco,
                bairro = clientesModel.bairro,
                cidade = clientesModel.cidade,
                uf = clientesModel.uf,
                celular = clientesModel.celular
            )
            ResponseEntity.ok(repository.save(clientesModelToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping( "/{id}")
    private fun  delete(@PathVariable id: Long): ResponseEntity<Void> =
        repository.findById(id).map{
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}