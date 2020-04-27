package microservices.demo.petcore.controllers;

import microservices.demo.petcore.domains.dtos.TypeDTO;
import
import microservices.demo.petcore.repositories.TypeRepository;
import javax.inject.Inject;

public class TypeController {

    @Inject
    private TypeController repository;

    public void createType(TypeDTO type){

        try {
            repository.save(new Type(type.getId(), type.getType()))
        } catch (RuntimeException e){

        }

    }

}
