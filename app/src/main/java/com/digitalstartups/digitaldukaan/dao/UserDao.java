package com.digitalstartups.digitaldukaan.dao;

import com.digitalstartups.digitaldukaan.models.User;

import java.util.Optional;

public interface UserDao {


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
