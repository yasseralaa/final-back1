package com.orange.artifact.services;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WeatherNoteDTOServicesTest {

    @Mock
    UserServices userServices;

    @Mock
    PredefinedNoteServices predefinedNoteServices;



}
