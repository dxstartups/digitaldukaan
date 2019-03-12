package com.digitalstartups.digitaldukaan.services;

import com.digitalstartups.digitaldukaan.models.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {

    /**
     * Create a new Shop
     * @param shop
     */
    void createShop(Shop shop);

    Optional<Shop> getShopById(String shopId);

    List<Shop> getShopsByType(String type);




}
