package com.farhad.labShop.util;

import com.farhad.labShop.entity.PaymentType;
import com.farhad.labShop.entity.ProductUnit;

import java.math.BigDecimal;
import java.math.BigInteger;

////singletone
public class DeserializerUtil<T extends Object> {
    private  T result=null;
    private  static DeserializerUtil instance;
    private static DeserializerUtil sync =new DeserializerUtil();

    private DeserializerUtil(){

    }
    public static DeserializerUtil createInstance(){
        if(instance == null){
            synchronized (sync){
                if(instance ==null){
                    instance= new DeserializerUtil();
                    return instance;
                }else return instance;
            }
        }else{
            return instance;
        }
    }

    public  T convert(String text, Class<T> clazz){
        String tempText=text;
        if(text.equals("-")) tempText ="0";
       if(clazz.isAssignableFrom(BigInteger.class)){
           BigDecimal temp= new BigDecimal(tempText);
           result=(T)temp.toBigInteger(); ////errror
       }else if(clazz ==(Long.TYPE)){
          result=(T)((Long)Float.valueOf(tempText).longValue());
       }else if(clazz.isAssignableFrom(Integer.TYPE)){
           result=(T)((Integer)Float.valueOf(tempText).intValue());
       }else if(clazz.isAssignableFrom(String.class)){
           result = (T)(tempText);
       }else if( clazz.isAssignableFrom(PaymentType.class)){
           result=(T)(PaymentType.valueOf(tempText));
       }else if( clazz.isAssignableFrom(ProductUnit.class)){
           result=(T)(ProductUnit.valueOf(tempText));
       }
       return result;
    }
}
