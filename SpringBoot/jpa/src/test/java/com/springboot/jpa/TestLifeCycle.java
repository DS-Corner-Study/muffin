package com.springboot.jpa;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll // 전체 테스트 동작 처음
    static void beforeAll() {
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();
    }

    @AfterAll // 전체 테스트 동작 마지막
    static void afterAll() {
        System.out.println("## AfterAll Annotation 호출 ##");
        System.out.println();
    }

    @BeforeEach // 각 테스트 메서드 실행 전
    void beforeEach() {
        System.out.println("## BeforeEach Annotation 호출 ##");
        System.out.println();
    }

    @AfterEach // 각 테스트 메서드 실행 후
    void afterEach() {
        System.out.println("## AfterEach Annotation 호출 ##");
        System.out.println();
    }

    @Test
    void test1() {
        System.out.println("## test1 시작 ##");
        System.out.println();
    }

    @Test
    @DisplayName("Test Case 2!!!")
    void test2() {
        System.out.println("## test2 시작 ##");
        System.out.println();
    }

    @Test
    @Disabled // 테스트 실행X
    void test3() {
        System.out.println("## test3 시작 ##");
        System.out.println();
    }
}
