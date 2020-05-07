package microservices.demo.petapi.clients;

import java.util.List;

import microservices.demo.petapi.domains.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "type", url = "http://localhost:8081")
public interface TypeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/type")
    List<Type> retrieveTypes();

    @RequestMapping(method = RequestMethod.POST, value = "/type")
    Type createType(@RequestBody Type type);

    @RequestMapping(method = RequestMethod.PUT, value = "/type")
    Type updateType(@RequestBody Type type);

    /*@RequestMapping(method = RequestMethod.DELETE, value = "/pet")
    Pet deletePet();*/

}