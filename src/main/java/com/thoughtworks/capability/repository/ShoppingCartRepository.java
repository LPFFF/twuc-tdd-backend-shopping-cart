package com.thoughtworks.capability.repository;

import com.thoughtworks.capability.domain.Commodity;
import com.thoughtworks.capability.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<Example, Long> {

    List<Commodity> getShoppingCartItems();
}
