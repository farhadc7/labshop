package com.farhad.labShop.jsonDeserializer;

import com.farhad.labShop.entity.DetailOrder;
import com.farhad.labShop.entity.Order;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.List;

public class Mapper<T> {
    private Mapper(){}
    private final static ObjectMapper mapper=new ObjectMapper();
    private final static SimpleModule module=new SimpleModule();
    public static ObjectMapper getMapper(){
        Class<List<DetailOrder>> clazz=(Class)List.class;
        module.addDeserializer(Order.class, new OrderDeserializer());
        module.addDeserializer(DetailOrder.class, new DetailOrderDeserializer());
        mapper.registerModule(module);
        return mapper;
    }

}
