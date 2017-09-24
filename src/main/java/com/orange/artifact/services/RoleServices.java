package com.orange.artifact.services;

import com.orange.artifact.model.Role;
import com.orange.artifact.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("roleServices")
@Transactional
public class RoleServices {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RoleRepository roleDAO;
    public List<Role> getAllroles(){return (List<Role>) roleDAO.findAll();}
    public Role findrole(Integer id){
        logger.info("In RoleServices : findrole Function is called");
        return roleDAO.findById(id).get();
    }
    public void delete(Role role){roleDAO.delete(role);}
    public void updaterole(Role role){roleDAO.save(role);}
    public void saverole(Role role){roleDAO.save(role);}
}
