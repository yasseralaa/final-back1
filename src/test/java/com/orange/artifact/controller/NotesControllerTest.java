package com.orange.artifact.controller;

import com.google.gson.Gson;
import com.orange.artifact.dto.PredifinedNoteDTO;
import com.orange.artifact.dto.UserDTO;
import com.orange.artifact.dto.WeatherNoteDTO;
import com.orange.artifact.model.PredefinedNotes;
import com.orange.artifact.model.WeatherNote;
import com.orange.artifact.services.PredefinedNoteServices;
import com.orange.artifact.services.WeatherAPIServices;
import com.orange.artifact.services.WeatherNoteServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    PredefinedNoteServices predifinedNoteServices;

    @Mock
    WeatherAPIServices weatherAPIServices;

    @Mock
    ModelMapper modelMapper;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(notesController)
                .build();
    }

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

    PredifinedNoteDTO setPredefinedNotesDTO(Integer id , Integer minimumTemprature , Integer maximumTemperature , String message){
        PredifinedNoteDTO predefinedNotesDTO = new PredifinedNoteDTO();
        predefinedNotesDTO.setId(id);
        predefinedNotesDTO.setMinimumTemprature(minimumTemprature);
        predefinedNotesDTO.setMaximumTemperature(maximumTemperature);
        predefinedNotesDTO.setMessage(message);
        return predefinedNotesDTO;
    }

    List<PredifinedNoteDTO> getAllPredefinedNotesDTO(){
        List<PredifinedNoteDTO> predefinedNotesDTOList = new ArrayList<PredifinedNoteDTO>();
        predefinedNotesDTOList.add(setPredefinedNotesDTO(1,1,10,"First"));
        predefinedNotesDTOList.add(setPredefinedNotesDTO(2,11,20,"Second"));
        predefinedNotesDTOList.add(setPredefinedNotesDTO(3,21,30,"Third"));
        predefinedNotesDTOList.add(setPredefinedNotesDTO(4,31,1000,"Fourth"));
        return  predefinedNotesDTOList;
    }


    @Test
    public void getPredifinedNotesTest() throws Exception {
        List<PredefinedNotes> predefinedNotesList = getAllPredefinedNotes();
        List<PredifinedNoteDTO> predefinedNotesDTOList = getAllPredefinedNotesDTO();

        when(predifinedNoteServices.getAllpredefinedNotes()).thenReturn(predefinedNotesList);
        when(modelMapper.map(predefinedNotesList, new TypeToken<List<PredifinedNoteDTO>>() {}.getType())).thenReturn(predefinedNotesDTOList);

        ResultActions actions = mockMvc
                .perform(get("/notes/getpredifinednotes"))
                .andExpect(status().isOk());

        Gson gson = new Gson();
        List<PredifinedNoteDTO> actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), List.class);

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.size(),predefinedNotesDTOList.size());
    }

}