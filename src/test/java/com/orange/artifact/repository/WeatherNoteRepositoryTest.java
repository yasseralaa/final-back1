package com.orange.artifact.repository;

import com.orange.artifact.Weather.Weather;
import com.orange.artifact.model.WeatherNote;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherNoteRepositoryTest {

    @Autowired
    WeatherNoteRepository weatherNoteDao;

    @Test
    public void getFirstWeatherNoteByDate(){
        Date day = new Date(117,8,5);
        WeatherNote weatherNote = weatherNoteDao.findByDate(day);
        Assert.assertNotNull(weatherNote);
        Assert.assertEquals("Note number 1",weatherNote.getNote());
    }

    @Test
    public void getSecondWeatherNoteByDate(){
        Date day = new Date(117,8,24);
        WeatherNote weatherNote = weatherNoteDao.findByDate(day);
        Assert.assertNotNull(weatherNote);
        Assert.assertEquals("Second Note",weatherNote.getNote());
    }


    @Test
    public void getWeatherNoteByUnexistingDate(){
        Date day = new Date(111,8,5);
        WeatherNote weatherNote = weatherNoteDao.findByDate(day);
        Assert.assertNull(weatherNote);
    }



}
