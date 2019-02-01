package com.rest.security.controller;

import com.rest.security.domain.Quote;
import com.rest.security.service.implementation.RestApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @Autowired
    private RestApiServiceImpl restApiService;

    @RequestMapping("/hello")
    public String home(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Welcome " + name + ". Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/randomClient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Quote> randomClient() {
        try {
            return new ResponseEntity<>(restApiService.randomClient(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
