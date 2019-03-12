package com.digitalstartups.digitaldukaan.dao.impl;

import android.util.Log;

import com.digitalstartups.digitaldukaan.dao.ShopDAO;
import com.digitalstartups.digitaldukaan.models.Shop;
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

public class ShopDAOImpl implements ShopDAO {

    private Gson gson = new Gson();
    private RemoteMongoCollection shopCollection;

    public ShopDAOImpl(){
        RemoteMongoCollection<Shop> collection = MongoUtil.getRemoteMongoCollection
                (DigitalDukaanConstants.DB_NAME, DigitalDukaanConstants.SHOP_COLLECTION, Shop.class);
        this.setShopCollection(collection);
    }

    @Override
    public void createShop(Shop shop) {
        Document shopDocument = Document.parse(gson.toJson(shop));
        getShopCollection().insertOne(shopDocument).addOnSuccessListener(remoteInsertOneResult -> {
            Log.d(this.getClass().getName(), "New shop created: " + shop.getName());
        });
    }

    @Override
    public Optional<Shop> getShopById(String id) {
        List<Shop> shops = new ArrayList<>();
        Bson filter = Filters.eq(Shop.FIELD_SHOPID , new ObjectId(id));
        getShopCollection().find(filter, Shop.class).into(shops);
        return shops.isEmpty() ? Optional.empty() : Optional.of(shops.iterator().next());
    }

    @Override
    public List<Shop> getShopsByType(String type) {
        List<Shop> shops = new ArrayList<>();
        Bson filter = Filters.eq(Shop.FIELD_TYPE, type);
        getShopCollection().find(filter, Shop.class).into(shops);
        return shops;
    }


    private RemoteMongoCollection<Document> getShopCollection() {
        return shopCollection;
    }

    private void setShopCollection(RemoteMongoCollection shopCollection) {
        this.shopCollection = shopCollection;
    }


}
