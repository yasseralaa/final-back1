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

    @Autowired
    WeatherNoteRepository weatherNoteDao;

    public ArrayList<WeatherNote> getAllWeatherNotes() {
        return (ArrayList<WeatherNote>) weatherNoteDao.findAll();
    }


    public WeatherNote findWeatherNote(Date date) {
        WeatherNote weatherNote = weatherNoteDao.findByDate(date);
        return weatherNote;
    }

    public void saveWeatherNote(WeatherNote weatherNote) {
        WeatherNote weatherNote1 = findWeatherNote(new Date(System.currentTimeMillis()));
        if (weatherNote1 == null) {
            weatherNoteDao.save(weatherNote);
        } else {
            weatherNote1.setNote(weatherNote.getNote());
            weatherNoteDao.save(weatherNote1);
        }
    }



}
