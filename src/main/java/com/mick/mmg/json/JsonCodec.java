package com.mick.mmg.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonCodec {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    public static <T> String serialize(T toSerialize) {
        try {
            return objectMapper.writeValueAsString(toSerialize);
        } catch (JsonProcessingException e) {
            throw new JsonCodecException(e);
        }
    }

    public static <T> T deserialize(String toDeserialize, Class<T> clazz){
        try {
            return objectMapper.readValue(toDeserialize, clazz);
        } catch (IOException e) {
            throw new JsonCodecException(e);
        }
    }

    public <T> T deserialize(String toDeserialize, TypeReference<T> typeReference){
        try {
            return objectMapper.readValue(toDeserialize, typeReference);
        } catch (IOException e) {
            throw new JsonCodecException(e);
        }
    }
}
