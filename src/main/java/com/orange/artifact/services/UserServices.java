package com.orange.artifact.services;

import com.orange.artifact.ErrorHandling.EntityNotFoundException;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserRepository userDao;

    public User getUser(Integer userId) throws EntityNotFoundException {
        User user = userDao.findUserById(userId);
        System.out.println("here1");
        //System.out.println(user.getName());
        if(user == null){
            System.out.println("here2");
            throw new EntityNotFoundException(User.class, "id", userId.toString());
        }
        return user;
    }

    public List<User> getAllUsers(){return (List<User>) userDao.findAll();}
    public User findUser(Integer id){
        logger.info("In UserServices : findUser Function is called");
        return userDao.findById(id).get();
    }
    public void delete(User user){userDao.delete(user);}
    public void updateUser(User user){userDao.save(user);}
    public void saveUser(User user){
        logger.info("In UserServices : saveUser Function is called");
        userDao.save(user);
    }

    public User findUser(String email,String password){
        return userDao.findByEmailAndPassword(email,password);
    }
}
