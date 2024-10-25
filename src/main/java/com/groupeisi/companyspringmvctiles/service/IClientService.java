package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dto.ClientDto;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Optional<List<ClientDto>> findAll();
    boolean save(ClientDto clientDto);
    boolean update(ClientDto clientDto);
}
