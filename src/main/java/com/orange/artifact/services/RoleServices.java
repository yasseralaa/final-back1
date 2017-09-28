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
    @Autowired
    RoleRepository roleDAO;

    public Role findrole(Integer id) {
        return roleDAO.findById(id).get();
    }
}
