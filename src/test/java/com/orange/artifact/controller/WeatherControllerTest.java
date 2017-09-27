package com.orange.artifact.controller;


import com.google.gson.Gson;
import com.orange.artifact.Controller.UserController;
import com.orange.artifact.Controller.WeatherController;
import com.orange.artifact.Weather.OpenWeather.Main;
import com.orange.artifact.Weather.OpenWeather.OpenWeather;
import com.orange.artifact.Weather.OpenWeather.Wind;
import com.orange.artifact.Weather.Weather;
import com.orange.artifact.model.User;
import com.orange.artifact.services.WeatherAPIServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherControllerTest {
    MockMvc mockMvc;

    @InjectMocks
    private WeatherController weatherController;

    @Mock
    WeatherAPIServices weatherAPIServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(weatherController)
                .build();
    }


    @Test
    public void getWeather() throws Exception{
        OpenWeather openWeather = new OpenWeather();
        Main main = new Main();
        Wind wind = new Wind();

        main.setTemp(304.15);
        main.setPressure(1016);
        main.setHumidity(40);
        main.setTemp_max(304.15);
        main.setTemp_min(304.15);

        wind.setDeg(10);
        wind.setSpeed(5.7);

        openWeather.setMain(main);
        openWeather.setWind(wind);

        when(weatherAPIServices.getWeather()).thenReturn(openWeather);
        ResultActions actions =
                mockMvc
                .perform(get("/weather/today"))
                .andExpect(status().isOk());

        Gson gson = new Gson();
        Weather actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), OpenWeather.class);

        Assert.assertNotNull(actual);
        Assert.assertEquals(((OpenWeather)actual).getMain().getTemp(), openWeather.getMain().getTemp());
        Assert.assertEquals(((OpenWeather)actual).getMain().getPressure(), openWeather.getMain().getPressure());
        Assert.assertEquals(((OpenWeather)actual).getMain().getHumidity(), openWeather.getMain().getHumidity());
        Assert.assertEquals(((OpenWeather)actual).getMain().getTemp_max(), openWeather.getMain().getTemp_max());
        Assert.assertEquals(((OpenWeather)actual).getMain().getTemp_min(), openWeather.getMain().getTemp_min());
        Assert.assertEquals(((OpenWeather)actual).getWind().getDeg(), openWeather.getWind().getDeg());
        Assert.assertEquals(((OpenWeather)actual).getWind().getSpeed(), openWeather.getWind().getSpeed());
    }

}
