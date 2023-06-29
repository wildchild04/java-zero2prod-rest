package com.example.zero2prodrest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Greeting(@Id String id, String content) {}
