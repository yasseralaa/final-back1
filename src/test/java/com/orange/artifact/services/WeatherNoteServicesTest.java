package com.orange.artifact.services;

import com.orange.artifact.Weather.Weather;
import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.repository.WeatherNoteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WeatherNoteServicesTest {

    @Mock
    WeatherNoteRepository weatherNoteDao;

    @Mock
    PredefinedNoteServices predefinedNoteServices;

    @InjectMocks
    WeatherNoteServices weatherNoteServices;

    PredefinedNotes setPredefinedNotes(Integer id , Integer minimumTemprature , Integer maximumTemperature , String message){
        PredefinedNotes predefinedNotes = new PredefinedNotes();
        predefinedNotes.setId(id);
        predefinedNotes.setMinimumTemprature(minimumTemprature);
        predefinedNotes.setMaximumTemperature(maximumTemperature);
        predefinedNotes.setMessage(message);
        return predefinedNotes;
    }

    List<PredefinedNotes> getAllPredefinedNotes(){
        List<PredefinedNotes> predefinedNotesList = new ArrayList<PredefinedNotes>();
        predefinedNotesList.add(setPredefinedNotes(1,1,10,"First"));
        predefinedNotesList.add(setPredefinedNotes(2,11,20,"Second"));
        predefinedNotesList.add(setPredefinedNotes(3,21,30,"Third"));
        predefinedNotesList.add(setPredefinedNotes(4,31,1000,"Fourth"));
        return  predefinedNotesList;
    }

    @Test
    public void getWeatherNoteWithNoteExist(){
        String note = "NoteExist";
        WeatherNote weatherNote = new WeatherNote();
        weatherNote.setNote(note);
        String actual = weatherNoteServices.getWeatherNote(33.3,weatherNote);
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,note);
    }

    @Test
    public void getPredefinedNoteTestCase1(){
        when(predefinedNoteServices.getAllpredefinedNotes()).thenReturn(getAllPredefinedNotes());
        String actual = weatherNoteServices.getWeatherNote(1.0,null);
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,"First");
    }

    @Test
    public void getPredefinedNoteTestCase2(){
        when(predefinedNoteServices.getAllpredefinedNotes()).thenReturn(getAllPredefinedNotes());
        String actual = weatherNoteServices.getWeatherNote(10.0,null);
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,"First");
    }


    @Test
    public void getPredefinedNoteTestCase3(){
        when(predefinedNoteServices.getAllpredefinedNotes()).thenReturn(getAllPredefinedNotes());
        String actual = weatherNoteServices.getWeatherNote(10.01,null);
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,"Second");
    }


    @Test
    public void getPredefinedNoteTestCase4(){
        when(predefinedNoteServices.getAllpredefinedNotes()).thenReturn(getAllPredefinedNotes());
        String actual = weatherNoteServices.getWeatherNote(19.99,null);
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,"Second");
    }


    @Test
    public void getPredefinedNoteTestCase5(){
        when(predefinedNoteServices.getAllpredefinedNotes()).thenReturn(getAllPredefinedNotes());
        String actual = weatherNoteServices.getWeatherNote(25.0,null);
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,"Third");
    }


    @Test
    public void getPredefinedNoteTestCase6(){
        when(predefinedNoteServices.getAllpredefinedNotes()).thenReturn(getAllPredefinedNotes());
        String actual = weatherNoteServices.getWeatherNote(33.3,null);
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,"Fourth");
    }


}
