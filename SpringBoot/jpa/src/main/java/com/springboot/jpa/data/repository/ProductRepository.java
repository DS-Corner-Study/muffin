package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // find...By
    Optional<Product> findByNumber(Long number);
    List<Product> findAllByName(String name);
    Product queryByNumber(Long number);

    // exists...By
    boolean existsByNumber(Long number);

    // count...By
    long countByName(String name);

    // delete...By, remove...By
    void deleteByNumber(Long number);
    long removeByName(String name);

    // ...First<number>..., ...Top<number>...
    List<Product> findFirst5ByName(String name);
    List<Product> findTop100ByName(String name);

    // findByNumber 메서드와 동일하게 동작
    Product findByNumberIs(Long number);
    Product findByNumberEquals(Long number);

    Product findByNumberIsNot(Long number);
    Product findByNumberNot(Long number);

    List<Product> findByUpdatedAtNull();
    List<Product> findByUpdatedAtIsNull();
    List<Product> findByUpdatedAtNotNull();
    List<Product> findByUpdatedAtIsNotNull();

    Product findByisActiveTrue();
    Product findByisActiveIsTrue();
    Product findByisActiveFalse();
    Product findByisActiveIsFalse();

    Product findByNumberAndName(Long number, String name);
    Product findByNumberOrName(Long number, String name);

    List<Product> findByPriceIsGreaterThan(Long price);
    List<Product> findByPriceGreaterThan(Long price);
    List<Product> findByPriceGreaterThanEqual(Long price);
    List<Product> findByPriceIsLessThan(Long price);
    List<Product> findByPriceLessThan(Long price);
    List<Product> findByPriceLessThanEqual(Long price);
    List<Product> findByPriceIsBetween(Long lowPrice, Long highPrice);
    List<Product> findByPriceBetween(Long lowPrice, Long highPrice);

    List<Product> findByNameLike(String name);
    List<Product> findByNameIsLike(String name);

    List<Product> findByNameContains(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameIsContaining(String name);

    List<Product> findByNameStartsWith(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameIsStartingWith(String name);

    List<Product> findByNameEndsWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameIsEndingWith(String name);

    List<Product> findByNameOrderByNumberAsc(String name); // Asc : 오름차순 // 상품정보를 이름으로 검색한 후 상품 번호로 오름차순 정렬
    List<Product> findByNameOrderByNumberDesc(String name); // Desc : 내림차순

    // And X
    List<Product> findByNameOrderByPriceAscStockDesc(String name); // 먼저 Price를 기준으로 오름차순 정렬 후 후순위로 재고수량을 기준으로 내림차순 정렬 수행

    // 매개변수를 활용한 쿼리 정렬
    List<Product> findByName(String name, Sort sort);

    // 페이징 처리를 위한 쿼리 메서드
    Page<Product> findByName(String name, Pageable pageable);
}
