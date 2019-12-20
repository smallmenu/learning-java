package com.niuchaoqun.example.advance.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

/**
 * @JsonIgnoreProperties 忽略无法对应的属性
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
public class JacksonObject {
    private Integer id;

    private String name;

    private Optional<String> title;
}
