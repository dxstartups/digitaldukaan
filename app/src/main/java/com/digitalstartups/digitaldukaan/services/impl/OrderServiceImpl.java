package com.digitalstartups.digitaldukaan.services.impl;

import com.digitalstartups.digitaldukaan.dao.OrderDAO;
import com.digitalstartups.digitaldukaan.dao.impl.OrderDAOImpl;
import com.digitalstartups.digitaldukaan.models.Order;
import com.digitalstartups.digitaldukaan.services.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO = new OrderDAOImpl();

    @Override
    public void createOrder(Order order) {
        orderDAO.createOrder(order);
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public List<Order> getOrdersForUser(String userId) {
        return orderDAO.getOrdersForUser(userId);
    }

    @Override
    public List<Order> getOrdersForShop(String shopId) {
        return orderDAO.getOrdersForShop(shopId);
    }
}
