package com.digitalstartups.digitaldukaan.dao;

import com.digitalstartups.digitaldukaan.models.Order;
import com.digitalstartups.digitaldukaan.models.OrderStatus;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    /**
     * Create a new Order
     * @param order
     */
    void createOrder(Order order);


    /**
     * Get Order by order id
     * @param id
     * @return
     */
    Optional<Order> getOrderById(String id);

    /**
     * Get all orders for the user
     * @param userId
     * @return
     */
    List<Order> getOrdersForUser(String userId);

    /**
     * Get all orders for the Shop
     * @param shopId
     * @return
     */
    List<Order> getOrdersForShop(String shopId);

}
