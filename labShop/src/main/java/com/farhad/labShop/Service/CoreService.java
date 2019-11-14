package com.farhad.labShop.Service;

import com.farhad.labShop.View.ExcelUtil;
import com.farhad.labShop.entity.DetailOrder;
import com.farhad.labShop.entity.Order;
import com.farhad.labShop.entity.Tables;
import com.farhad.labShop.jsonDeserializer.JsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CoreService {
    public List<Tables> jsonToModel(){
        List<Tables> tableObjects=new ArrayList<>();
        ExcelUtil excelUtil=ExcelUtil.getExcelUtil("D:\\java\\1.gitHub\\labshop\\labShop\\src\\main\\resources\\labshop.xlsx");
        Map<String, ArrayNode> jsonTables=excelUtil.readWorkbookToJson();
        jsonTables.forEach((k,v) -> {
            if(k.equals("order")){
                JsonConverter<Order> converter= new JsonConverter<>();
                v.forEach(n ->{
                    Class<Order> clazz=Order.class;
                    tableObjects.add(converter.jsonConverter(n.toString(),clazz));
               });
            }else if(k.equals("detailorder")){
                JsonConverter<DetailOrder> converter= new JsonConverter<>();
                v.forEach(n ->{
                    Class<DetailOrder> clazz=DetailOrder.class;
                    System.out.println(n);
                    tableObjects.add(converter.jsonConverter(n.toString(),clazz));
                });
            }
        });
        return tableObjects;
    }

}