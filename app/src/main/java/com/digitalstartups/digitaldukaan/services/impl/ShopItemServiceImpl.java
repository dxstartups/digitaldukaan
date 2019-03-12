package com.digitalstartups.digitaldukaan.services.impl;

import com.digitalstartups.digitaldukaan.dao.ShopItemDAO;
import com.digitalstartups.digitaldukaan.dao.impl.ShopItemDAOImpl;
import com.digitalstartups.digitaldukaan.models.ShopItem;
import com.digitalstartups.digitaldukaan.services.ShopItemService;

import java.util.List;
import java.util.Optional;

public class ShopItemServiceImpl implements ShopItemService {

    ShopItemDAO shopItemDAO = new ShopItemDAOImpl();

    @Override
    public void createShopItem(ShopItem shopItem) {
        shopItemDAO.createShopItem(shopItem);
    }

    @Override
    public Optional<ShopItem> getShopItem(String itemId, String shopId) {
        return shopItemDAO.getShopItem(itemId, shopId);
    }

    @Override
    public List<ShopItem> getAllItemsForShop(String shopId) {
        return shopItemDAO.getAllItemsForShop(shopId);
    }

    @Override
    public void removeShopItem(String itemId) {
        shopItemDAO.removeShopItem(itemId);
    }
}
