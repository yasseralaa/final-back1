package com.orange.artifact.services;

import com.orange.artifact.errorhandling.EntityNotFoundException;
import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.User;
import com.orange.artifact.repository.PredefinedNotesRepository;
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
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PredefinedNoteServicesTest {

    @Mock
    PredefinedNotesRepository predefinedNotesDao;

    @InjectMocks
    PredefinedNoteServices predefinedNoteServices;

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
    public void getAllpredefinedNotes(){
        List<PredefinedNotes> allPredefinedNotes = getAllPredefinedNotes();
        when(predefinedNotesDao.findAll()).thenReturn(allPredefinedNotes);
        List<PredefinedNotes> actual = predefinedNoteServices.getAllpredefinedNotes();
        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,allPredefinedNotes);
    }

    @Test
    public void updatepredefinedNotesTest(){
        String messageNote = "updated predefined notes";
        PredefinedNotes predefinedNote = new PredefinedNotes();
        predefinedNote.setMaximumTemperature(10);
        predefinedNote.setMinimumTemprature(1);
        predefinedNote.setId(1);
        predefinedNoteServices.updatepredefinedNotes(messageNote,predefinedNote);
    }

}
