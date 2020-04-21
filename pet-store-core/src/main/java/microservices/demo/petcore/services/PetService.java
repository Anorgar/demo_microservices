package microservices.demo.petcore.services;

import io.vavr.control.Try;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.exceptions.ApiException;
import microservices.demo.petcore.helpers.PetMapper;
import microservices.demo.petcore.repositories.PetRepository;
import org.apache.commons.collections.IteratorUtils;

@Singleton
public class PetService {

  @Inject
  private PetRepository repository;

  public List<PetDTO> gretrievePets(){
    return Try.of(() -> repository.findAll())
        .map(pets -> IteratorUtils.toList(pets.iterator()))
        .map(PetMapper::mapEntitiesToDTOs)
        .getOrElseThrow(e -> new ApiException("Unable to retrieve pets", 500));
  }

}
