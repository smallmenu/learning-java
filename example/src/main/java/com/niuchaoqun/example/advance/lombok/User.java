package com.niuchaoqun.example.advance.lombok;

import lombok.*;

/**
 * @NoArgsConstructor
 * 提供一个无参数构造器。
 * 如果我们需要使用到单例模式（很少，一般使用 Lombok 都是用作POJO、DTO），可以设置 (access = AccessLevel.PRIVATE)。
 * 如果包含 final 成员，会导致编译错误。可以强制使用 (force = true)，从而对 final 进行默认初始化（0/false/null）。
 * 对 @NonNull 注解的字段，不做任何检查。
 *
 * @RequiredArgsConstructor
 * 提供无参数或有参数的构造器。
 * 当包含 final 成员，和 @NonNull 注解的字段，会生成带参数的构造器。
 * 所以这个注解相对使用起来比 @NoArgsConstructor 安全
 *
 * @AllArgsConstructor
 * 提供一个全参数的构造器。
 *
 * @Data
 * 组合了这些注解 @ToString、@EqualsAndHashCode、@Getter、@Setter、@RequiredArgsConstructor
 *
 * @Builder
 * 提供了建造者模式。会默认生成一个私有的 @AllArgsConstructor
 * 作者认为使用 @Builder，原则上你不太需要使用  new 来进行。但是很多框架是使用反射无参构造器来创建对象。
 *
 * 解决：如果有问题，可以手动增加 @NoArgsConstructor/@AllArgsConstructor 注解
 *
 * @Builder.Default
 * 指定建造者模式的默认值，否则未初始化的值默认是 null
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    protected Integer id;

    @Builder.Default
    protected String name = "默认";
}
