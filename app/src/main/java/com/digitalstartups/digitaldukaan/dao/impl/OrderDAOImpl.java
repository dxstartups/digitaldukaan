package com.digitalstartups.digitaldukaan.dao.impl;

import android.util.Log;

import com.digitalstartups.digitaldukaan.dao.OrderDAO;
import com.digitalstartups.digitaldukaan.models.Order;
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

public class OrderDAOImpl implements OrderDAO {


    private Gson gson = new Gson();
    private RemoteMongoCollection orderCollection;

    public OrderDAOImpl(){
        RemoteMongoCollection<Order> collection = MongoUtil.getRemoteMongoCollection
                (DigitalDukaanConstants.DB_NAME, DigitalDukaanConstants.ORDER_COLLECTION, Order.class);
        this.setOrderCollection(collection);
    }

    @Override
    public void createOrder(Order order) {
        Document orderDocument = Document.parse(gson.toJson(order));
        getOrderCollection().insertOne(orderDocument).addOnSuccessListener(remoteInsertOneResult ->
                Log.d(this.getClass().getName(), "New Order created: " + order.getId()));
    }

    @Override
    public Optional<Order> getOrderById(String orderId) {
        List<Order> orders = new ArrayList<>();
        Bson filter = Filters.eq(Order.FIELD_ORDER_NUMBER , new ObjectId(orderId));
        getOrderCollection().find(filter, Order.class).into(orders);
        return orders.isEmpty() ? Optional.empty() : Optional.of(orders.iterator().next());
    }

    @Override
    public List<Order> getOrdersForUser(String userId) {
        List<Order> orders = new ArrayList<>();
        Bson filter = Filters.eq(Order.FIELD_CUSTOMER, userId);
        getOrderCollection().find(filter).into(orders);
        return orders;
    }

    @Override
    public List<Order> getOrdersForShop(String shopId) {
        List<Order> orders = new ArrayList<>();
        Bson filter = Filters.eq(Order.FIELD_SHOPID, shopId);
        getOrderCollection().find(filter).into(orders);
        return orders;
    }

    public RemoteMongoCollection getOrderCollection() {
        return orderCollection;
    }

    public void setOrderCollection(RemoteMongoCollection orderCollection) {
        this.orderCollection = orderCollection;
    }
}
