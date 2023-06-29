package com.example.zero2prodrest.service.impl;

import com.example.zero2prodrest.model.Greeting;
import com.example.zero2prodrest.repository.GreetingRepository;
import com.example.zero2prodrest.service.GreetingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository repository;
    @Override
    public Greeting getGreeting(String id) {
        return repository.findById(id)
                .orElse(new Greeting("default", "Hello World"));
    }

    @Override
    public Greeting createGreeting(String message) {
        var greeting = new Greeting(null, message);
        return repository.save(greeting);
    }
}
