package com.groupeisi.companyspringmvctiles.dto;

public class ProductDto {
    private String ref;
    private String name;
    private double stock;

    public ProductDto() {
    }

    public ProductDto(String ref, String name, double stock) {
        this.ref = ref;
        this.name = name;
        this.stock = stock;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "ref='" + ref + '\'' +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
