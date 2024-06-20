package com.chaz8080.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World, again!";
    }

    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "Coach Name: " + coachName + ", Team Name: " + teamName;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run hard 5k!";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is your lucky day!";
    }

}
