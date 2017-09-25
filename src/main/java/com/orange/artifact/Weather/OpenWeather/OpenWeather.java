package com.orange.artifact.Weather.OpenWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orange.artifact.Weather.Weather;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeather extends Weather{
    private Main main;
    private Wind wind;
}
