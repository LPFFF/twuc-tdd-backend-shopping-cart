package com.thoughtworks.capability.service;

import com.thoughtworks.capability.domain.Commodity;
import com.thoughtworks.capability.domain.Example;
import com.thoughtworks.capability.repository.ShoppingCartRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShoppingCartServiceTest {
    private final ShoppingCartRepository shoppingCartRepository = mock(ShoppingCartRepository.class);
    private final ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCartRepository);

    @Test
    public void shouldReturnExampleWhenGivenExampleIdIsValid() {
        Long exampleId = 1L;
        Example example = Example.builder().id(exampleId).build();
        when(shoppingCartRepository.getShoppingCartItems()).thenReturn(Arrays.asList(
                Commodity.builder().id(1L).build(),
                Commodity.builder().id(2L).build(),
                Commodity.builder().id(3L).build()
        ));

        //when
        List<Commodity> shoppingCartItems = shoppingCartService.getShoppingCartItems();

        //then
        assertNotNull(shoppingCartItems);
        assertEquals(3, shoppingCartItems.size());
        assertEquals(1, shoppingCartItems.get(0).getId());
        assertEquals(2, shoppingCartItems.get(1).getId());
        assertEquals(3, shoppingCartItems.get(2).getId());
    }


}
