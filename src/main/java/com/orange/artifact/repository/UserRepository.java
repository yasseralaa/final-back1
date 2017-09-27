package com.orange.artifact.repository;

import com.orange.artifact.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
    public User findByEmailAndPassword(String email , String password);
    public User findUserById(Integer id);
}
