package com.orange.artifact.Weather.OpenWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private Double temp;
    private Integer pressure;
    private Integer humidity;
    private Double temp_max;
    private Double temp_min;
}
