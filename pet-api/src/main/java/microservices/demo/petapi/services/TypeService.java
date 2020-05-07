package microservices.demo.petapi.services;

import io.vavr.control.Try;

import java.util.List;

import microservices.demo.petapi.clients.TypeClient;
import microservices.demo.petapi.domains.Type;
import microservices.demo.petapi.exceptions.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {

    @Autowired
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

/*    public Type deleteType() {
        return Try.of(() -> typeClient.deleteType())
                .getOrElseThrow(e -> new ApiException(e.getMessage(), 500));
    }*/

    /*public Pet createPet() {
        try {
            petClient.createPet();

        } catch  {*/


}
