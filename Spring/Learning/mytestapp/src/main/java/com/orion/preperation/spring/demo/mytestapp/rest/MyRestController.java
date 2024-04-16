package com.orion.preperation.spring.demo.mytestapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    // Inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    // Expose new endpoint for teaminfo
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach name: " + coachName + ", Team name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello()  {
        return "Hello World!!!";
    }

    @GetMapping("/hi")
    public String sayHi()  {
        return "Hi World!!!";
    }
}
