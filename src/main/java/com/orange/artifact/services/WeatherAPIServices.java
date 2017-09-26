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
    String weatherURL;// = "http://api.openweathermap.org/data/2.5/weather?q=cairo&appid=9dc9e56ace548fb9042b05e2c626b127";
    @Value("${weather.name}")
    String name;// = "openweather";

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
