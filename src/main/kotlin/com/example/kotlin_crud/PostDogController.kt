package com.example.kotlin_crud

import org.springframework.web.bind.annotation.*

// http://127.0.0.1:8080/post/dog?name={NAME}&breed={BREED}&birthDate={BIRTHDATE}&mother={MOTHER}&father={FATHER}

@RestController
class PostDogController(private val dogRepository: DogRepository) {

    @PostMapping("/post/")
    fun addDog(@RequestParam("name") name: String,
               @RequestParam("breed") breed: String,
               @RequestParam("birthDate") birthDate: String,
               @RequestParam("mother", required = false) mother: String?,
               @RequestParam("father", required = false) father: String?): String {
        val dog = Dog(name, breed, "", birthDate, mother, father)
        dogRepository.add(dog)
        return "Dog $name added successfully with id ${dog.id}."
    }
}