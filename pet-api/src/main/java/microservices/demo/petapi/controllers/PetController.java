package microservices.demo.petapi.controllers;

import io.micronaut.http.annotation.*;

import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.services.PetService;


import java.util.List;
import javax.inject.Inject;

@Controller("/pet")
public class PetController {

    @Inject
    private PetService service;

    @Get
    public List<Pet> retrievePets() {
        return service.retrievePets();
    }


    @Post
    public Pet createPet(@Body Pet pet) {
        return service.createPet(pet);
    }

    @Put
    public Pet updatePet(@Body Pet pet) {
        return service.updatePet(pet);
    }

    @Delete(value = "/{id}")
    public Pet deletePet(@PathVariable("id") Integer id) {
        return service.deletePet(id);
    }
}
