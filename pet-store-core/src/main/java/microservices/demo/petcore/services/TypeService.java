package microservices.demo.petcore.services;

import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import microservices.demo.petcore.domains.dtos.PetDTO;
import microservices.demo.petcore.domains.dtos.TypeDTO;
import microservices.demo.petcore.domains.entities.Pet;
import microservices.demo.petcore.domains.entities.Type;
import microservices.demo.petcore.exceptions.ApiException;
import microservices.demo.petcore.helpers.TypeMapper;
import microservices.demo.petcore.repositories.TypeRepository;
import org.apache.commons.collections.IteratorUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Singleton

public class TypeService {

    @Inject

    private TypeRepository repository;

    public List<TypeDTO> retrieveTypes() {
        return Try.of(() -> repository.findAll())
                .map(types -> IteratorUtils.toList(types.iterator()))
                .map(TypeMapper::mapEntitiesToDTOs)
                .getOrElseThrow(e -> new ApiException("Unable to retrieve types", 500));
    }

    public void deleteType(Integer id) {

        try {
            repository.deleteById(id);
        } catch (RuntimeException e) {
            log.error("unable to delete Type", e);
            throw new ApiException("Unable to delete types", 500);
        }
    }

    public void PutType(Type type) {

        try {
            repository.update(type);
        } catch (RuntimeException e) {
            log.error("unable to update type", e);
            throw new ApiException("Unable to update types", 500);
        }
    }

    public Optional<Type> retrieveTypesByID(Integer id) {

        return repository.findById(id);

    }

    public TypeDTO createType(TypeDTO type) {

        try {
            repository.save(new Type(type.getId(), type.getType()));
        } catch (RuntimeException e) {
            log.error("unable to create type", e);
            throw new ApiException("Unable to create type", 500);
        }
        return type;
    }


}
