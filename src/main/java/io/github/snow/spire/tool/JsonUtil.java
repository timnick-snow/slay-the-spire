package io.github.snow.spire.tool;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.DurationDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.DurationSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * json工具类
 *
 * @author Arnold
 */
public class JsonUtil {

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        javaTimeModule.addSerializer(Duration.class, DurationSerializer.INSTANCE);

        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
        javaTimeModule.addDeserializer(Duration.class, DurationDeserializer.INSTANCE);

        OBJECT_MAPPER.registerModule(javaTimeModule);
        OBJECT_MAPPER.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        OBJECT_MAPPER.enable(JsonParser.Feature.ALLOW_COMMENTS);
        OBJECT_MAPPER.enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
        OBJECT_MAPPER.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
    }

    /**
     * 初始化 objectMapper 属性
     * <p>
     * 通过这样的方式，使用 Spring 创建的 ObjectMapper Bean
     *
     * @param objectMapper ObjectMapper 对象
     */
    public static void init(ObjectMapper objectMapper) {
        JsonUtil.OBJECT_MAPPER = objectMapper;
    }

    /**
     * 获取 ObjectMapper 的 TypeFactory 处理泛型
     *
     * @return TypeFactory 类型实例工工厂
     */
    public static TypeFactory getTypeFactory() {
        return OBJECT_MAPPER.getTypeFactory();
    }

    public static ObjectMapper getInstance() {
        return OBJECT_MAPPER;
    }

    public static ObjectMapper getInstanceCopy() {
        return OBJECT_MAPPER.copy();
    }

    public static String toJsonString(Object object) {
        try {
            if (Objects.isNull(object)) {
                return null;
            }
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static byte[] toJsonByte(Object object) {
        try {
            if (Objects.isNull(object)) {
                return null;
            }
            return OBJECT_MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    /**
     * deserialize JSON as tree building by JsonNode
     */
    public static JsonNode parse(String text) {
        try {
            if (ObjectUtils.isEmpty(text)) {
                return null;
            }
            return OBJECT_MAPPER.readTree(text);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    /**
     * deserialize JSON as tree building by JsonNode
     */
    public static JsonNode parse(InputStream in) {
        try {
            if (Objects.isNull(in)) {
                return null;
            }
            return OBJECT_MAPPER.readTree(in);
        } catch (Exception e) {
            throw new RuntimeException("json handle exception", e);
        }
    }


    public static ObjectNode parseToObject(String json) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return (ObjectNode) OBJECT_MAPPER.readTree(json);
        } catch (Exception e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToObject(String json, Class<T> clazz) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToObject(String json, JavaType valueType) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToObject(String json, TypeReference<T> typeReference) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToObject(byte[] bytes, Class<T> clazz) {
        try {
            if (ObjectUtils.isEmpty(bytes)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(bytes, clazz);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToObject(byte[] bytes, JavaType valueType) {
        try {
            if (ObjectUtils.isEmpty(bytes)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(bytes, valueType);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToObject(byte[] bytes, TypeReference<T> typeReference) {
        try {
            if (ObjectUtils.isEmpty(bytes)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(bytes, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToMap(Object object, MapType mapType) {
        try {
            if (Objects.isNull(object)) {
                return null;
            }
            return OBJECT_MAPPER.convertValue(object, mapType);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T extends Map<?, ?>> T parseToMap(Object object, TypeReference<T> typeReference) {
        try {
            if (Objects.isNull(object)) {
                return null;
            }
            return OBJECT_MAPPER.convertValue(object, typeReference);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    @SuppressWarnings("rawtypes")
    public static <T> T parseToMap(Object object, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        try {
            if (Objects.isNull(object)) {
                return null;
            }
            MapType mapType = getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
            return OBJECT_MAPPER.convertValue(object, mapType);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> T parseToMap(String json, MapType mapType) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, mapType);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T extends Map<?, ?>> T parseToMap(String json, TypeReference<T> typeReference) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    @SuppressWarnings("rawtypes")
    public static <T> T parseToMap(String json, Class<? extends Map> mapClass, Class<?> keyClass, Class<?> valueClass) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            MapType mapType = getTypeFactory().constructMapType(mapClass, keyClass, valueClass);
            return OBJECT_MAPPER.readValue(json, mapType);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static ArrayNode parseToArray(String json) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return (ArrayNode) OBJECT_MAPPER.readTree(json);
        } catch (Exception e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> List<T> parseToArray(String json, Class<T> clazz) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class,
                    clazz));
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> List<T> parseToArray(String json, CollectionType collectionType) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, collectionType);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T extends List<?>> T parseToArray(String json, TypeReference<T> typeReference) {
        try {
            if (ObjectUtils.isEmpty(json)) {
                return null;
            }
            return OBJECT_MAPPER.readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> List<T> parseToArray(Object object, Class<T> clazz) {
        try {
            if (Objects.isNull(object)) {
                return Collections.emptyList();
            }
            return OBJECT_MAPPER.convertValue(object, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class,
                    clazz));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T> List<T> parseToArray(Object object, CollectionType collectionType) {
        try {
            if (Objects.isNull(object)) {
                return Collections.emptyList();
            }
            return OBJECT_MAPPER.convertValue(object, collectionType);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static <T extends List<?>> T parseToArray(Object object, TypeReference<T> typeReference) {
        try {
            if (Objects.isNull(object)) {
                return null;
            }
            return OBJECT_MAPPER.convertValue(object, typeReference);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    /**
     * 此方法只是对象转换为另一个对象之间的转换，切记不能 string 到 object
     */
    public static <T> T convertValue(Object fromValue, Class<T> valueType) {
        try {
            if (Objects.isNull(fromValue)) {
                return null;
            }
            return OBJECT_MAPPER.convertValue(fromValue, valueType);
        } catch (Exception e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    /**
     * 此方法只是对象转换为另一个对象之间的转换，切记不能 string 到 object
     */
    public static <T> T convertValue(Object fromValue, JavaType valueType) {
        try {
            if (Objects.isNull(fromValue)) {
                return null;
            }
            return OBJECT_MAPPER.convertValue(fromValue, valueType);
        } catch (Exception e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    /**
     * 此方法只是对象转换为另一个对象之间的转换，切记不能 string 到 object
     */
    public static <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        try {
            if (Objects.isNull(fromValue)) {
                return null;
            }
            return OBJECT_MAPPER.convertValue(fromValue, toValueTypeRef);
        } catch (Exception e) {
            throw new RuntimeException("json handle exception", e);
        }
    }

    public static void writeValue(OutputStream out, Object value) {
        try {
            OBJECT_MAPPER.writer().writeValue(out, value);
        } catch (Exception e) {
            throw new RuntimeException("json handle exception", e);
        }
    }
}
