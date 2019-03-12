package com.digitalstartups.digitaldukaan.models;

import com.google.gson.annotations.SerializedName;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;

public class Order {

    public static final String FIELD_ORDER_NUMBER = "_id";
    public static final String FIELD_SHOPITEMS = "shop_items";
    public static final String FIELD_CUSTOMER = "customer";
    public static final String FIELD_SHOPID = "shop_id";
    public static final String FIELD_TOTAL_PRICE = "total_price";
    public static final String FIELD_ORDER_STATUS = "orderstatus";
    public static final String FIELD_PAYMENT_STATUS = "paymentstatus";
    public static final String FIELD_CHARITY_VALUE = "charity_value";


    @BsonId
    @SerializedName(FIELD_ORDER_NUMBER)
    private String id;

    @BsonProperty(FIELD_SHOPITEMS)
    @SerializedName(FIELD_SHOPITEMS)
    private List<ShopItem> shopItems;

    @BsonProperty(FIELD_CUSTOMER)
    @SerializedName(FIELD_CUSTOMER)
    private String customerId;

    @BsonProperty(FIELD_SHOPID)
    @SerializedName(FIELD_SHOPID)
    private String shopId;

    @BsonProperty(FIELD_TOTAL_PRICE)
    @SerializedName(FIELD_TOTAL_PRICE)
    private double totalPrice;

    @BsonProperty(FIELD_ORDER_STATUS)
    @SerializedName(FIELD_ORDER_STATUS)
    private OrderStatus orderStatus;

    @BsonProperty(FIELD_PAYMENT_STATUS)
    @SerializedName(FIELD_PAYMENT_STATUS)
    private String paymentStatus;

    @BsonProperty(FIELD_CHARITY_VALUE)
    @SerializedName(FIELD_CHARITY_VALUE)
    private double charityValue;



    public List<ShopItem> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<ShopItem> shopItems) {
        this.shopItems = shopItems;
    }

    public String getCustomer() {
        return customerId;
    }

    public void setCustomer(String customerId) {
        this.customerId = customerId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getCharityValue() {
        return charityValue;
    }

    public void setCharityValue(double charityValue) {
        this.charityValue = charityValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
