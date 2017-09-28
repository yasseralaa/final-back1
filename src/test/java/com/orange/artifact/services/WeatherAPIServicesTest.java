package com.orange.artifact.services;

import com.orange.artifact.Weather.Weather;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherAPIServicesTest {

    @Autowired
    WeatherAPIServices weatherAPIServices;

    @Test
    public void getWeatherTest(){
        Weather weather = weatherAPIServices.getWeather();
        Assert.assertNotNull(weather);
    }

    @Test
    public void getTemperatureTest(){
        Double temperature = weatherAPIServices.getTemperature();
        Assert.assertNotNull(temperature);
    }

}


