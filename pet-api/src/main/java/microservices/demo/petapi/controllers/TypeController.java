package microservices.demo.petapi.controllers;

import io.micronaut.http.annotation.*;
import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.domains.Type;
import microservices.demo.petapi.services.TypeService;


import java.util.List;
import javax.inject.Inject;

@Controller("/type")
public class TypeController {

    @Inject
    private TypeService service;

    @Get
    public List<Type> retrieveTypes() {
        return service.retrieveTypes();
    }

    @Post
    public Type createType(@Body Type type) {
        return service.createType(type);
    }

    @Put
    public Type updateType(@Body Type type) {
        return service.updateType(type);
    }

    @Delete(value = "/{id}")
    public Type deleteType(@PathVariable("id") Integer id) {
        return service.deleteType(id);
    }
}