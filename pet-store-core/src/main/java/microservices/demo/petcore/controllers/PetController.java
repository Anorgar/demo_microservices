package microservices.demo.petcore.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import io.micronaut.management.endpoint.annotation.Endpoint;
import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.domains.entities.Pet;
import microservices.demo.petcore.services.PetService;

@Endpoint(id = "id",
          prefix = "custom",
          defaultEnabled = true,
          defaultSensitive = false)
@Controller("/pet")
public class PetController {

  @Inject
  private PetService service;


  @Get
  public List<PetDTO> retrievePets(){
    return service.retrievePets();
  }

  @Delete (value = "/{id}")
  public HttpResponse deletePet(@PathVariable Integer id){
      service.deletePet(id);
        return HttpResponse.ok();
  }
  /*@Post
  public HttpResponse PostPet(@Body Pet pet){
    service.PostPet(pet);
    return HttpResponse.created(pet);
  }*/
  @Put
  public HttpResponse PutPet(@Body Pet pet){
      service.PutPet(pet);
      return HttpResponse.ok();
  }
@Get(value ="/{id}")
  public Optional<Pet> retrievePetsByID(Integer id){
  return service.retrievePetsByID(id);

}
}

