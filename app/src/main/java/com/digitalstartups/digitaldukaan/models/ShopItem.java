package com.digitalstartups.digitaldukaan.models;

import com.google.gson.annotations.SerializedName;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class ShopItem {

    public static final String FIELD_ID = "_id";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_ITEM_NAME = "item_name";
    public static final String FIELD_QUANTITY = "quantity";
    public static final String FIELD_PRICE = "price";
    public static final String FIELD_UOM = "uom";
    public static final String FIELD_BUTCHER = "butcher_name";
    public static final String FIELD_SHOP_ID = "shop_id";


    @BsonId
    @SerializedName(FIELD_ID)
    private String id;

    @BsonProperty(FIELD_TYPE)
    @SerializedName(FIELD_TYPE)
    private String type;

    @BsonProperty(FIELD_ITEM_NAME)
    @SerializedName(FIELD_ITEM_NAME)
    private String itemName;

    @BsonProperty(FIELD_QUANTITY)
    @SerializedName(FIELD_QUANTITY)
    private int quantity;

    @BsonProperty(FIELD_PRICE)
    @SerializedName(FIELD_PRICE)
    private double price;

    @BsonProperty(FIELD_UOM)
    @SerializedName(FIELD_UOM)
    private String uom;

    @BsonProperty(FIELD_BUTCHER)
    @SerializedName(FIELD_BUTCHER)
    private String butcherName;

    @BsonProperty(FIELD_SHOP_ID)
    @SerializedName(FIELD_SHOP_ID)
    private String shopId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return itemName;
    }

    public void setItem(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getButherName() {
        return butcherName;
    }

    public void setButherName(String butherName) {
        this.butcherName = butherName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }
}
