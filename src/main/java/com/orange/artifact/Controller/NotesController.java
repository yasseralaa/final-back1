package com.orange.artifact.Controller;


import com.orange.artifact.Weather.OpenWeather.OpenWeather;
import com.orange.artifact.Weather.Weather;
import com.orange.artifact.dto.WeatherNoteDTO;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.services.WeatherAPIServices;
import com.orange.artifact.services.WeatherNoteDTOServices;
import com.orange.artifact.services.WeatherNoteServices;
import com.orange.artifact.validator.WeatherNoteDTOValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = "/notes")
public class NotesController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WeatherNoteServices weatherNoteServices;

    @Autowired
    WeatherNoteDTOServices weatherNoteDTOServices;

    @Autowired
    WeatherNoteDTOValidator weatherNoteDTOValidator;

    @Autowired
    WeatherAPIServices weatherAPIServices;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/addnote" , method = {POST,PUT})
    public void addWeatherNotes(@RequestBody /*@Validated(WeatherNoteDTOValidator.class)*/ WeatherNoteDTO weatherNoteDTO /*, BindingResult result*/) {
        System.out.println(weatherNoteDTO.getWeatherDate() + " " + weatherNoteDTO.getWeatherNote() + " " + weatherNoteDTO.getAdminID());
        WeatherNote weatherNote = weatherNoteDTOServices.ConvertWeatherNoteDTOTOWeatherNote(weatherNoteDTO);
        weatherNoteServices.saveWeatherNote(weatherNote);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/getnote" , method = RequestMethod.GET)
    public String getWeatherNotes(){
        WeatherNote weatherNote = weatherNoteServices.findWeatherNote(new Date(System.currentTimeMillis()));
        Double temperature = weatherAPIServices.getTemperature();
        return weatherNoteDTOServices.getWeatherNote(temperature , weatherNote);
    }


    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/getadminnote" , method = {GET})
    public List<WeatherNote> getAdminOldNotes(){
        List<WeatherNote> weatherNoteList= weatherNoteServices.getAllWeatherNotes();
        return weatherNoteList;
    }



}
