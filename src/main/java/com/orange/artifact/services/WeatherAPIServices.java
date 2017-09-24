package com.orange.artifact.services;

import com.orange.artifact.Weather.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("weatherAPIServices")
public class WeatherAPIServices {
    RestTemplate restTemplate = new RestTemplate();
    final String weatherURL = "http://api.openweathermap.org/data/2.5/weather?q=cairo&appid=9dc9e56ace548fb9042b05e2c626b127";

    public Weather getWeather(){
        Weather weather = restTemplate.getForObject(weatherURL,Weather.class);
        return weather;
    }

}
