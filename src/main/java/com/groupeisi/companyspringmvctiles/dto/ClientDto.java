package com.groupeisi.companyspringmvctiles.dto;

import java.util.List;

public class ClientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String tel;
    private String address;
    private List<PanierDto> paniers;

    public ClientDto() {}

    public ClientDto(Long id, String firstName, String lastName, String email, String password,  String tel, String address, List<PanierDto> paniers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.address = address;
        this.paniers = paniers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PanierDto> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<PanierDto> paniers) {
        this.paniers = paniers;
    }
}

