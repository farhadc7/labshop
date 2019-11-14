package com.farhad.labShop.jsonDeserializer;

import com.farhad.labShop.entity.DetailOrder;
import com.farhad.labShop.entity.ProductUnit;
import com.farhad.labShop.util.DeserializerUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.math.BigInteger;

public class DetailOrderDeserializer extends StdDeserializer<DetailOrder> {
    public DetailOrderDeserializer(Class<?> vc) {
        super(vc);
    }
    public DetailOrderDeserializer(){
        this(null);
    }

    @Override
    public DetailOrder deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        DeserializerUtil deserializerUtil = DeserializerUtil.createInstance();
        JsonNode node= p.getCodec().readTree(p);
            Long productId=(Long) deserializerUtil.convert(node.path("productId").asText(),Long.TYPE);
            ProductUnit unit= (ProductUnit) deserializerUtil.convert(node.path("unit").asText().toUpperCase(), ProductUnit.class);
            Integer quantity= (Integer) deserializerUtil.convert(node.path("quantity").asText(), Integer.TYPE);
            BigInteger fee=(BigInteger) deserializerUtil.convert(node.path("fee").asText(), BigInteger.class);
            BigInteger discount=(BigInteger) deserializerUtil.convert(node.path("discount").asText(), BigInteger.class);
            BigInteger price=(BigInteger) deserializerUtil.convert(node.path("price").asText(), BigInteger.class);


        return new DetailOrder(productId, unit,quantity,fee, discount,price);
    }
}
