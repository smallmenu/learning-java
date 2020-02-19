package com.niuchaoqun.example.advance.lombok;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserChildBuilder extends UserBuilder {
    private Integer age;
}