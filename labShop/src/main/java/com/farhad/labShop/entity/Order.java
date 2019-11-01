package com.farhad.labShop.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
    @NotNull
    private Long supplierId;
    private LocalDateTime date;
    private PaymentType paymentType;
    private String orderDiscount;
    private String totalPrice;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<DetailOrder> detailOrders =new ArrayList<>();


    public Order(Long supplierId, LocalDateTime date, PaymentType paymentType, String orderDiscount, String totalPrice) {
        this.supplierId = supplierId;
        this.date = date;
        this.paymentType = paymentType;
        this.orderDiscount = orderDiscount;
        this.totalPrice = totalPrice;

    }

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(String orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<DetailOrder> getDetailOrders() {
        return detailOrders;
    }

    public void setDetailOrders(List<DetailOrder> detailOrders) {
        this.detailOrders = detailOrders;
    }
}
