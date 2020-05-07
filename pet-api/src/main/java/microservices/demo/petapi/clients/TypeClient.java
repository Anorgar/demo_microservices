package microservices.demo.petapi.clients;

import java.util.List;

import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import microservices.demo.petapi.domains.Type;
import microservices.demo.petapi.exceptions.ApiError;


@Client(value = "http://localhost:8081/type", errorType = ApiError.class)
public interface TypeClient {

    @Get
    List<Type> retrieveTypes();

    @Post
    Type createType(@Body Type type);

    @Put
    Type updateType(@Body Type type);

    @Delete(value = "/{id}")
    Type deleteType(@PathVariable("id") Integer id);

    /*@RequestMapping(method = RequestMethod.DELETE, value = "/pet")
    Pet deletePet();*/

}