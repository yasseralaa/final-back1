package com.orange.artifact.controller;

import com.orange.artifact.Weather.Weather;
import com.orange.artifact.services.WeatherAPIServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WeatherAPIServices weatherAPIServices;

    //NO DTOs HERE, IT's AN API THEY SHOULD CONTROLLER THEIR DATA THEMSELVES
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/today",method = {GET})
    public Weather getWeather(){
        Weather weather = weatherAPIServices.getWeather();
        return weather;
    }
}
