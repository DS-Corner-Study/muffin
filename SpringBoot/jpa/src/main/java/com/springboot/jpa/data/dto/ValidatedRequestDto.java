package com.springboot.jpa.data.dto;

import com.springboot.jpa.config.annotation.Telephone;
import com.springboot.jpa.data.group.ValidationGroup1;
import com.springboot.jpa.data.group.ValidationGroup2;
import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidatedRequestDto {

    @NotBlank
    private String name;

    @Email
    String email;

    @Telephone
    String phoneNumber;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup1.class)
    private int age;

    @Size(min = 0, max = 40)
    private String description;

    @Positive(groups = ValidationGroup2.class)
    private int count;

    @AssertTrue
    private boolean booleanCheck;

}
