package com.groupeisi.companyspringmvctiles.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paniers")
public class PanierEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @OneToMany(mappedBy = "panier")
    private List<CommandeEntity> commandes;

    @ManyToMany
    @JoinTable(
            name = "panier_products",
            joinColumns = @JoinColumn(name = "panier_id"),
            inverseJoinColumns = @JoinColumn(name = "product_ref")
    )
    private List<ProductEntity> products;

    public PanierEntity() {}

    public PanierEntity(Date date, ClientEntity client, List<ProductEntity> products) {
        this.date = date;
        this.client = client;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

}
