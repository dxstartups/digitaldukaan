package com.digitalstartups.digitaldukaan.dao.impl;

import android.util.Log;

import com.digitalstartups.digitaldukaan.dao.ShopItemDAO;
import com.digitalstartups.digitaldukaan.models.ShopItem;
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

public class ShopItemDAOImpl implements ShopItemDAO {

    private Gson gson = new Gson();
    private RemoteMongoCollection shopItemCollection;

    public ShopItemDAOImpl(){
        RemoteMongoCollection<ShopItem> remoteCollection = MongoUtil.getRemoteMongoCollection
                (DigitalDukaanConstants.DB_NAME, DigitalDukaanConstants.SHOP_ITEMS_COLLECTION, ShopItem.class);
        setShopItemCollection(remoteCollection);
    }

    @Override
    public void createShopItem(ShopItem shopItem) {
        Document shopItemDocument = Document.parse(gson.toJson(shopItem));
        getShopItemCollection().insertOne(shopItemDocument).addOnSuccessListener(remoteInsertOneResult -> {
            Log.d(this.getClass().getName(), "New Item created: " + shopItem.getId() + " for Shop: " + shopItem.getShopId());
        });
    }

    @Override
    public Optional<ShopItem> getShopItem(String itemId, String shopId) {
        List<ShopItem> shopItems = new ArrayList<>();
        Bson filterById = Filters.eq(ShopItem.FIELD_ID , new ObjectId(itemId));
        Bson filterByShop = Filters.eq(ShopItem.FIELD_SHOP_ID, shopId);
        getShopItemCollection().find(filterById, ShopItem.class).filter(filterByShop).into(shopItems);
        return shopItems.isEmpty() ? Optional.empty() : Optional.of(shopItems.iterator().next());
    }

    @Override
    public List<ShopItem> getAllItemsForShop(String shopId) {
        List<ShopItem> shopItems = new ArrayList<>();
        Bson filter = Filters.eq(ShopItem.FIELD_SHOP_ID, shopId);
        getShopItemCollection().find(filter, ShopItem.class).into(shopItems);
        return shopItems;
    }

    @Override
    public void removeShopItem(String itemId) {
        Bson filterById = Filters.eq(ShopItem.FIELD_ID , new ObjectId(itemId));
        getShopItemCollection().deleteOne(filterById).addOnSuccessListener(remoteDeleteResult -> {
            Log.d(this.getClass().getName(), "Shop Item deleted: " + itemId);
        });
    }


    public RemoteMongoCollection<Document> getShopItemCollection() {
        return shopItemCollection;
    }

    public void setShopItemCollection(RemoteMongoCollection shopItemCollection) {
        this.shopItemCollection = shopItemCollection;
    }
}
