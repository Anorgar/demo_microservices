package microservices.demo.petapi.controllers;

import microservices.demo.petapi.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {

  @Autowired
  private PetService service;

  @GetMapping(value = "/pet")gr
  public String retrievePets(Model model){
    model.addAttribute("pets", service.retrievePets());
    return "pet";
  }

  @RequestMapping("/home")
  public String Home() {
    return "home";
  }



}
