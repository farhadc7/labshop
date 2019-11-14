package com.farhad.labShop.jsonDeserializer;

import com.farhad.labShop.entity.Order;
import com.farhad.labShop.entity.PaymentType;
import com.farhad.labShop.util.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import jdk.nashorn.internal.ir.ObjectNode;

import java.io.IOException;
import java.time.LocalDate;


public class OrderDeserializer  extends StdDeserializer<Order>  {

    protected OrderDeserializer(Class<?> vc) {
        super(vc);
    }
    protected OrderDeserializer() {
        this(null);
    }
    @Override
    public Order deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ObjectCodec objectCodec=p.getCodec();
         JsonNode node= objectCodec.readTree(p);
        System.out.println(node);


        LocalDate date= DateUtil.convert(node.path("date").asText());

        Float supplierId = (Float.parseFloat(node.path("supplierId").asText()));
        PaymentType paymentType =PaymentType.valueOf(node.path("paymentType").asText());
        String orderDiscount= node.path("orderDiscount").asText();
        String totalPrice= node.path("totalPrice").asText();

        return new Order(supplierId.longValue(),date,paymentType,orderDiscount,totalPrice);
    }
}
