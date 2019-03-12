package com.digitalstartups.digitaldukaan.services.impl;

import com.digitalstartups.digitaldukaan.dao.ShopDAO;
import com.digitalstartups.digitaldukaan.dao.impl.ShopDAOImpl;
import com.digitalstartups.digitaldukaan.models.Shop;
import com.digitalstartups.digitaldukaan.services.ShopService;

import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements ShopService {

    private ShopDAO shopDAO = new ShopDAOImpl();

    public void createShop(Shop shop){
        if(validateShop(shop)){
            shopDAO.createShop(shop);
        }
    }

    @Override
    public Optional<Shop> getShopById(String shopId) {
        return shopDAO.getShopById(shopId);
    }

    @Override
    public List<Shop> getShopsByType(String type) {
        return shopDAO.getShopsByType(type);
    }

    private boolean validateShop(Shop shop) {
      return !shopDAO.getShopById(shop.getName()).isPresent();
    }
}
