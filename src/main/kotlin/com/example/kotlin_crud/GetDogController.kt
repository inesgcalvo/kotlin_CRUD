package com.example.kotlin_crud

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

// http://127.0.0.1:8080/get/?name={NAME}

@RestController
class GetDogController(private val dogRepository: DogRepository) {

    @GetMapping("/get/")
    fun index(@RequestParam("name") name: String): Dog? {
        val dog = dogRepository.get(name)
        return if (dog != null) {
            dog
        } else {
            null
        }
    }
}