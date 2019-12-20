package com.niuchaoqun.example.advance.jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @JsonPropertyOrder 排序
 */
@JsonPropertyOrder({"id", "name", "changeName"})
@Data
@Builder
public class JacksonBean {
    private Integer id;

    private String name;

    /**
     * Json 忽略 Null 值的字段
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nonNull;

    /**
     * Json 忽略该字段
     */
    //@JsonIgnore
    private String ignore;

    /**
     * Json 改变属性名称
     */
    @JsonProperty("changedName")
    private String changeName;

    /**
     * Json 格式化转换，以及序列化转换
     * <p>
     * 如果 Redis 序列化配置相同的转换规则，可以在Redis中存储对象
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime time;

    /**
     * Json 化为数组
     */
    private List<String> lists;

    /**
     * Json 化为数组
     */
    private Set<String> sets;

    /**
     * Json 化为对象
     */
    private Map<String, String> maps;
}
