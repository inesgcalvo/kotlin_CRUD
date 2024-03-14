package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetAllDogsController(private val dogRepository: DogRepository) {
    @GetMapping("/dogs")
    fun execute(): MutableCollection<Dog> {
        return dogRepository.getAll()
    }
}