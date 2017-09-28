package com.orange.artifact.services;

import com.orange.artifact.errorHandling.EntityNotFoundException;
import com.orange.artifact.model.User;
import com.orange.artifact.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userServices")
@Transactional
public class UserServices {

    @Autowired
    UserRepository userDao;

    public User getUser(Integer userId) throws EntityNotFoundException {
        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new EntityNotFoundException(User.class, "id", userId.toString());
        }
        return user;
    }

    public User findUser(Integer id) {
        return userDao.findById(id).get();
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User findUser(String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }
}
