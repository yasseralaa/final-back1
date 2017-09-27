package com.orange.artifact.services;

import com.orange.artifact.Weather.OpenWeather.OpenWeather;
import com.orange.artifact.Weather.Weather;
import com.orange.artifact.dto.WeatherNoteDTO;
import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.User;
import com.orange.artifact.model.WeatherNote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("weatherNoteDTOServices")
public class WeatherNoteDTOServices {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserServices userServices;

    @Autowired
    PredefinedNoteServices predefinedNoteServices;

    public WeatherNote ConvertWeatherNoteDTOTOWeatherNote(WeatherNoteDTO weatherNoteDTO){

        logger.info("In WeatherNoteDTOServices : ConvertWeatherNoteDTOTOWeatherNote Function is called");


        WeatherNote weatherNote = new WeatherNote();
        User user = userServices.findUser(weatherNoteDTO.getId());

        weatherNote.setDate(weatherNoteDTO.getDate());
        weatherNote.setNote(weatherNoteDTO.getNote());
        weatherNote.setUser(user);

        return weatherNote;
    }

    public String getWeatherNote(Double temperature , WeatherNote weatherNote){

        logger.info("In WeatherNoteDTOServices : getWeatherNote Function is called");

        if(weatherNote == null){
            List<PredefinedNotes> predefinedNotesList = predefinedNoteServices.getAllpredefinedNotes();
            for(PredefinedNotes predefinedNotes: predefinedNotesList){
                if(temperature <= predefinedNotes.getMaximumTemperature()){
                    return predefinedNotes.getMessage();
                }
            }
        }else{
            return  weatherNote.getNote();
        }
        return null;
    }

}
