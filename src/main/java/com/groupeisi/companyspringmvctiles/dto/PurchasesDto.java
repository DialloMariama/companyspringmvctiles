package com.groupeisi.companyspringmvctiles.dto;

import java.util.Date;

public class PurchasesDto {
    private long id;
    private Date dateP;
    private double quantity;
    private ProductDto product;

    public PurchasesDto() {
        this.dateP = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateP() {
        return dateP;
    }

    public void setDateP(Date dateP) {
        this.dateP = dateP;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }
}
