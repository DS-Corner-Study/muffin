package com.springboot.jpa.data.repository.support;

import com.springboot.jpa.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    void findByNameTest() {
        List<Product> productList = productRepository.findByName("펜");

        for (Product product : productList) {
            System.out.println(product.getNumber());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getStock());
        }
    }

}
