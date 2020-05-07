package microservices.demo.petapi.clients;

import java.util.List;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.exceptions.ApiError;


@Client(value = "http://localhost:8081/pet", errorType = ApiError.class)
public interface PetClient {

    @Get
    List<Pet> retrievePets();

    @Post
    Pet createPet(@Body Pet pet);

    @Put
    Pet updatePet(@Body Pet pet);

    @Delete(value = "/{id}")
    Pet deletePet(@PathVariable("id") Integer id);

}
