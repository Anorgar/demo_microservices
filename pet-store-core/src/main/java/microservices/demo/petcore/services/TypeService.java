package microservices.demo.petcore.services;

import microservices.demo.petcore.domains.dtos.TypeDTO;

public class TypeService {

    public void createType(TypeDTO type) {

        try {
            repository.save(new Type(type.getId(), type.getType()))
        } catch (RuntimeException e) {

        }

    }
}
