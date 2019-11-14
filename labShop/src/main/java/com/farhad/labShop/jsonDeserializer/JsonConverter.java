package com.farhad.labShop.jsonDeserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonConverter<T> {
    public  T jsonConverter(String jsonObject,Class<T> typeValue) {
        ObjectMapper mapper = Mapper.getMapper();
        try {
            return mapper.readValue(jsonObject, typeValue );
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }
}
