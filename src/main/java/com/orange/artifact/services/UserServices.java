package com.orange.artifact.services;

import com.orange.artifact.errorhandling.EntityNotFoundException;
import com.orange.artifact.model.User;
import com.orange.artifact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User findUser(String email, String password) throws EntityNotFoundException {
        User user = userDao.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new EntityNotFoundException(User.class, "id", user.getId().toString());
        }
        return user;
    }
}
