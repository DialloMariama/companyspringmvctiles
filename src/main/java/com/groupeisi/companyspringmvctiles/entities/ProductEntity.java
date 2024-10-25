package com.groupeisi.companyspringmvctiles.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductEntity implements Serializable {
    @Id
    @Column(name = "ref", nullable = false, unique = true)
    private String ref;

    @Column(name = "name")
    private String name;

    @Column()
    private double stock;

    @OneToMany(mappedBy = "product")
    private List<PurchasesEntity> purchases;

    @OneToMany(mappedBy = "product")
    private List<SalesEntity> sales;

    public ProductEntity() {
    }

    public ProductEntity(String ref, String name, double stock, List<PurchasesEntity> purchases, List<SalesEntity> sales) {
        this.ref = ref;
        this.name = name;
        this.stock = stock;
        this.purchases = purchases;
        this.sales = sales;
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

    public List<PurchasesEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchasesEntity> purchases) {
        this.purchases = purchases;
    }

    public List<SalesEntity> getSales() {
        return sales;
    }

    public void setSales(List<SalesEntity> sales) {
        this.sales = sales;
    }
}
