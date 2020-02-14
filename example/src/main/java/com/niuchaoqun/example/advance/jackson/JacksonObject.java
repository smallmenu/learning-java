package com.niuchaoqun.example.advance.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @JsonIgnoreProperties 忽略无法对应的属性
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JacksonObject {
    private Integer id;

    private String name;

    private Optional<String> title;
}
