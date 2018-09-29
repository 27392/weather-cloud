package cn.haohaoli.collection.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author liwenhao
 */
public class JsonUtil {

    public static <T> T toObject (String json, Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String toJsonString (Object o){
        if (o == null) {
            return null;
        }
        if (o instanceof String) {
            return (String) o;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
