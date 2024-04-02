package com.example.DiningReviewProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiningController {

  @GetMapping("/helloworld")
  public String helloWorld() {
    return "Hello World!";
  }
}