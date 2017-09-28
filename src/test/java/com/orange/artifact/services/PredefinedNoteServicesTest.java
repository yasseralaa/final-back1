package com.orange.artifact.services;

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

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PredefinedNoteServicesTest {

    @Mock
    PredefinedNotesRepository predefinedNotesDao;

    @InjectMocks
    PredefinedNoteServices predefinedNoteServices;
//
//    @Test
//    public void findpredefinedNotesByIdTest(){
//
//        Integer id = 1;
//        PredefinedNotes predefinedNotes = new PredefinedNotes();
//        predefinedNotes.setId(id);
//        predefinedNotes.setMinimumTemprature(1);
//        predefinedNotes.setMaximumTemperature(10);
//        predefinedNotes.setMessage("");
//
//
//        //Mockito expectations
//        when(predefinedNotesDao.findById(id).get()).thenReturn(predefinedNotes);
//
//
//        // Execute the method being tested
//        PredefinedNotes actual = predefinedNoteServices.findpredefinedNotes(id);
//        Assert.assertNotNull(actual);
//        Assert.assertEquals(actual,predefinedNotes);
//    }

}
