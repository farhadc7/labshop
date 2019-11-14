package com.farhad.labShop.Service;

import com.farhad.labShop.Repository.OrderRepository;
import com.farhad.labShop.entity.DetailOrder;
import com.farhad.labShop.entity.Order;
import com.farhad.labShop.entity.PaymentType;
import com.farhad.labShop.entity.ProductUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AddNewOrderService {
    OrderRepository orderRepository;
    Order order;
    DetailOrder detailOrder1;
    @Autowired
    public AddNewOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.order = new Order();
        this.detailOrder1 = new DetailOrder();
    }

    public void setOrder(){
        order=new Order(2l, LocalDate.now(), PaymentType.cash, "20","1500");
        order.setOrderDiscount("88");
       // DetailOrder detailOrder1=new DetailOrder(11l, ProductUnit.ADDAD,3,new "230","0","690");
        detailOrder1.setOrder(order);
        order.getDetailOrders().add(detailOrder1);
        orderRepository.save(order);
    }
}
