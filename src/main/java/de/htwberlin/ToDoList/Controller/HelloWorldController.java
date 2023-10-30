package de.htwberlin.ToDoList.Controller;



import com.sun.tools.attach.AgentInitializationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World!";
    }

}
