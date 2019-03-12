package com.digitalstartups.digitaldukaan.dao;

import com.digitalstartups.digitaldukaan.models.ShopItem;

import java.util.List;
import java.util.Optional;

public interface ShopItemDAO {

    /**
     *
     * @param shopItem
     */
    void createShopItem(ShopItem shopItem);

    /**
     *
     * @param itemId
     * @param shopId
     * @return
     */
    Optional<ShopItem> getShopItem(String itemId, String shopId);

    /**
     *
     * @param ShopId
     * @return
     */
    List<ShopItem> getAllItemsForShop(String ShopId);


    /**
     *
     * @param itemId
     */
    void removeShopItem( String itemId);


}
