package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller portion for the MVC.

@RestController // Indicates that class is ready to be used by Spring MVC.
public class HelloController {

   @RequestMapping("/") // Maps the root URL directory to index() method.
   public String index() {
     return "Greetings from Spring Boot!";
   }

   
}
