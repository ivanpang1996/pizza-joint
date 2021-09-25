package com.web.pizzajoint.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T fromJSON(String json, Class<T> object) {
        try {
            return mapper.readValue(json, object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("json is not valid");
        }
    }

    public static <T> T fromJSON(String json, TypeReference<T> object) {
        try {
            return mapper.readValue(json, object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("json is not valid");
        }
    }

    public static String toJSON(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("json is not valid");
        }
    }

}
