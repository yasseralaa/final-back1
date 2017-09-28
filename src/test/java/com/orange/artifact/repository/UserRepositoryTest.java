package com.orange.artifact.repository;

import com.orange.artifact.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userDao;

    @Test
    public void getAdminByEmailAndPassword(){
        User user = userDao.findByEmailAndPassword("admin@admin.com","admin");
        Assert.assertNotNull(user);
        Assert.assertEquals(1,(long)user.getId());
        Assert.assertEquals("admin",user.getName());
        Assert.assertEquals("01122334455",user.getMobileNumber());
        Assert.assertEquals("ROLE_ADMIN",user.getRole().getRole());
    }


    @Test
    public void getAdminByID(){
        User user = userDao.findUserById(1);
        Assert.assertNotNull(user);
        Assert.assertEquals("admin@admin.com",user.getEmail());
        Assert.assertEquals("admin",user.getPassword());
        Assert.assertEquals("admin",user.getName());
        Assert.assertEquals("01122334455",user.getMobileNumber());
        Assert.assertEquals("ROLE_ADMIN",user.getRole().getRole());
    }


    @Test
    public void getUserByEmailAndPassword(){
        User user = userDao.findByEmailAndPassword("user@user.com","user");
        Assert.assertNotNull(user);
        Assert.assertEquals(2,(long)user.getId());
        Assert.assertEquals("user",user.getName());
        Assert.assertEquals("01425366543",user.getMobileNumber());
        Assert.assertEquals("ROLE_USER",user.getRole().getRole());
    }


    @Test
    public void getUserByID(){
        User user = userDao.findUserById(2);
        Assert.assertNotNull(user);
        Assert.assertEquals("user@user.com",user.getEmail());
        Assert.assertEquals("user",user.getPassword());
        Assert.assertEquals("user",user.getName());
        Assert.assertEquals("01425366543",user.getMobileNumber());
        Assert.assertEquals("ROLE_USER",user.getRole().getRole());
    }
}
