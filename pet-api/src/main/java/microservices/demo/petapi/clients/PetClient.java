package microservices.demo.petapi.clients;

import java.util.List;
import microservices.demo.petapi.domains.Pet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pet", url = "http://localhost:8081")
public interface PetClient {

  @RequestMapping(method = RequestMethod.GET, value = "/pet")
  List<Pet> retrievePets();

}
