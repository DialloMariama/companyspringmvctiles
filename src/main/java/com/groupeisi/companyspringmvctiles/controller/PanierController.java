package com.groupeisi.companyspringmvctiles.controller;

import com.groupeisi.companyspringmvctiles.dto.ClientDto;
import com.groupeisi.companyspringmvctiles.dto.PanierDto;
import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PanierController {

    private static final Logger logger = LoggerFactory.getLogger(PanierController.class);

    private final IPanierService panierService = new PanierService();

    private final IClientService clientService = new ClientService();

    private final IProductService productService = new ProductService();

    @GetMapping("/public/paniers")
    public String GetPaniers(Model model) {
        try {
            Optional<List<PanierDto>> paniers = panierService.findAll();
            model.addAttribute("panierList", paniers.orElseThrow());

            Optional<List<ClientDto>> clientList = clientService.findAll();
            model.addAttribute("clientList", clientList);

            Optional<List<ProductDto>> productList = productService.findAll();
            model.addAttribute("productList", productList);

        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des paniers", e);
        }

        return "paniers";
    }

    @PostMapping("/paniers")
    public String savePanier(@RequestParam("clientId") Long clientId,
                             @RequestParam("productRefs") List<String> productRefs,
                             Model model) {
        logger.info("Enregistrement d'un panier par le client : {}", clientId);

        if (clientId == null) {
            logger.error("L'ID du client est nul");
            return "redirect:/public/paniers";
        }

        if (productRefs == null || productRefs.isEmpty()) {
            logger.error("Liste des produits vide");
            return "redirect:/public/paniers";
        }

        try {
            PanierDto panierDto = new PanierDto();
            panierDto.setClientId(clientId);
            panierDto.setProductRefs(productRefs);

            boolean success = panierService.save(panierDto);
            if (!success) {
                logger.error("Échec de l'enregistrement du panier");
                return "redirect:/public/paniers";
            }

            logger.info("Panier enregistré avec succès : {}", clientId);
        } catch (Exception e) {
            logger.error("Erreur lors de l'enregistrement du panier", e);
            return "redirect:/public/paniers";
        }

        return "redirect:/public/paniers";
    }
}
