package com.groupeisi.companyspringmvctiles.service;

import com.groupeisi.companyspringmvctiles.dao.*;
import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.entities.PanierEntity;
import com.groupeisi.companyspringmvctiles.entities.ClientEntity;
import com.groupeisi.companyspringmvctiles.entities.ProductEntity;
import com.groupeisi.companyspringmvctiles.mapper.PanierMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PanierService implements IPanierService {

    private static final Logger logger = LoggerFactory.getLogger(PanierService.class);

    private final IPanierDao panierDao = new PanierDao();
    private final IClientDao clientDao = new ClientDao();
    private final IProductDao productDao = new ProductDao();

    @Override
    public Optional<List<PanierDto>> findAll() {
        List<PanierEntity> panierEntities = panierDao.list(new PanierEntity());
        List<PanierDto> panierDtos = PanierMapper.toListPanierDto(panierEntities);
        return Optional.of(panierDtos);
    }

    @Override
    public boolean save(PanierDto panierDto) {
        try {
            Optional<ClientEntity> clientOpt = clientDao.findById(panierDto.getClientId());
            if (clientOpt.isEmpty()) {
                throw new EntityNotFoundException("Client non trouvé : " + panierDto.getClientId());
            }

            for (String productRef : panierDto.getProductRefs()) {
                Optional<ProductEntity> productOpt = productDao.findByRef(productRef);
                if (productOpt.isEmpty()) {
                    throw new EntityNotFoundException("Produit non trouvé: " + productRef);
                }
            }

            PanierEntity panierEntity = PanierMapper.toPanierEntity(panierDto, clientOpt.get());
            return panierDao.save(panierEntity);
        } catch (Exception e) {
            logger.error("Erreur lors de l'enregistrement du panier", e);
            return false;
        }
    }

    @Override
    public boolean updatePanier(PanierDto panierDto) {
        logger.info("Mise à jour du panier : {}", panierDto);
        try {
            Optional<ClientEntity> clientOpt = clientDao.findById(panierDto.getClientId());
            if (clientOpt.isEmpty()) {
                throw new EntityNotFoundException("Client non trouvé: " + panierDto.getClientId());
            }

            PanierEntity panierEntity = PanierMapper.toPanierEntity(panierDto, clientOpt.get());
            return panierDao.update(panierEntity);
        } catch (Exception e) {
            logger.error("Erreur lors de la mise à jour du panier", e);
            return false;
        }
    }
}
