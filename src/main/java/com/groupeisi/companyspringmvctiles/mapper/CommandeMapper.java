package com.groupeisi.companyspringmvctiles.mapper;

import com.groupeisi.companyspringmvctiles.dto.CommandeDto;
import com.groupeisi.companyspringmvctiles.entities.CommandeEntity;
import com.groupeisi.companyspringmvctiles.entities.PanierEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CommandeMapper {

    private CommandeMapper() {}

    public static CommandeEntity toCommandeEntity(CommandeDto commandeDto, PanierEntity panierEntity) {

        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setId(commandeDto.getId());
        commandeEntity.setDate(commandeDto.getDate());
        commandeEntity.setPanier(panierEntity);

        return commandeEntity;
    }

    public static CommandeDto toCommandeDto(CommandeEntity commandeEntity) {
        CommandeDto commandeDto = new CommandeDto();
        commandeDto.setId(commandeEntity.getId());
        commandeDto.setDate(commandeEntity.getDate());
        commandeDto.setPanierId(commandeEntity.getPanier().getId());

        return commandeDto;
    }

    public static List<CommandeEntity> toListCommandeEntity(List<CommandeDto> commandeDtos, PanierEntity panierEntity) {
        return commandeDtos.stream()
                .map(dto -> toCommandeEntity(dto, panierEntity))
                .collect(Collectors.toList());
    }

    public static List<CommandeDto> toListCommandeDto(List<CommandeEntity> commandeEntities) {
        return commandeEntities.stream()
                .map(CommandeMapper::toCommandeDto)
                .collect(Collectors.toList());
    }
}
