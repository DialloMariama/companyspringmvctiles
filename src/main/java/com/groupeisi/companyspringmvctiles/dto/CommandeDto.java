package com.groupeisi.companyspringmvctiles.dto;
import java.util.Date;

public class CommandeDto {
    private Long id;
    private Date date;
    private Long panierId;

    public CommandeDto() {}

    public CommandeDto(Long id, Date date, Long panierId) {
        this.id = id;
        this.date = date;
        this.panierId = panierId;
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

    public Long getPanierId() {
        return panierId;
    }

    public void setPanierId(Long panierId) {
        this.panierId = panierId;
    }
}
