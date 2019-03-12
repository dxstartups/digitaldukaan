package com.digitalstartups.digitaldukaan.services.impl;

import android.util.Log;

import com.digitalstartups.digitaldukaan.dao.UserDao;
import com.digitalstartups.digitaldukaan.dao.impl.UserDaoImpl;
import com.digitalstartups.digitaldukaan.models.User;
import com.digitalstartups.digitaldukaan.services.UserService;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.auth.providers.userpassword.UserPasswordAuthProviderClient;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        UserPasswordAuthProviderClient emailPassClient = Stitch.getDefaultAppClient().getAuth().getProviderClient(
                UserPasswordAuthProviderClient.factory);

        emailPassClient.registerWithEmail(user.getId(),user.getPassword())
                .addOnCompleteListener(task -> {
                   if(task.isSuccessful()){
                       Log.d(this.getClass().getName(), "Successfully sent account confirmation email");
                   } else {
                       Log.e(this.getClass().getName(), "Error registering new user:", task.getException());
                   }
                });
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userDao.findUserById(id);
    }


}
