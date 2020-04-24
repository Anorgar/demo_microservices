package microservices.demo.petcore.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import java.util.List;
import javax.inject.Inject;
import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.domains.entities.Pet;
import microservices.demo.petcore.repositories.PetRepository;
import microservices.demo.petcore.services.PetService;

@Controller("/pet")
public class PetController {

  @Inject
  private PetService service;

  @Get
  public List<PetDTO> retrievePets(){
    return service.retrievePets();
  }

  @Delete
  public HttpResponse deletePet(Pet pet){
    return HttpResponse.ok();
  }

}
