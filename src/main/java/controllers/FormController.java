package controllers;


import model.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class FormController {

    private static int counter = 0;

    @GetMapping("/form")
    public String fillingOutTheForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "form";
    }


    @PostMapping(value = "/form")
    public String pathDataFromFillingOutTheForm(@ModelAttribute("animal") Animal animal, Model model) {
        System.out.println(animal);
        model.addAttribute("animal", animal);
        return "success-animal-form";
    }
}
