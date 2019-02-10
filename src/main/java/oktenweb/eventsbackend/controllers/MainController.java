package oktenweb.eventsbackend.controllers;

import oktenweb.eventsbackend.models.Event;
import oktenweb.eventsbackend.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class MainController {


    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/")
    public void home() {
    }



    @PostMapping("/saveEvent")
    public String asd(@RequestBody Event event) {
        System.out.println(event);

        eventRepo.save(event);
        return "done";
    }

}


