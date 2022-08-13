package com.spring.guide.guide.five.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Schema(description = "사람")
public class Person {

    @Schema(description = "사람이름")
    private String name = "sample";

    @Schema(description = "사람메일")
    private String mail = "sample@example.com";
}
