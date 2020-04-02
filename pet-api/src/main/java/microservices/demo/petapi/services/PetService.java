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

  public List<Pet> retrievePets(){
    return Try.of(() -> petClient.retrievePets())
        .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
  }

}
