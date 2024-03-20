package com.example.kotlin_crud

import org.springframework.web.bind.annotation.*

// http://127.0.0.1:8080/put/{NAME}?newName={NEW_NAME}2&breed={BREED}&birthDate={BIRTHDATE}&mother={MOTHER}&father={FATHER}

@RestController
class PutDogController(private val dogRepository: DogRepository) {

    @PutMapping("/put/{name}/")
    fun updateDog(@PathVariable name: String,
                  @RequestParam("newName") newName: String?,
                  @RequestParam("breed") breed: String?,
                  @RequestParam("birthDate") birthDate: String?,
                  @RequestParam("mother", required = false) mother: String?,
                  @RequestParam("father", required = false) father: String?): String {
        val dog = dogRepository.get(name)
        if (dog != null) {
            newName?.let { dog.name = it }
            breed?.let { dog.breed = it }
            birthDate?.let { dog.birthDate = it }
            mother?.let { dog.mother = it }
            father?.let { dog.father = it }
            dogRepository.update(dog)
            return "Dog with name $name updated successfully."
        } else {
            return "Dog with name $name does not exist."
        }
    }
}
