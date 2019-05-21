package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//HTTP requests are managed this component called Controller (...).
//The below module manages the GET request

@Controller
public class GreetingController {

    //Below is kinda self explanatory.
    // The greeting function is mapped to /greeting URI.
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
