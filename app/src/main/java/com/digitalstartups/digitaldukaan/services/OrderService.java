package com.digitalstartups.digitaldukaan.services;

import com.digitalstartups.digitaldukaan.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    /**
     *
     * @param order
     */
    void createOrder(Order order);


    /**
     *
     * @param id
     * @return
     */
    Optional<Order> getOrderById(String id);

    /**
     *
     * @param userId
     * @return
     */
    List<Order> getOrdersForUser(String userId);

    /**
     *
     * @param shopId
     * @return
     */
    List<Order> getOrdersForShop(String shopId);

}
