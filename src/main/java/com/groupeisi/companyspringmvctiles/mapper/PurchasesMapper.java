package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.PurchasesDto;
import com.groupeisi.companyspringmvctiles.entities.PurchasesEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PurchasesMapper {
    private PurchasesMapper() {
    }

    public static PurchasesEntity toPurchasesEntity(PurchasesDto purchasesDto) {

        PurchasesEntity purchasesEntity = new PurchasesEntity();

        purchasesEntity.setId(purchasesDto.getId());
        purchasesEntity.setDateP(purchasesDto.getDateP());
        purchasesEntity.setQuantity(purchasesDto.getQuantity());
        purchasesEntity.setProduct(ProductMapper.toProductEntity(purchasesDto.getProduct()));

        return purchasesEntity;
    }

    public static PurchasesDto toPurchasesDto(PurchasesEntity purchasesEntity) {

        PurchasesDto purchasesDto = new PurchasesDto();

        purchasesDto.setId(purchasesEntity.getId());
        purchasesDto.setDateP(purchasesEntity.getDateP());
        purchasesDto.setQuantity(purchasesEntity.getQuantity());
        purchasesDto.setProduct(ProductMapper.toProductDto(purchasesEntity.getProduct()));

        return purchasesDto;
    }

    public static List<PurchasesDto> toListPurchasesDto(List<PurchasesEntity> purchasesEntities) {
        return purchasesEntities.stream()
                .map(PurchasesMapper::toPurchasesDto)
                .collect(Collectors.toList());
    }
}
