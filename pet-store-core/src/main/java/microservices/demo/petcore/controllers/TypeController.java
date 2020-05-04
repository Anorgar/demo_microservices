package microservices.demo.petcore.controllers;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import microservices.demo.petcore.domains.dtos.TypeDTO;
import microservices.demo.petcore.domains.entities.Type;
import microservices.demo.petcore.services.TypeService;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller("/type")
public class TypeController {

    @Inject
    private TypeService service;

    @Get
    public List<TypeDTO> retrieveTypes() {
        return service.retrieveTypes();
    }

    @Delete(value = "/{id}")
    public HttpResponse deleteType(@PathVariable Integer id) {
        service.deleteType(id);
        return HttpResponse.ok();
    }

    @Post
    public TypeDTO createType(@Body TypeDTO type) {
       return service.createType(type);
    }

    @Put
    public HttpResponse PutType(@Body Type type) {
        service.PutType(type);
        return HttpResponse.ok();
    }

    @Get(value = "/{id}")
    public Optional<Type> retrieveTypesByID(Integer id) {
        return service.retrieveTypesByID(id);

    }
}
