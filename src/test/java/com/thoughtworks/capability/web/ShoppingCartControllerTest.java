package com.thoughtworks.capability.web;

import com.thoughtworks.capability.WebApplicationTest;
import com.thoughtworks.capability.domain.Commodity;
import com.thoughtworks.capability.service.ShoppingCartService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class ShoppingCartControllerTest extends WebApplicationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    public ShoppingCartService shoppingCartService;

    @Test
    public void shouldGetShoppingCartItems() throws Exception {
        when(shoppingCartService.getShoppingCartItems()).thenReturn(Arrays.asList(
                Commodity.builder().id(1L).build(),
                Commodity.builder().id(2L).build(),
                Commodity.builder().id(3L).build()
        ));

        mvc.perform(MockMvcRequestBuilders
                        .get("/shopping-cart/items")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

    @Test
    public void testPayment() throws Exception {
        when(shoppingCartService.shoppingCartItemsPayment()).thenReturn(1
        );

        mvc.perform(MockMvcRequestBuilders
                        .post("/shopping-cart/payment")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("").value(1));
    }
}
