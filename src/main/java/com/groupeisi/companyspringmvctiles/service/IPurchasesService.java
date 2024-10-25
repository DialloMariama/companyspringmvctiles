package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dto.PurchasesDto;

import java.util.List;
import java.util.Optional;


public interface IPurchasesService {

    Optional<List<PurchasesDto>> findAll();

    boolean save(PurchasesDto purchasesDto);

}
