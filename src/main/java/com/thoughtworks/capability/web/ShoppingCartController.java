package com.thoughtworks.capability.web;

import com.thoughtworks.capability.domain.Commodity;
import com.thoughtworks.capability.domain.Example;
import com.thoughtworks.capability.service.ExampleService;
import com.thoughtworks.capability.service.ShoppingCartService;
import com.thoughtworks.capability.web.dto.CreateExampleRequest;
import com.thoughtworks.capability.web.dto.ExampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(value = "/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @GetMapping("/items")
    public List<Commodity> getShoppingCartItems() {
        return shoppingCartService.getShoppingCartItems();
    }

    @PostMapping("/payment")
    public int shoppingCartItemsPayment() {
        return shoppingCartService.shoppingCartItemsPayment();
    }
}
