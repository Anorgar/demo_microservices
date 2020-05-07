package microservices.demo.petapi.controllers;

import microservices.demo.petapi.domains.Type;
import microservices.demo.petapi.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping(value = "/type")
    public String retrieveTypes(Model model) {
        model.addAttribute("types", service.retrieveTypes());
        return "type";
    }

    @PostMapping(value = "/type")
    public Type createType(@RequestBody Type type) {
        return service.createType(type);
    }

    @PutMapping(value = "/type")
    public Type updateType(@RequestBody Type type) {
        return service.updateType(type);
    }

}
