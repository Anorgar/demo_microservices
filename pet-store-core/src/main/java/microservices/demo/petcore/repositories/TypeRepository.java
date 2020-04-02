package microservices.demo.petcore.repositories;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import microservices.demo.petcore.domains.entities.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {

}
