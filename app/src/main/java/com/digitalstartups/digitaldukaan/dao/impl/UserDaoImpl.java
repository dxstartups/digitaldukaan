package com.digitalstartups.digitaldukaan.dao.impl;

import android.util.Log;

import com.digitalstartups.digitaldukaan.dao.UserDao;
import com.digitalstartups.digitaldukaan.models.User;
import com.digitalstartups.digitaldukaan.util.DigitalDukaanConstants;
import com.digitalstartups.digitaldukaan.util.MongoUtil;
import com.google.gson.Gson;
import com.mongodb.client.model.Filters;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {


    private Gson gson = new Gson();
    private RemoteMongoCollection userCollection;

    public UserDaoImpl(){
        RemoteMongoCollection<User> collection = MongoUtil.getRemoteMongoCollection
                (DigitalDukaanConstants.DB_NAME, DigitalDukaanConstants.USER_COLLECTION, User.class);
        this.setUserCollection(collection);
    }

    @Override
    public void registerUser(User user) {
        Document userDocument = Document.parse(gson.toJson(user));
        getUserCollection().insertOne(userDocument).addOnSuccessListener(remoteInsertOneResult ->
                Log.d(this.getClass().getName(), "New User created: " + user.getId()));
    }

    @Override
    public Optional<User> findUserById(String id) {
        List<User> user = new ArrayList<>();
        Bson filter = Filters.eq(User.FIELD_EMAIL , new ObjectId(id));
        getUserCollection().find(filter).into(user);
        return user.isEmpty() ? Optional.empty() : Optional.of(user.iterator().next());
    }


    public RemoteMongoCollection getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(RemoteMongoCollection userCollection) {
        this.userCollection = userCollection;
    }
}
