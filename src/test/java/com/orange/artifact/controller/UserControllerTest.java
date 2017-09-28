package com.orange.artifact.controller;

import com.google.gson.Gson;
import com.orange.artifact.dto.LoginDTO;
import com.orange.artifact.dto.UserDTO;
import com.orange.artifact.model.Role;
import com.orange.artifact.model.User;
import com.orange.artifact.services.UserDTOServices;
import com.orange.artifact.services.UserServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    UserServices userServices;

    @Mock
    UserDTOServices userDTOServices;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }




    @Test
    public void getAdminTest() throws Exception {
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
        when(userServices.getUser(1)).thenReturn(user);

        ResultActions actions = mockMvc
                .perform(get("/users/1"))
                .andExpect(status().isOk());

        Gson gson = new Gson();
        User actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), User.class);

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.getId(), user.getId());
        Assert.assertEquals(actual.getEmail(), user.getEmail());
        Assert.assertEquals(actual.getPassword(), user.getPassword());
        Assert.assertEquals(actual.getName(), user.getName());
        Assert.assertEquals(actual.getMobileNumber(), user.getMobileNumber());

        Assert.assertEquals(actual.getRole().getRole(), user.getRole().getRole());
        Assert.assertEquals(actual.getRole().getId(), user.getRole().getId());
    }

    @Test
    public void addUserTest() throws Exception {
        UserDTO userDTO = new UserDTO();
        User user = new User();
        Role role = new Role();

        role.setId(2);
        role.setRole("ROLE_USER");

        userDTO.setName("newuser");
        user.setName("newuser");
        userDTO.setEmail("newuser@newuser.com");
        user.setEmail("newuser@newuser.com");
        userDTO.setPassword("newuser");
        user.setPassword("newuser");
        userDTO.setMobileNumber("01166334455");
        user.setMobileNumber("01166334455");
        userDTO.setRoleId(2);
        user.setRole(role);

        when(userDTOServices.ConvertUserDTOtoUser(userDTO)).thenReturn(user);

        ResultActions actions = mockMvc
                .perform(
                        post("/users/saveuser")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new Gson().toJson(userDTO))
                )
                .andExpect(status().isOk());
    }


    @Test
    public void loginUserTest() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        User user = new User();
        Role role = new Role();
        String email = "user@user.com";
        String password = "user";

        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        role.setId(2);
        role.setRole("ROLE_USER");

        user.setName("user");
        user.setEmail(email);
        user.setPassword(password);
        user.setMobileNumber("01425366543");
        user.setRole(role);

        when(userServices.findUser(email,password)).thenReturn(user);

        ResultActions actions = mockMvc
                .perform(
                        post("/users/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new Gson().toJson(loginDTO))
                )
                .andExpect(status().isOk());

        Gson gson = new Gson();
        User actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), User.class);

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.getId(), user.getId());
        Assert.assertEquals(actual.getEmail(), user.getEmail());
        Assert.assertEquals(actual.getPassword(), user.getPassword());
        Assert.assertEquals(actual.getName(), user.getName());
        Assert.assertEquals(actual.getMobileNumber(), user.getMobileNumber());

        Assert.assertEquals(actual.getRole().getRole(), user.getRole().getRole());
        Assert.assertEquals(actual.getRole().getId(), user.getRole().getId());
    }


    @Test
    public void loginAdminTest() throws Exception {
        LoginDTO loginDTO = new LoginDTO();
        User user = new User();
        Role role = new Role();
        String email = "admin@admin.com";
        String password = "admin";

        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        role.setId(1);
        role.setRole("ROLE_ADMIN");

        user.setName("admin");
        user.setEmail(email);
        user.setPassword(password);
        user.setMobileNumber("01122334455");
        user.setRole(role);

        when(userServices.findUser(email,password)).thenReturn(user);

        ResultActions actions = mockMvc
                .perform(
                        post("/users/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new Gson().toJson(loginDTO))
                )
                .andExpect(status().isOk());

        Gson gson = new Gson();
        User actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), User.class);

        Assert.assertNotNull(actual);
        Assert.assertEquals(actual.getId(), user.getId());
        Assert.assertEquals(actual.getEmail(), user.getEmail());
        Assert.assertEquals(actual.getPassword(), user.getPassword());
        Assert.assertEquals(actual.getName(), user.getName());
        Assert.assertEquals(actual.getMobileNumber(), user.getMobileNumber());

        Assert.assertEquals(actual.getRole().getRole(), user.getRole().getRole());
        Assert.assertEquals(actual.getRole().getId(), user.getRole().getId());
    }


    @Test
    public void unvalidLoginTest() throws Exception{
        LoginDTO loginDTO = new LoginDTO();
        String email = "admin@admin.com";
        String password = "wrongpass";

        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        when(userServices.findUser(email,password)).thenReturn(null);

        ResultActions actions = mockMvc
                .perform(
                        post("/users/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(new Gson().toJson(loginDTO))
                )
                .andExpect(status().isOk());

        Gson gson = new Gson();
        User actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), User.class);
        Assert.assertNull(actual);
    }


}