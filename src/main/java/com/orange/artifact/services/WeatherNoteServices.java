package com.orange.artifact.services;

import com.orange.artifact.errorhandling.EntityNotFoundException;
import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.repository.WeatherNoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service("weatherNoteServices")
@Transactional
public class WeatherNoteServices {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WeatherNoteRepository weatherNoteDao;
    public ArrayList<WeatherNote> getAllWeatherNotes(){
        return (ArrayList<WeatherNote>) weatherNoteDao.findAll();

    }

    @Autowired
    PredefinedNoteServices predefinedNoteServices;

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

    public List<WeatherNote> getAllWeatherNotes(Integer userId){
        logger.info("In WeatherNoteServices : getAllWeatherNotes Function is called");
        return  weatherNoteDao.findByUser(userId);
    }

    public WeatherNote findWeatherNote(Integer id){
        return weatherNoteDao.findById(id).get();
    }
    public WeatherNote findWeatherNote(Date date) {
        logger.info("In WeatherNoteServices : findWeatherNote Function is called");
        return weatherNoteDao.findByDate(date);
    }

    public void delete(WeatherNote weatherNote){weatherNoteDao.delete(weatherNote);}

    public void saveWeatherNote(WeatherNote weatherNote) throws EntityNotFoundException {
        WeatherNote weatherNote1 = findWeatherNote(new Date(System.currentTimeMillis()));
        if(weatherNote1 == null) {
            weatherNoteDao.save(weatherNote);
            System.out.println("today's note has been inserted");
        }
        else {
            System.out.println("updating todays note");
            System.out.println("today's note: "+weatherNote.getNote());
            System.out.println("new note: "+weatherNote.getNote());
            weatherNote1.setNote(weatherNote.getNote());
            weatherNoteDao.save(weatherNote1);
            System.out.println("today's note has been updated");
        }
    }

}
