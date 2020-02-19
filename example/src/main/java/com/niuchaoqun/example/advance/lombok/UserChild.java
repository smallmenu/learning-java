package com.niuchaoqun.example.advance.lombok;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserChild extends User {
    private Integer age;
}
