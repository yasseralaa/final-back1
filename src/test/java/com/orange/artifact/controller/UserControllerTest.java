//package com.orange.artifact.controller;
//
//
//import com.google.gson.Gson;
//import com.orange.artifact.Controller.UserController;
//import com.orange.artifact.model.Role;
//import com.orange.artifact.model.User;
//import com.orange.artifact.services.UserServices;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class UserControllerTest {
//
//    MockMvc mockMvc;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Mock
//    UserServices userServices;
//
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(userController)
//                .build();
//    }
//
//
//    @Test
////    @WithMockUser(username = "admin@admin.com" , password = "admin")
//    public void testCase1() throws Exception {
//
//
//        Role role = new Role();
//        User user = new User();
//        String email = "admin@admin.com";
//        String password = "admin";
//        role.setId(1);
//        role.setRole("ROLE_ADMIN");
//        user.setId(1);
//        user.setEmail(email);
//        user.setPassword(password);
//        user.setName("admin");
//        user.setMobileNumber("01122334455");
//        user.setRole(role);
//        when(userServices.getUser(1)).thenReturn(user);
//
//        ResultActions actions = mockMvc
//                    .perform(get("/users/1"))
//                    .andExpect(status().isOk());
//
//        Gson gson = new Gson();
//        User actual = gson.fromJson(actions.andReturn().getResponse().getContentAsString(), User.class);
//        System.err.println(actual.getName());
//    }
//
//}
