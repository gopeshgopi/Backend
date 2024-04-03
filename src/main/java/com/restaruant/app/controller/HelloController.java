package com.restaruant.app.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

@RestController
public class HelloController {

   @RequestMapping("/hello")
    public ResponseEntity<String> hello()
    {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
