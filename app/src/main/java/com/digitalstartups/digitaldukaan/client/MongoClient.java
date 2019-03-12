package com.digitalstartups.digitaldukaan.client;

import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;

public interface MongoClient {

    /**
     * Establish connection to Mongo Atlas
     * @return RemoteMongoClient
     */
    RemoteMongoClient createConnection();

}
