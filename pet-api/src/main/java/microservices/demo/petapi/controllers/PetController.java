package microservices.demo.petapi.controllers;

import microservices.demo.petapi.domains.Pet;
import microservices.demo.petapi.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping(value = "/pet")
    public String retrievePets(Model model) {
        model.addAttribute("pets", service.retrievePets());
        return "pet";
    }

    @PostMapping(value = "/pet")
    public Pet createPet(@RequestBody Pet pet) {
        return service.createPet(pet);
    }

    @PutMapping(value = "/pet")
    public Pet updatePet(@RequestBody Pet pet) {
        return service.updatePet(pet);
    }

    /*@PostMapping(value = "/pet")
    public String updatePet(Model model) {
        model.addAttribute("pets", service.updatePet());
        return "pet";
    }

    @PostMapping(value = "/pet")
    public String deletePet(Model model) {
        model.addAttribute("pets", service.deletePet());
        return "pet";
    }*/

    @RequestMapping("/home")
    public String Home() {
        return "home";
    }

    @RequestMapping("/type")
    public String Type() {
        return "type";
    }
}
