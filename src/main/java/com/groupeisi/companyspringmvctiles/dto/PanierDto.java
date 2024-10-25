package com.groupeisi.companyspringmvctiles.dto;

import java.util.Date;
import java.util.List;

public class PanierDto {
    private Long id;
    private Date date;
    private Long clientId;
    private List<String> productRefs;

    public PanierDto() {}

    public PanierDto(Long id, Date date, Long clientId, List<String> productRefs) {
        this.id = id;
        this.date = date;
        this.clientId = clientId;
        this.productRefs = productRefs;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<String> getProductRefs() {
        return productRefs;
    }

    public void setProductRefs(List<String> productRefs) {
        this.productRefs = productRefs;
    }
}
