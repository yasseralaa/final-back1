package com.orange.artifact.Weather.OpenWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
    private Double speed;
    private Integer deg;
}
