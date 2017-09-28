package com.orange.artifact.services;

import com.orange.artifact.repository.RoleRepository;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RoleServicesTest {

    @Mock
    RoleRepository roleDAO;
}
