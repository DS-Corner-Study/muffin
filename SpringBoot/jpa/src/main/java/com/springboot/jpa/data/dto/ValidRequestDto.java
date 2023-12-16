package com.springboot.jpa.data.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidRequestDto {

    @NotBlank
    String name; // null, "", " " 허용 X

    @Email
    String email;

    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    String phoneNumber;

    @Min(value = 20) @Max(value = 40)
    int age; // 20살 이상 40살 이하

    @Size(min = 0, max = 40)
    String description;

    @Positive
    int count; // 0 아닌 양수

    @AssertTrue
    boolean booleanCheck; // true인지 체크

}
