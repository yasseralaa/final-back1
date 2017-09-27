package com.orange.artifact.controller;

import com.google.gson.Gson;
import com.orange.artifact.Controller.NotesController;
import com.orange.artifact.Controller.UserController;
import com.orange.artifact.dto.WeatherNoteDTO;
import com.orange.artifact.model.User;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.services.WeatherAPIServices;
import com.orange.artifact.services.WeatherNoteDTOServices;
import com.orange.artifact.services.WeatherNoteServices;
import com.orange.artifact.validator.WeatherNoteDTOValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class NotesControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    private NotesController notesController;

    @Mock
    WeatherNoteServices weatherNoteServices;

    @Mock
    WeatherNoteDTOServices weatherNoteDTOServices;

    @Mock
    WeatherNoteDTOValidator weatherNoteDTOValidator;

    @Mock
    WeatherAPIServices weatherAPIServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(notesController)
                .build();
    }

    @Test
    public void addWeatherNotesTest() throws Exception{

//        Date date = new Date();

       ResultActions actions = mockMvc
                .perform(get("/notes/getnote"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void addWeatherNotesTest() throws Exception {
//        WeatherNoteDTO weatherNoteDTO = new WeatherNoteDTO();
//        WeatherNote weatherNote = new WeatherNote();
//
//
//        weatherNoteDTO.setAdminID(1);
//        weatherNoteDTO.setWeatherDate(new Date(117,4,5));
//        weatherNoteDTO.setWeatherNote("Notes");
//
//        weatherNote.setDate(new Date(117,4,5));
//        weatherNote.setNote("Notes");
//
//        when(weatherNoteDTOServices.ConvertWeatherNoteDTOTOWeatherNote(weatherNoteDTO)).thenReturn(weatherNote);
//
//        ResultActions actions = mockMvc
//                .perform(
//                        post("/notes/addnote")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(new Gson().toJson(weatherNoteDTO))
//                )
//                .andExpect(status().isOk());
//    }

}