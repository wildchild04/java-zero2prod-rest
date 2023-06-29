package com.example.zero2prodrest.service;

import com.example.zero2prodrest.model.Greeting;

public interface GreetingService {

    Greeting getGreeting(String id);

    Greeting createGreeting(String message);

}
