package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dao.ClientDao;
import com.groupeisi.companyspringmvctiles.dao.IClientDao;
import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.mapper.ClientMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    private final IClientDao clientDao = new ClientDao();

    @Override
    public Optional<List<ClientDto>> findAll() {
        List<ClientEntity> clientEntities = clientDao.list(new ClientEntity());
        List<ClientDto> clientDtos = ClientMapper.toListClientDto(clientEntities);
        return Optional.of(clientDtos);
    }

    @Override
    public boolean save(ClientDto clientDto) {
        logger.info("Enregistrement d'un client : {}", clientDto);
        ClientEntity clientEntity = ClientMapper.toClientEntity(clientDto);
        return clientDao.save(clientEntity);
    }

    @Override
    public boolean update(ClientDto clientDto) {
        logger.info("Modification des informations d'un client : {}", clientDto);
        ClientEntity clientEntity = ClientMapper.toClientEntity(clientDto);
        return clientDao.update(clientEntity);
    }
}
