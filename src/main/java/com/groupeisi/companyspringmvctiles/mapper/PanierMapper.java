package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.entities.PanierEntity;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;

import java.util.List;
import java.util.stream.Collectors;

public class PanierMapper {

    private PanierMapper() {}

    public static PanierEntity toPanierEntity(PanierDto panierDto, ClientEntity client) {
        PanierEntity panierEntity = new PanierEntity();

        panierEntity.setId(panierDto.getId());
        panierEntity.setDate(panierDto.getDate());
        panierEntity.setClient(client);
        List<ProductEntity> productEntities = panierDto.getProductRefs()
                .stream()
                .map(ref -> {
                    ProductEntity productEntity = new ProductEntity();
                    productEntity.setRef(ref);
                    return productEntity;
                })
                .collect(Collectors.toList());
        panierEntity.setProducts(productEntities);
        panierEntity.setProducts(productEntities);

        return panierEntity;
    }

    public static PanierDto toPanierDto(PanierEntity panierEntity) {
        PanierDto panierDto = new PanierDto();

        panierDto.setId(panierEntity.getId());
        panierDto.setDate(panierEntity.getDate());
        panierDto.setClientId(panierEntity.getClient().getId());
        List<ProductDto> productDtos = ProductMapper.toListProductDto(panierEntity.getProducts());
        List<String> productRefs = panierEntity.getProducts()
                .stream()
                .map(ProductEntity::getRef)
                .collect(Collectors.toList());
        panierDto.setProductRefs(productRefs);

        return panierDto;
    }

    public static List<PanierDto> toListPanierDto(List<PanierEntity> panierEntities) {
        return panierEntities.stream()
                .map(PanierMapper::toPanierDto)
                .collect(Collectors.toList());
    }

    public static List<PanierEntity> toListPanierEntity(List<PanierDto> panierDtos, ClientEntity client) {
        return panierDtos.stream()
                .map(dto -> toPanierEntity(dto, client))
                .collect(Collectors.toList());
    }
}
