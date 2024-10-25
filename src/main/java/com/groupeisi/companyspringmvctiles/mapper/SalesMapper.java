package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.SalesDto;
import com.groupeisi.companyspringmvctiles.entities.SalesEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SalesMapper {

    private SalesMapper() {
    }

    public static SalesEntity toSalesEntity(SalesDto salesDto) {
        SalesEntity sales = new SalesEntity();
        sales.setId(salesDto.getId());
        sales.setDateP(salesDto.getDateP());
        sales.setQuantity(salesDto.getQuantity());
        sales.setProduct(ProductMapper.toProductEntity(salesDto.getProduct()));
        return sales;
    }

    public static SalesDto toSalesDto(SalesEntity sales) {
        SalesDto salesDto = new SalesDto();
        salesDto.setId(sales.getId());
        salesDto.setDateP(sales.getDateP());
        salesDto.setQuantity(sales.getQuantity());
        salesDto.setProduct(ProductMapper.toProductDto(sales.getProduct()));
        return salesDto;
    }

    public static List<SalesDto> toListSalesDto(List<SalesEntity> salesList) {
        return salesList.stream()
                .map(SalesMapper::toSalesDto)
                .collect(Collectors.toList());
    }
}
