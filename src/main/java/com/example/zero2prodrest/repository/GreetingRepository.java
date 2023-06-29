package com.example.zero2prodrest.repository;

import com.example.zero2prodrest.model.Greeting;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GreetingRepository extends MongoRepository<Greeting, String> {


}
