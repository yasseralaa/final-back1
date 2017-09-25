package com.orange.artifact.services;

import com.orange.artifact.Weather.OpenWeather.OpenWeather;
import com.orange.artifact.Weather.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("weatherAPIServices")
public class WeatherAPIServices {
    RestTemplate restTemplate = new RestTemplate();
    @Value("${weather.url}")
    String weatherURL;
    @Value("${weather.name}")
    String name;

    public Weather getWeather(){
        if(name == null){
            return null;
        }
        if(name.equalsIgnoreCase("openweather")) {
            OpenWeather openWeather = restTemplate.getForObject(weatherURL, OpenWeather.class);
            return openWeather;
        }
        return null;
    }

    public Double getTemperature(){
        if(name.equalsIgnoreCase("openweather")){
            OpenWeather openWeather = restTemplate.getForObject(weatherURL, OpenWeather.class);
            return  openWeather.getMain().getTemp();
        }
        return null;
    }

}
