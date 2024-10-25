package com.groupeisi.companyspringmvctiles.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.groupeisi.companyspringmvctiles.dto.ProductDto;
import com.groupeisi.companyspringmvctiles.dto.PurchasesDto;
import com.groupeisi.companyspringmvctiles.service.IProductService;
import com.groupeisi.companyspringmvctiles.service.IPurchasesService;
import com.groupeisi.companyspringmvctiles.service.ProductService;
import com.groupeisi.companyspringmvctiles.service.PurchasesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PurchasesController {
    private static final Logger logger = LoggerFactory.getLogger(PurchasesController.class);

    private final IPurchasesService purchasesService = new PurchasesService();
    private final IProductService productService = new ProductService();

    @GetMapping("/purchases")
    public String showPurchases(Model model) {
        logger.info("PurchasesController - showPurchases");

        try {
            Optional<List<PurchasesDto>> purchases = purchasesService.findAll();
            model.addAttribute("purchasesList", purchases.orElse(new ArrayList<>()));

            Optional<List<ProductDto>> products = productService.findAll();
            model.addAttribute("productList", products.orElse(new ArrayList<>()));
        } catch (Exception e) {
            logger.error("Erreur lors de la récupération des données", e);
        }

        return "purchases";
    }

    @PostMapping("/purchases")
    public String savePurchase(
            @RequestParam("productRef") String productRef,
            @RequestParam("quantity") double quantity) {
        logger.info("PurchasesController - savePurchase");

        logger.debug("Paramètres reçus : productRef={}, quantity={}", productRef, quantity);

        Optional<ProductDto> productOptional = productService.findByRef(productRef);

        if (productOptional.isPresent()) {
            ProductDto productDto = productOptional.get();

            PurchasesDto purchasesDto = new PurchasesDto();
            purchasesDto.setProduct(productDto);
            purchasesDto.setQuantity(quantity);

            try {
                purchasesService.save(purchasesDto);
                logger.info("Achat enregistré avec succès");
            } catch (Exception e) {
                logger.error("Erreur lors de l'enregistrement de l'achat", e);
            }
        } else {
            logger.error("Produit non trouvé avec la référence ");
        }

        return "redirect:/purchases";
    }
}

