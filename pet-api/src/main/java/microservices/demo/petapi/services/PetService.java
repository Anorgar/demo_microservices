package microservices.demo.petapi.services;

import io.vavr.control.Try;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import microservices.demo.petapi.clients.PetClient;
import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.exceptions.ApiException;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class PetService {

    @Inject
    private PetClient petClient;

    public List<Pet> retrievePets() {
        return Try.of(() -> petClient.retrievePets())
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    public Pet createPet(Pet pet) {
        return Try.of(() -> petClient.createPet(pet))
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    public Pet updatePet(Pet pet) {
        return Try.of(() -> petClient.updatePet(pet))
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    public Pet deletePet(Integer id) {
        return Try.of(() -> petClient.deletePet(id))
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    /*public Pet createPet() {
        try {
            petClient.createPet();

        } catch  {*/


}
