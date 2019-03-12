package com.digitalstartups.digitaldukaan.services;

import com.digitalstartups.digitaldukaan.models.User;

import java.util.Optional;

public interface UserService {
    /**
     *
     * @param user
     */
    void registerUser(User user);


    /**
     *
     * @param id
     * @return
     */
    Optional<User> findUserById(String id);
}
