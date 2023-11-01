package com.example.event.rest;

import com.example.event.service.EventService;
import com.example.event.service.ServiceDaoMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    //TODO: Autowired has added just for example
    @Autowired
    EventService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMovie(@RequestBody ServiceDaoMap event) {
        service.addEvent(event);
    }
}
