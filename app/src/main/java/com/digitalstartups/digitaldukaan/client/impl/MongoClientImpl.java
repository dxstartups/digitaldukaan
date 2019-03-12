package com.digitalstartups.digitaldukaan.client.impl;

import com.digitalstartups.digitaldukaan.client.MongoClient;
import com.digitalstartups.digitaldukaan.util.DigitalDukaanConstants;
import com.mongodb.stitch.android.core.Stitch;
import com.mongodb.stitch.android.core.StitchAppClient;
import com.mongodb.stitch.android.services.mongodb.remote.RemoteMongoClient;
import com.mongodb.stitch.core.auth.providers.anonymous.AnonymousCredential;

public class MongoClientImpl implements MongoClient {

    private static  boolean initialized;

    @Override
    public RemoteMongoClient createConnection(){

        if(!isInitialized()) {
            Stitch.initializeDefaultAppClient(DigitalDukaanConstants.APP_ID);
        }

        final StitchAppClient client = Stitch.getDefaultAppClient();
        client.getAuth().loginWithCredential(new AnonymousCredential());
        final RemoteMongoClient mongoClient = client.getServiceClient(RemoteMongoClient.factory, DigitalDukaanConstants.SERVICE_NAME);
        setInitialized(Boolean.TRUE);
        return mongoClient;
    }

    private static boolean isInitialized() {
        return initialized;
    }

    private static void setInitialized(boolean initialized) {
        MongoClientImpl.initialized = initialized;
    }

}
