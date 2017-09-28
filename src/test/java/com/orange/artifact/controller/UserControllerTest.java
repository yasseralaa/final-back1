package com.orange.artifact.controller;

import com.google.gson.Gson;
import com.orange.artifact.dro.LoginDRO;
import com.orange.artifact.dto.LoginDTO;
import com.orange.artifact.dto.UserDTO;
import com.orange.artifact.model.Role;
import com.orange.artifact.model.User;
import com.orange.artifact.services.UserServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
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
    ModelMapper modelMapper;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .build();
    }

    Role getRole(Integer id , String roleString){
        Role role = new Role();
        role.setId(id);
        role.setRole(roleString);
        return role;
    }

    User getUser(Integer id , String email , String password , String name , String mobileNumber , Role role){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setMobileNumber(mobileNumber);
        user.setRole(role);
        return user;
    }

    UserDTO getUserDTO(String email, String password,String name ,  String mobileNumber , Role role){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setName(name);
        userDTO.setMobileNumber(mobileNumber);
        userDTO.setRole(role);
        return userDTO;
    }

    LoginDRO getLoginDRO(String email , String password){
        LoginDRO loginDRO = new LoginDRO();
        loginDRO.setEmail(email);
        loginDRO.setPassword(password);
        return  loginDRO;
    }

    @Test
    public void getAdminTest() throws Exception {

        String email = "admin@admin.com";
        String password = "admin";
        Role role = getRole(1,"ROLE_ADMIN");
        User user = getUser(1,email,password,"admin","01122334455",role);
        UserDTO userDTO = getUserDTO(email,password,"admin","01122334455",role);

        when(userServices.getUser(1)).thenReturn(user);
        when(modelMapper.map(user, UserDTO.class)).thenReturn(userDTO);

        ResultActions actions = mockMvc
                .perform(get("/users/1"))
                .andExpect(status().isOk());

        Gson gson = new Gson();
        UserDTO actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), UserDTO.class);

        Assert.assertNotNull(actual);
        Assert.assertEquals(userDTO.getRole().getId(),actual.getRole().getId());
        Assert.assertEquals(userDTO.getRole().getRole(),actual.getRole().getRole());
        Assert.assertEquals(userDTO.getEmail(),actual.getEmail());
        Assert.assertEquals(userDTO.getPassword(),actual.getPassword());
        Assert.assertEquals(userDTO.getMobileNumber(),actual.getMobileNumber());
        Assert.assertEquals(userDTO.getName(),actual.getName());

    }

    @Test
    public void getUserTest() throws Exception {

        String email = "user@user.com";
        String password = "user";
        Role role = getRole(2,"ROLE_USER");
        User user = getUser(2,email,password,"user","01425366543",role);
        UserDTO userDTO = getUserDTO(email,password,"user","01425366543",role);

        when(userServices.getUser(2)).thenReturn(user);
        when(modelMapper.map(user, UserDTO.class)).thenReturn(userDTO);

        ResultActions actions = mockMvc
                .perform(get("/users/2"))
                .andExpect(status().isOk());

        Gson gson = new Gson();
        UserDTO actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), UserDTO.class);

        Assert.assertNotNull(actual);
        Assert.assertEquals(userDTO.getRole().getId(),actual.getRole().getId());
        Assert.assertEquals(userDTO.getRole().getRole(),actual.getRole().getRole());
        Assert.assertEquals(userDTO.getEmail(),actual.getEmail());
        Assert.assertEquals(userDTO.getPassword(),actual.getPassword());
        Assert.assertEquals(userDTO.getMobileNumber(),actual.getMobileNumber());
        Assert.assertEquals(userDTO.getName(),actual.getName());

    }

}