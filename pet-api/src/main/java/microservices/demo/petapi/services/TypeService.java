package microservices.demo.petapi.services;

import io.vavr.control.Try;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import microservices.demo.petapi.clients.TypeClient;
import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.domains.Type;
import microservices.demo.petapi.exceptions.ApiException;

import javax.inject.Inject;
import javax.inject.Singleton;


@Slf4j
@Singleton
public class TypeService {

    @Inject
    private TypeClient typeClient;

    public List<Type> retrieveTypes() {
        return Try.of(() -> typeClient.retrieveTypes())
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    public Type createType(Type type) {
        return Try.of(() -> typeClient.createType(type))
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    public Type updateType(Type type) {
        return Try.of(() -> typeClient.updateType(type))
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }

    public Type deleteType(Integer id) {
        return Try.of(() -> typeClient.deleteType(id))
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }
/*    public Type deleteType() {
        return Try.of(() -> typeClient.deleteType())
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }*/

    /*public Pet createPet() {
        try {
            petClient.createPet();

        } catch  {*/


}
