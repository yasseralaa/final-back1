package com.orange.artifact.controller;


import com.orange.artifact.dro.PredifinedNoteDRO;
import com.orange.artifact.dro.WeatherNoteDRO;
import com.orange.artifact.dto.PredifinedNoteDTO;
import com.orange.artifact.dto.WeatherNoteDTO;
import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.services.PredefinedNoteServices;
import com.orange.artifact.services.WeatherAPIServices;
import com.orange.artifact.services.WeatherNoteDTOServices;
import com.orange.artifact.services.WeatherNoteServices;
import com.orange.artifact.validator.WeatherNoteDTOValidator;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
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
    PredefinedNoteServices predifinedNoteServices;

    @Autowired
    WeatherNoteDTOServices weatherNoteDTOServices;

    @Autowired
    WeatherNoteDTOValidator weatherNoteDTOValidator;

    @Autowired
    WeatherAPIServices weatherAPIServices;

    @Autowired
    ModelMapper modelMapper;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/addnote" , method = {POST,PUT})
    public void addWeatherNotes(@RequestBody /*@Validated(WeatherNoteDTOValidator.class)*/ WeatherNoteDRO weatherNoteDRO /*, BindingResult result*/) {
        WeatherNote weatherNote = modelMapper.map(weatherNoteDRO, WeatherNote.class);
        weatherNoteServices.saveWeatherNote(weatherNote);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/getnote" , method = RequestMethod.GET)
    public String getWeatherNotes(){
        WeatherNote weatherNote = weatherNoteServices.findWeatherNote(new Date(System.currentTimeMillis()));
        Double temperature = weatherAPIServices.getTemperature();
        return weatherNoteServices.getWeatherNote(temperature , weatherNote);
    }


    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/getadminnote" , method = {GET})
    public List<WeatherNoteDTO> getAdminOldNotes(){
        List<WeatherNote> weatherNoteList= weatherNoteServices.getAllWeatherNotes();
        Type targetListType = new TypeToken<List<WeatherNoteDTO>>() {}.getType();
        List<WeatherNoteDTO> weatherDTOs = modelMapper.map(weatherNoteList, targetListType);
        return weatherDTOs;
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/getpredifinednotes" , method = RequestMethod.GET)
    public List<PredifinedNoteDTO> getPredifinedNotes(){
        List<PredefinedNotes> predefinedNotes = predifinedNoteServices.getAllpredefinedNotes();
        Type targetListType = new TypeToken<List<PredifinedNoteDTO>>() {}.getType();
        List<PredifinedNoteDTO> predefinedDTOs = modelMapper.map(predefinedNotes, targetListType);
        return predefinedDTOs;
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping(value = "/updatepredifined" , method = {POST,PUT})
    public void updatePredifinedNotes(@RequestBody PredifinedNoteDRO predifinedNoteDRO) {
        PredefinedNotes predefinedNotes = predifinedNoteServices.findpredefinedNotes(predifinedNoteDRO.getId());
        predifinedNoteServices.updatepredefinedNotes(predifinedNoteDRO.getMessage(), predefinedNotes);
    }
}
