package com.orange.artifact.services;

import com.orange.artifact.errorhandling.EntityNotFoundException;
import com.orange.artifact.model.Role;
import com.orange.artifact.model.User;
import com.orange.artifact.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServicesTest {
    @Mock
    UserRepository userDao;

    @InjectMocks
    UserServices userServices = new UserServices();

    @Test
    public void findAdminTest() throws EntityNotFoundException {
        Role role = new Role();
        User user = new User();

        String email = "admin@admin.com";
        String password = "admin";

        role.setId(1);
        role.setRole("ROLE_ADMIN");

        user.setId(1);
        user.setEmail(email);
        user.setPassword(password);
        user.setName("admin");
        user.setMobileNumber("01122334455");
        user.setRole(role);

        // Mockito expectations
        when(userDao.findByEmailAndPassword(email,password)).thenReturn(user);

        // Execute the method being tested
        User actual = userServices.findUser(email,password);

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,user);
    }


    @Test
    public void findUserTest() throws EntityNotFoundException  {
        Role role = new Role();
        User user = new User();

        String email = "user@user.com";
        String password = "user";

        role.setId(2);
        role.setRole("ROLE_USER");

        user.setId(2);
        user.setEmail(email);
        user.setPassword(password);
        user.setName("user");
        user.setMobileNumber("01425366543");
        user.setRole(role);

        // Mockito expectations
        when(userDao.findByEmailAndPassword(email,password)).thenReturn(user);

        // Execute the method being tested
        User actual = userServices.findUser(email,password);

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual,user);
    }


}
