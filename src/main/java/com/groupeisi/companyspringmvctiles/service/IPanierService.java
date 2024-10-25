package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dto.PanierDto;

import java.util.List;
import java.util.Optional;

public interface IPanierService {
    Optional<List<PanierDto>> findAll();
    boolean save(PanierDto panierDto);
    boolean updatePanier(PanierDto panierDto);
}
