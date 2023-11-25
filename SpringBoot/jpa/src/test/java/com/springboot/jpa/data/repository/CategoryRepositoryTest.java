package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Category;
import com.springboot.jpa.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void relationshipTest() {
        // 테스트 데이터 생성
        Product product = new Product();
        product.setName("펜");
        product.setPrice(2000);
        product.setStock(100);

        productRepository.save(product);

        Category category = new Category();
        category.setCode("S1");
        category.setName("도서");
        // Product 객체를 Category에서 생선한 리스트 객체에 추가해 연관관계 설정
        category.getProducts().add(product);

        categoryRepository.save(category);

        // 테스트 코드
        List<Product> products = categoryRepository.findById(1L).get().getProducts();

        for (Product foundProduct : products) {
            System.out.println(foundProduct);
        }
    }

}
