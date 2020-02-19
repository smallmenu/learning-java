package com.niuchaoqun.example.advance;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.niuchaoqun.example.advance.jackson.JacksonBean;
import com.niuchaoqun.example.advance.jackson.JacksonObject;
import com.niuchaoqun.example.advance.lombok.UserChildBuilder;
import com.niuchaoqun.example.advance.lombok.UserJson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class JacksonExample {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void run(String[] args) {
        lombokExample();
        simpleExample();
        jsonDecode();
        jsonObject();
        jdk8();
    }

    public static void lombokExample() {
        try {
            UserJson userJson = UserJson.builder().id(1).name("").build();
            String json = mapper.writeValueAsString(userJson);
            System.out.println(json);
            UserJson user = mapper.readValue(json, UserJson.class);
            System.out.println(user);

            UserChildBuilder userChild = UserChildBuilder.builder().id(1).name("名字").age(1).build();
            String userChildJson = mapper.writeValueAsString(userChild);
            System.out.println(userChildJson);
            UserChildBuilder userChildResult = mapper.readValue(userChildJson, UserChildBuilder.class);
            System.out.println(userChildResult);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void simpleExample() {
        try {
            int[] ints1 = {1, 2, 3};
            String intJson = mapper.writeValueAsString(ints1);
            int[] ints = mapper.readValue(intJson, int[].class);
            System.out.println(intJson);
            System.out.println(Arrays.toString(ints));

            ArrayList<String> list = new ArrayList<>();
            list.add("one");
            list.add("two");
            list.add("three");
            String listJson = mapper.writeValueAsString(list);
            System.out.println(listJson);
            Object listObject = mapper.readValue(listJson, new TypeReference<List<String>>() {
            });
            System.out.println(listObject);

            Map<String, String> map = new HashMap<>();
            map.put("k1", "v1，中文");
            map.put("k2", "v2");
            map.put("k3", "v3");
            String mapJson = mapper.writeValueAsString(map);
            System.out.println(mapJson);
            Map<String, String> mapObject = mapper.readValue(mapJson, new TypeReference<Map<String, String>>() {
            });
            System.out.println(mapObject);

            // 不规范的Json字符串： [1,"2"]
            ArrayNode arrayNode1 = mapper.createArrayNode();
            arrayNode1.add(1);
            arrayNode1.add("2");
            System.out.println(arrayNode1.toString());
            String json1 = mapper.writeValueAsString(arrayNode1);
            System.out.println(json1);

            // 不规范的Json字符串： [1,"2",{"age":10,"name":"zhang"},{"age":11,"name":"li"}]
            // Jackson 同样能很好的处理这种情况，不需要额外的 class
            ArrayNode arrayNode2 = mapper.createArrayNode();
            arrayNode2.add(1);
            arrayNode2.add("2");
            ObjectNode o1 = mapper.createObjectNode();
            o1.put("name", "zhang");
            o1.put("age", 10);
            ObjectNode o2 = mapper.createObjectNode();
            o2.put("name", "li");
            o2.put("age", 11);
            arrayNode2.add(o1);
            arrayNode2.add(o2);
            String json2 = mapper.writeValueAsString(arrayNode2);
            System.out.println(json2);

            // 解析很方便
            JsonNode jsonNode = mapper.readTree(json2);
            System.out.println(jsonNode.get(0));
            System.out.println(jsonNode.get(1));
            System.out.println(jsonNode.get(2).get("name"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=====");

    }

    public static void jsonDecode() {
        try {
            String json2 = "[1,\"2\"]";
            JsonNode json2Tree = mapper.readTree(json2);
            int one = json2Tree.get(0).asInt();
            String two = json2Tree.get(1).asText();
            System.out.println(one);
            System.out.println(two);


            String json3 = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
            JsonNode json3Node = mapper.readTree(json3);
            String k1 = json3Node.get("k1").asText();
            String k2 = json3Node.get("k2").asText();
            System.out.println(k1);
            System.out.println(k2);

            String json5 = "{\"code\":0,\"data1\":{\"key\":\"value\"},\"msg\":\"ok\"}";
            JsonNode json5Node = mapper.readTree(json5);
            String dataKey = json5Node.get("data1").get("key").asText();
            System.out.println(dataKey);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("=====");
    }

    public static void jsonObject() {
        try {
            List<String> lists = new ArrayList<>();
            lists.add("one");
            lists.add("two");
            lists.add("three");
            HashMap<String, String> maps = new HashMap<>();
            maps.put("key1", "value1");
            maps.put("key2", "value2");
            maps.put("key2", "value2");
            Set<String> sets = new HashSet<>();
            sets.add("set1");
            sets.add("set2");
            sets.add("set3");

            JacksonBean jacksonBean = JacksonBean.builder()
                    .id(5)
                    .nonNull(null)
                    .name("zhangsan，中国")
                    .time(LocalDateTime.now())
                    .changeName("changeValue")
                    .lists(lists)
                    .maps(maps)
                    .sets(sets)
                    .build();

            String json = mapper.writeValueAsString(jacksonBean);
            System.out.println(json);

            JacksonBean jacksonBeanDecode = mapper.readValue(json, JacksonBean.class);
            System.out.println(jacksonBeanDecode);

        } catch (IOException e) {

        }

        System.out.println("=====");
    }

    public static void jdk8() {
        try {
            /**
             * 兼容 JDK8 Optional 类型
             */
            mapper.registerModule(new Jdk8Module());

            JacksonObject jacksonObject = JacksonObject.builder()
                    .id(2)
                    .name("张三")
                    .title(Optional.of("标题"))
                    .build();
            String json = mapper.writeValueAsString(jacksonObject);
            System.out.println(json);

            JacksonObject jacksonObjectDecode1 = mapper.readValue(json, JacksonObject.class);
            System.out.println(jacksonObjectDecode1);


            /**
             * 忽略 json 中无法对应的属性，通过：
             *
             * new ObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
             *
             * 等同于 @JsonIgnoreProperties(ignoreUnknown = true)
             *
             * 两种情况：
             * 1. json 中多了 Bean 中未定义的字段，会报 Unrecognized field 异常，
             * 2. json 中少了 Bean 中已定义的字段 （不受影响，会被映射会 Null）
             *
             */
            // String json1 = "{\"id\":2,\"name\":\"张三\",\"title\":\"标题\", \"desc\":\"摘要\"}";
            //             // JacksonObject jacksonObjectDecode2 = mapper.readValue(json1, JacksonObject.class);
            //             // System.out.println(jacksonObjectDecode2);

            String json2 = "{\"id\":2,\"name\":\"张三\", \"a\":\"b\"}";
            JacksonObject jacksonObjectDecode3 = mapper.readValue(json2, JacksonObject.class);
            System.out.println(jacksonObjectDecode3);

            /**
             * 映射为 Bean 数组，通过 TypeReference 实现。
             */
            String json3 = "[{\"id\":2,\"name\":\"张三\"},{\"id\":3,\"name\":\"李四\"}]";
            List<JacksonObject> jacksonObjects = mapper.readValue(json3, new TypeReference<List<JacksonObject>>() {
            });
            System.out.println(jacksonObjects);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void advance() {
        try {
            String json1 = "{\n" +
                    "    \"employee\":\n" +
                    "    {\n" +
                    "        \"id\": \"1212\",\n" +
                    "        \"fullName\": \"John Miles\",\n" +
                    "        \"age\": 34\n" +
                    "    }\n" +
                    "}";
            String json2 = "{   \n" +
                    "    \"employee\":\n" +
                    "    {\n" +
                    "        \"id\": \"1212\",\n" +
                    "        \"age\": 34,\n" +
                    "        \"fullName\": \"John Miles\"\n" +
                    "    }\n" +
                    "}";

            JsonNode jsonNode1 = mapper.readTree(json1);
            JsonNode jsonNode2 = mapper.readTree(json2);
            System.out.println(jsonNode1.equals(jsonNode2));

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
