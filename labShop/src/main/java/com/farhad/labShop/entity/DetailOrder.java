package com.farhad.labShop.entity;


import javax.persistence.*;

@Entity
@Table(name = "detailOrder_tbl")
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private ProductUnit unit;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String fee;
    private String discount;
    @Column(nullable = false)
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="order_id", nullable = false)
    private Order order;

    public DetailOrder() {
    }

    public DetailOrder(Long productId, ProductUnit unit, int quantity, String fee, String discount, String price) {
        this.productId = productId;
        this.unit = unit;
        this.quantity = quantity;
        this.fee = fee;
        this.discount = discount;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductUnit getUnit() {
        return unit;
    }

    public void setUnit(ProductUnit unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
