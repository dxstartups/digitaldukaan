package com.digitalstartups.digitaldukaan.dao;

import com.digitalstartups.digitaldukaan.models.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopDAO {

    /**
     * Create a Shop document in MongoDB
     * @param shop
     */
    void createShop(Shop shop);

    /**
     *
     * @param id
     * @return
     */
    Optional<Shop> getShopById(String id);

    /**
     *
     * @param type
     * @return
     */
    List<Shop> getShopsByType(String type);

}
