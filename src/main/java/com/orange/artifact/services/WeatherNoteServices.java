package com.orange.artifact.services;

import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.repository.UserRepository;
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
    public ArrayList<WeatherNote> getAllWeatherNotes(){return (ArrayList<WeatherNote>) weatherNoteDao.findAll();}
    public List<WeatherNote> getAllWeatherNotes(Integer userId){
        logger.info("In WeatherNoteServices : getAllWeatherNotes Function is called");
        return  weatherNoteDao.findByUser(userId);
    }
    public WeatherNote findWeatherNote(Integer id){return weatherNoteDao.findById(id).get();}
    public WeatherNote findWeatherNote(Date date){
        logger.info("In WeatherNoteServices : findWeatherNote Function is called");
        WeatherNote weatherNote = weatherNoteDao.findByDate(date);
        System.out.println(date);
        return weatherNoteDao.findByDate(date);
    }
    public void delete(WeatherNote weatherNote){weatherNoteDao.delete(weatherNote);}
    public void updateWeatherNote(WeatherNote weatherNote){weatherNoteDao.save(weatherNote);}
    public void saveWeatherNote(WeatherNote weatherNote){weatherNoteDao.save(weatherNote);}

}
