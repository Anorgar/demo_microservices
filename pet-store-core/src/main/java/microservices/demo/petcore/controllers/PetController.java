package microservices.demo.petcore.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
import javax.inject.Inject;

import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.services.PetService;

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

}
