package com.digitalstartups.digitaldukaan.util;

import com.digitalstartups.digitaldukaan.client.MongoClient;
import com.digitalstartups.digitaldukaan.client.impl.MongoClientImpl;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoCollection;

public class MongoUtil {

    private static MongoClient mongoClient = new MongoClientImpl();

    /**
     * Generic method to create e remote mongo client for a model class.
     * @param dbName
     * @param collectionName
     * @param className
     * @param <T>
     * @return
     */
    public static <T> RemoteMongoCollection<T> getRemoteMongoCollection(String dbName, String collectionName, Class<T> className){
        RemoteMongoClient remoteMongoClient = mongoClient.createConnection();
        return remoteMongoClient.getDatabase(dbName).getCollection(collectionName,className);
    }

}
