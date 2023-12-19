package com.springboot.jpa.config.actuator;

import lombok.Builder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
// 정보 제공 인터페이스 구현체
public class CustomInfoContributor /* implements InfoContributor */ {
//
//    @Override
//    public void contribute(Builder builder) {
//        Map<String, Object> content = new HashMap<>();
//        content.put("code-info", "InfoContributor 구현체에서 정의한 정보입니다.");
//        builder.withDetail("custom-info-contributor", content);
//    }
//
}
