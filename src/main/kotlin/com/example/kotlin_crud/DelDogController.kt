package com.example.kotlin_crud

import org.springframework.web.bind.annotation.*

// http://127.0.0.1:8080/del/{NAME}

@RestController
class DogController(private val dogRepository: DogRepository) {

    @DeleteMapping("/del/{name}")
    fun deleteDog(@PathVariable name: String) {
        dogRepository.delete(name)
    }
}