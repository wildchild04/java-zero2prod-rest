package com.example.zero2prodrest.controller;

import com.example.zero2prodrest.dto.GreetingDto;
import com.example.zero2prodrest.model.Greeting;
import com.example.zero2prodrest.service.GreetingService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Log4j2
@AllArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @GetMapping("/greeting/{id}")
    public Greeting getGreeting(@PathVariable String id) {

        log.traceEntry("[id:{}]", id);
        log.traceExit();
        return service.getGreeting(id);
    }

    @PostMapping("/greeting")
    public Greeting postGreeting(@RequestBody GreetingDto greeting) {

        log.traceEntry("[message:{}]", greeting.toString());
        log.traceExit();
        return service.createGreeting(greeting.content());
    }
}
