package microservices.demo.petcore.services;

import io.reactivex.annotations.NonNull;
import io.vavr.control.Try;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.domains.dtos.TypeDTO;
import microservices.demo.petcore.domains.entities.Pet;
import microservices.demo.petcore.domains.entities.Type;
import microservices.demo.petcore.exceptions.ApiException;
import microservices.demo.petcore.helpers.PetMapper;
import microservices.demo.petcore.repositories.PetRepository;
import org.apache.commons.collections.IteratorUtils;

@Slf4j
@Singleton
public class PetService {

    @Inject
    private PetRepository repository;

    public List<PetDTO> retrievePets() {
        return Try.of(() -> repository.findAll())
                .map(pets -> IteratorUtils.toList(pets.iterator()))
                .map(PetMapper::mapEntitiesToDTOs)
                .getOrElseThrow(e -> new ApiException("Unable to retrieve pets", 500));

    }

    public void deletePet(Integer id) {

        try {
            repository.deleteById(id);
        } catch (RuntimeException e) {
            log.error("unable to delete pet", e);
            throw new ApiException("Unable to delete pets", 500);
        }
    }

    public PetDTO updatePet(PetDTO pet) {

        try {
           Pet updated = repository.update(new Pet(pet.getId(), pet.getName(), pet.getNumber(), pet.getPrice(), new Type(pet.getType().getId(), pet.getType().getType())));
           return PetMapper.mapEntityToDTO(updated);
        } catch (RuntimeException e) {
            log.error("unable to update pet", e);
            throw new ApiException("Unable to update pets", 500);
        }
    }

    public Optional<Pet> retrievePetsByID(Integer id) {

        return repository.findById(id);

    }

    public PetDTO createPet(PetDTO pet) {

        try {
           /* new String("test");
            String jean = new String();*/
            Pet created = repository.save(new Pet(pet.getId(), pet.getName(), pet.getNumber(), pet.getPrice(), new Type(pet.getType().getId(), pet.getType().getType())));
            return PetMapper.mapEntityToDTO(created);
        } catch (RuntimeException e) {
            log.error("unable to create pet", e);
            throw new ApiException("Unable to create pets", 500);
        }
    }
}
