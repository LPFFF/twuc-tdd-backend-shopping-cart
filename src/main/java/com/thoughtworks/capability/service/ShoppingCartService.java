package com.thoughtworks.capability.service;

import com.thoughtworks.capability.domain.Commodity;
import com.thoughtworks.capability.repository.ShoppingCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: pengfei.lv
 * @create: 2022-06-14 12:19
 **/
@Service
@AllArgsConstructor
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public List<Commodity> getShoppingCartItems() {
        return shoppingCartRepository.getShoppingCartItems();
    }
}
