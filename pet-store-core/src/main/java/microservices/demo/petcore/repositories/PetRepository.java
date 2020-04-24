package microservices.demo.petcore.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import microservices.demo.petcore.domains.entities.Pet;

import javax.inject.Inject;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {


}
