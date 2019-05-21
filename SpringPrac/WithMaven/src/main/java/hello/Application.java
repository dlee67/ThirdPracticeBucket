package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The below annotation is required pretty much all the time.
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //The line directly below launches the Spring application.
        //Appearantly, in the old days, in order launch a web app in Java,
        //I have to 
        SpringApplication.run(Application.class, args);
    }

}
