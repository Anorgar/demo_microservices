package microservices.demo.petapi.services;

import io.vavr.control.Try;

import java.util.List;

import microservices.demo.petapi.clients.PetClient;
import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
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

    public Pet deletePet() {
        return Try.of(() -> petClient.deletePet())
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    /*public Pet createPet() {
        try {
            petClient.createPet();

        } catch  {*/


}
