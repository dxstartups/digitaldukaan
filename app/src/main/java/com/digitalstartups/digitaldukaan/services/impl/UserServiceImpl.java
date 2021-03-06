package com.digitalstartups.digitaldukaan.services.impl;

import com.digitalstartups.digitaldukaan.dao.UserDao;
import com.digitalstartups.digitaldukaan.dao.impl.UserDaoImpl;
import com.digitalstartups.digitaldukaan.models.User;
import com.digitalstartups.digitaldukaan.services.UserService;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        if(validateRegistrationDetails(user)){
            userDao.registerUser(user);
        }
    }

    private boolean validateRegistrationDetails(User user) {
        return EmailValidator.getInstance().isValid(user.getId().trim());
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userDao.findUserById(id);
    }


}
