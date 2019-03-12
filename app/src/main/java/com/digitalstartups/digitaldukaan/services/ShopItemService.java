package com.digitalstartups.digitaldukaan.services;

import com.digitalstartups.digitaldukaan.models.ShopItem;

import java.util.List;
import java.util.Optional;

public interface ShopItemService {

    void createShopItem(ShopItem shopItem);

    Optional<ShopItem> getShopItem(String itemId, String shopId);

    List<ShopItem> getAllItemsForShop(String ShopId);

    void removeShopItem( String itemId);
}
